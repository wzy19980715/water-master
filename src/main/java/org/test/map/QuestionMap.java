package org.test.map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class QuestionMap {
    //locationName    ***id
    public static HashMap<String, String> question_options_IdMap = new HashMap();
    public  static HashMap<String, String> question_IdMap = new HashMap();

    static {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("classpath:question");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
            String str;
            // 按行读取字符串
            while ((str = br.readLine()) != null) {
                String[] split = StringUtils.trimAllWhitespace(str).split(",");
                question_options_IdMap.put(split[2], split[0]);
                question_IdMap.put(split[2], split[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
