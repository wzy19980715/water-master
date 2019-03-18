package org.test.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("location")
@Comment("location表")
public class Location {

    @Id
    @Column("locationId")
    @Comment("自增 id")
    private Integer locationId;

    @Column("provinceId")
    @Comment("provinceId")
    private Integer provinceId;

    @Column("prefectureId")
    @Comment("prefectureId")
    private Integer prefectureId;

    @Column("countyId")
    @Comment("countyId")
    private Integer countyId;

    @Column("locationName")
    @Comment("locationName")
    private String locationName;

    @Column("lat")
    @Comment("lat")
    private Double lat;

    @Column("log")
    @Comment("log")
    private Double log;

    @Column("createdAt")
    @Comment("createdAt")
    private Date createdAt;

    @Column("updateAt")
    @Comment("updateAt")
    private Date updateAt;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getPrefectureId() {
        return prefectureId;
    }

    public void setPrefectureId(Integer prefectureId) {
        this.prefectureId = prefectureId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLog() {
        return log;
    }

    public void setLog(Double log) {
        this.log = log;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
