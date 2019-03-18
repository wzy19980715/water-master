package org.test.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.nutz.dao.Cnd;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.entity.*;
import org.test.enumlist.QuestionEnum;
import org.test.map.*;
import org.test.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Autowired
    AnswerService answerService;

    @Autowired
    CreatorService creatorService;

    @Autowired
    LocationService locationService;

    @Autowired
    QuestionService questionService;

    @Autowired
    RespondsService respondsService;

    @RequestMapping(value = "/upload")
    public int changeInvestigatorId(HttpServletRequest request) throws ParseException, IOException {

        InputStreamReader insr = new InputStreamReader(request.getInputStream(), "UTF-8");
        String result = "";
        int respInt = insr.read();
        while (respInt != -1) {
            result += (char) respInt;
            respInt = insr.read();
        }

        JSONObject jsonO = JSON.parseObject(JSON.parseObject(result).getString("entry"));
        ArrayList<QuestionOptions> list = Lists.newArrayList();
        //1、插入question表
        for (Map.Entry<String, Object> entry : jsonO.entrySet()) {
            String key = entry.getKey();
            QuestionEnum questionEnum = QuestionEnum.query(key);
            if (questionEnum != null) {
                QuestionOptions options = new QuestionOptions();
                String qName = questionEnum.getName();
                String value = entry.getValue().toString();
                options.setQuestionName(qName);
                String qId;
                switch (questionEnum.getType()) {
                    case text:
                        options.setOptionChoiceText(value);
                        qId = QuestionMap.question_options_IdMap.get(qName);
                        options.setQuestionId(Integer.parseInt(qId));
                        list.add(options);
                        break;
                    case datetime:
                        try {
                            options.setOptionChoiceDatetime(formatter1.parse(value));
                            qId = QuestionMap.question_options_IdMap.get(qName);
                            options.setQuestionId(Integer.parseInt(qId));
                            list.add(options);
                        } catch (ParseException e) {
                            options.setOptionChoiceDatetime(null);
                        }
                        break;
                    case numeric:
                        try {
                            options.setOptionChoiceNumeric(Float.parseFloat(value));
                            qId = QuestionMap.question_options_IdMap.get(qName);
                            options.setQuestionId(Integer.parseInt(qId));
                        } catch (Exception e) {
                        }
                        list.add(options);
                        break;
                    case url:
                        options.setOptionChoiceUrl(value);
                        qId = QuestionMap.question_options_IdMap.get(qName);
                        options.setQuestionId(Integer.parseInt(qId));
                        list.add(options);
                        break;
                    case array:
                        JSONArray jsonArray = JSON.parseArray(value);
                        qId = QuestionMap.question_options_IdMap.get(qName);
                        options.setQuestionId(Integer.parseInt(qId));
                        for (Object a : jsonArray) {
                            QuestionOptions newQ = copyProperties(options, QuestionOptions.class);
                            newQ.setOptionChoiceText(a.toString());
                            list.add(newQ);
                        }
                        break;
                    case hash:
                        JSONArray jsonA = JSON.parseArray(value);
                        String[] split = qName.split(",");
                        String qId0 = QuestionMap.question_options_IdMap.get(split[0]);
                        String qId1 = split.length == 2 ? QuestionMap.question_options_IdMap.get(split[1]) : qId0;
                        for (Object a : jsonA) {
                            JSONObject jsonObject = JSON.parseObject(a.toString());
//                            {
//                                "statement": "2013年",
//                                    "dimensions": {
//                                "收入": "10万",
//                                        "支出": "2万"
//                            }
                            QuestionOptions newQ = copyProperties(options, QuestionOptions.class);
                            try {
                                newQ.setQuestionId(Integer.parseInt(qId0));
                            } catch (NumberFormatException e) {
                            }
                            newQ.setOptionChoiceText(jsonObject.getString("statement"));
                            list.add(newQ);
                            QuestionOptions newQ2 = copyProperties(options, QuestionOptions.class);
                            JSONObject dimensions = JSON.parseObject(jsonObject.getString("dimensions"));
                            for (Map.Entry<String, Object> objectEntry : dimensions.entrySet()) {
                                newQ2.setOptionChoiceText(objectEntry.getValue().toString());
                                try {
                                    newQ2.setQuestionId(Integer.parseInt(qId1));
                                } catch (NumberFormatException e) {
                                }
                                list.add(newQ2);
                                break;
                            }
                        }
                    default:
                }
                //插入数据  如果重复就跳过
                for (QuestionOptions questionOptions : list) {
                    //查询当前记录是否已经存在
                    int size = questionService.query(Cnd.NEW().andEX("questionId", "=", questionOptions.getQuestionId())
                            .andEX("questionName", "=", questionOptions.getQuestionName())
                            .andEX("optionChoiceNumeric", "=", questionOptions.getOptionChoiceNumeric())
                            .andEX("optionChoiceText", "=", questionOptions.getOptionChoiceText())
                            .andEX("optionChoiceDatetime", "=", questionOptions.getOptionChoiceDatetime())
                            .andEX("optionChoiceUrl", "=", questionOptions.getOptionChoiceUrl())).size();
                    if (size == 0) {
                        questionService.save(questionOptions);
                    }
                }
            }
        }


        //2、creator
        Creator creator = new Creator();
        creator.setCreatorName(jsonO.getString("creator_name"));
        creator.setWx_nickName(jsonO.getString("x_field_weixin_nickname"));
        creator.setWx_gender(jsonO.getString("x_field_weixin_gender"));
        JSONObject ob = JSON.parseObject(jsonO.getString("x_field_weixin_province_city"));
        if (ob != null) {
            creator.setWx_province(ob.getString("province"));
            creator.setWx_city(ob.getString("city"));
        }
        creator.setWx_country(jsonO.getString("x_field_weixin_country"));
        creator.setWx_openId(jsonO.getString("x_field_weixin_openid"));
        creator.setWx_heading(jsonO.getString("x_field_weixin_headimgurl"));
        creatorService.save(creator);


        //3、location表
        String locationName = jsonO.getString("field_12");
        Location location = new Location();
        location.setLocationName(JSON.parseObject(locationName).getString("address"));
        location.setLat(JSON.parseObject(locationName).getDouble("latitude"));
        location.setLog(JSON.parseObject(locationName).getDouble("longitude"));
        JSONObject addDetail = JSON.parseObject(jsonO.getString("field_13"));
        location.setProvinceId(Integer.parseInt(ProvinceMap.provinceIdMap.get(addDetail.getString("province"))));
        location.setPrefectureId(Integer.parseInt(CityMap.cityIdMap.get(addDetail.getString("city"))));
        location.setCountyId(Integer.parseInt(CountyMap.countyIdMap.get(addDetail.getString("district"))));
        try {
            location.setCreatedAt(formatter1.parse(jsonO.getString("created_at")));
            location.setUpdateAt(formatter1.parse(jsonO.getString("updated_at")));
        } catch (ParseException e) {
        }
        locationService.save(location);

        //4、responds
        Responds responds = new Responds();
        //creatorId需要通过creator表查询creatorName获得
        Integer creatorId = creatorService.fetch(Cnd.NEW().and("creatorName", "=", jsonO.getString("creator_name"))).getCreatorId();
        responds.setCreatorId(creatorId);
        responds.setIP(jsonO.getString("info_remote_ip"));
        responds.setCreateTime(formatter1.parse(jsonO.getString("created_at")));
        responds.setUpdateTime(formatter1.parse(jsonO.getString("updated_at")));
        respondsService.save(responds);

        //5、team表中的teamName对应teamId再对应cycleTeam表中的cycleTeamId，
        Answer answer = new Answer();
        String teamName = jsonO.getString("field_8");
        String teamId = TeamNameMap.teamNameMap.get(teamName);
        String cycleTeamId = CycleMap.cycleMap.get(teamId);
        answer.setCycleTeamId(Integer.parseInt(cycleTeamId));

        //location表中的locationName对应locationId
        Integer locationId = locationService.fetch(Cnd.NEW().and("locationName", "=", location.getLocationName())).getLocationId();
        answer.setLocationId(locationId);

        //respondsId
        Integer respondsId  = responds.getRespondsId();
        answer.setRespondsId(respondsId);

        //setQuestion_optionsId
        for (QuestionOptions questionOptions : list) {
            Integer questionId = questionService.fetch(Cnd.NEW().and("questionName", "=", questionOptions.getQuestionName())).getQuestionOptionsId();
            answer.setQuestion_optionsId(questionId);
            Answer newanswer = copyProperties(answer, Answer.class);
            answerService.save(newanswer);
        }
        return 200;
    }


    private static <T> T copyProperties(Object sourceObj, Class<T> targetClazz) {
        if (sourceObj == null) {
            return null;
        }

        T targetObj = null;
        try {
            targetObj = targetClazz.newInstance();
            BeanUtils.copyProperties(sourceObj, targetObj, new String[]{});
        } catch (InstantiationException | IllegalAccessException e) {
        }
        return targetObj;
    }

}
