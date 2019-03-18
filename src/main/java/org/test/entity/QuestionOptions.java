package org.test.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("question_options")
@Comment("question_options表")
public class QuestionOptions {
    @Id
    @Column("question_optionsId")
    @Comment("自增 id")
    private Integer questionOptionsId;

    @Column("question_Id")
    @Comment("id")
    private Integer questionId;

    @Column("question_Name")
    @Comment("question_Name")
    private String questionName;

    @Column("option_choice_numeric")
    @Comment("option_choice_numeric")
    private Float optionChoiceNumeric;

    @Column("option_choice_text")
    @Comment("option_choice_text")
    private String optionChoiceText;

    @Column("option_choice_datetime")
    @Comment("option_choice_datetime")
    private Date optionChoiceDatetime;

    @Column("option_choice_url")
    @Comment("option_choice_url")
    private String optionChoiceUrl;

    public Integer getQuestionOptionsId() {
        return questionOptionsId;
    }

    public void setQuestionOptionsId(Integer questionOptionsId) {
        this.questionOptionsId = questionOptionsId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Float getOptionChoiceNumeric() {
        return optionChoiceNumeric;
    }

    public void setOptionChoiceNumeric(Float optionChoiceNumeric) {
        this.optionChoiceNumeric = optionChoiceNumeric;
    }

    public String getOptionChoiceText() {
        return optionChoiceText;
    }

    public void setOptionChoiceText(String optionChoiceText) {
        this.optionChoiceText = optionChoiceText;
    }

    public Date getOptionChoiceDatetime() {
        return optionChoiceDatetime;
    }

    public void setOptionChoiceDatetime(Date optionChoiceDatetime) {
        this.optionChoiceDatetime = optionChoiceDatetime;
    }

    public String getOptionChoiceUrl() {
        return optionChoiceUrl;
    }

    public void setOptionChoiceUrl(String optionChoiceUrl) {
        this.optionChoiceUrl = optionChoiceUrl;
    }
}
