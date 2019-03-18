package org.test.enumlist;

//question_options表
public enum QuestionEnum {
    //
    采样日期("field_60", "samplingTime", 75, Type.datetime),
    采样照片("field_17", "picture", 77, Type.url),
    检测日期("field_10", "detectDate", 76, Type.datetime),
    水样类型("field_6", "waterType", 1, Type.text),
    水样来源("field_14", "waterSource", 14, Type.text),
    水样水源类型("field_15", "waterSourceDetails", 4, Type.text),
    供水方式("field_16", "deliveryMethod", 5, Type.text),
    取水方式("field_20", "inTakeMethod", 6, Type.array),
    家庭储水容器("field_22", "waterStorage", 9, Type.array),
    储存时长("field_23", "averageStorageHours", 90, Type.numeric),
    饮用前处理方式("field_24", "treatmentMethod", 7, Type.array),
    潜在污染源("field_25", "potentialContamination", 11, Type.array),
    水样所在水源与潜在污染源距离("field_26", "potentialContaminationDistance", 12, Type.hash),
    同一水源供应人口("field_27", "populationServedBySource", 13, Type.hash),
    水温("field_63", "temp", 15, Type.numeric),
    嗅味("field_31", "smell", 16, Type.text),
    请描述气味("field_32", "smellDetail", 17, Type.text),
    水样描述("field_33", "visual", 18, Type.text),
    请概述有什么悬浮物等("field_34", "visualDetail", 19, Type.text),
    浑浊度("field_35", "turbidity", 21, Type.numeric),
    浑浊度检测方法("field_36", "turbidityMethod", 24, Type.text),
    TDS("field_37", "tdsElement", 50, Type.numeric),
    pH("field_38", "phElement", 48, Type.numeric),
    硝酸盐读数("field_39", "no3Element", 37, Type.numeric),
    硝酸盐原始读数("field_41", "no3Dilutionrate,no3Original", 38, 39, Type.hash),
    硝酸盐检测方法("field_42", "no3Method", 40, Type.text),
    氨氮读数("field_43", "nh3Element", 45, Type.numeric),
    氨氮原始读数("field_45", "nhDilutionrate,nh3Original", 101, 46, Type.hash),
    氨氮检测方法("field_46", "nh3Method", 47, Type.text),
    氟化物读数("field_47", "fElement", 43, Type.numeric),
    氟化物原始读数("field_49 ", "fDilutionrate,fOriginal", 102, 103, Type.hash),
    氟化物检测方法("field_50", "fMethod", 44, Type.text),
    砷("field_111", "asElement", 27, Type.text),
    大肠杆菌数("field_52", "ecoilElement", 52, Type.numeric),
    大肠杆菌检测方法("field_54", "ecoilMethod", 53, Type.text),
    水样其他特征("field_56", "generalComments", 78, Type.text),;

    private final String field;
    private final String name;
    private final Integer id;
    private final Integer id2;
    private final Type type;

    public String getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId2() {
        return id2;
    }

    public Type getType() {
        return type;
    }

    QuestionEnum(String field, String name, Integer id, Type type) {
        this.field = field;
        this.name = name;
        this.id = id;
        this.id2 = 0;
        this.type = type;
    }

    QuestionEnum(String field, String name, Integer id, Integer id2, Type type) {
        this.field = field;
        this.name = name;
        this.id = id;
        this.id2 = id2;
        this.type = type;
    }

    public enum Type {
        numeric, text, datetime, url, array, hash
    }

    public static QuestionEnum query(String field) {
        for (QuestionEnum _enum : values()) {
            if (_enum.getField().equals(field)) {
                return _enum;
            }
        }
        return null;
    }
}
