package org.test.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("Answer")
@Comment("Answer表")
public class Answer {

    @Id
    @Column("answerId")
    @Comment("自增 id  start  3168")
    private Integer answerId;

    @Column("cycleTeamId")
    @Comment("cycleTeamId（teamName-teamId-cycleTeamId）")
    private Integer cycleTeamId;

    @Column("locationId")
    @Comment("locationId location表")
    private Integer locationId;

    @Column("respondsId")
    @Comment("respondsId 3168开始")
    private Integer respondsId;

    @Column("question_optionsId")
    @Comment("question_optionsId")
    private Integer question_optionsId;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getCycleTeamId() {
        return cycleTeamId;
    }

    public void setCycleTeamId(Integer cycleTeamId) {
        this.cycleTeamId = cycleTeamId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getRespondsId() {
        return respondsId;
    }

    public void setRespondsId(Integer respondsId) {
        this.respondsId = respondsId;
    }

    public Integer getQuestion_optionsId() {
        return question_optionsId;
    }

    public void setQuestion_optionsId(Integer question_optionsId) {
        this.question_optionsId = question_optionsId;
    }
}
