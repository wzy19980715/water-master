package org.test.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("creator")
@Comment("creator表")
public class Creator {

    @Id
    @Column("creatorId")
    @Comment("自增 id")
    private Integer creatorId;

    @Column("creatorName")
    @Comment("creatorName")
    private String creatorName;

    @Column("wx_nickName")
    @Comment("creatorName")
    private String wx_nickName;

    @Column("wx_gender")
    @Comment("wx_gender")
    private String wx_gender;

    @Column("wx_country")
    @Comment("wx_country")
    private String wx_country;

    @Column("wx_province")
    @Comment("wx_province")
    private String wx_province;

    @Column("wx_city")
    @Comment("wx_city")
    private String wx_city;

    @Column("wx_openId")
    @Comment("wx_openId")
    private String wx_openId;

    @Column("wx_heading")
    @Comment("wx_heading")
    private String wx_heading;


    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getWx_nickName() {
        return wx_nickName;
    }

    public void setWx_nickName(String wx_nickName) {
        this.wx_nickName = wx_nickName;
    }

    public String getWx_gender() {
        return wx_gender;
    }

    public void setWx_gender(String wx_gender) {
        this.wx_gender = wx_gender;
    }

    public String getWx_country() {
        return wx_country;
    }

    public void setWx_country(String wx_country) {
        this.wx_country = wx_country;
    }

    public String getWx_province() {
        return wx_province;
    }

    public void setWx_province(String wx_province) {
        this.wx_province = wx_province;
    }

    public String getWx_city() {
        return wx_city;
    }

    public void setWx_city(String wx_city) {
        this.wx_city = wx_city;
    }

    public String getWx_openId() {
        return wx_openId;
    }

    public void setWx_openId(String wx_openId) {
        this.wx_openId = wx_openId;
    }

    public String getWx_heading() {
        return wx_heading;
    }

    public void setWx_heading(String wx_heading) {
        this.wx_heading = wx_heading;
    }
}
