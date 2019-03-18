package org.test.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("Responds")
@Comment("Responds表")
public class Responds {

    @Id
    @Column("respondsId")
    @Comment("自增 id  start  3168")
    private Integer respondsId;

    @Column("creatorId")
    @Comment("creatorId（creator表id）")
    private Integer creatorId;

    @Column("createTime")
    @Comment("createTime")
    private Date createTime;

    @Column("updateTime")
    @Comment("updateTime")
    private Date updateTime;

    @Column("IP")
    @Comment("IP")
    private String IP;

    public Integer getRespondsId() {
        return respondsId;
    }

    public void setRespondsId(Integer respondsId) {
        this.respondsId = respondsId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
