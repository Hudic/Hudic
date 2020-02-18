package com.github.Hudic.web.index.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Jiangcq
 * @Date 2020-02-05 11:00:26
 */

@Entity
@Table(name = "TEMPERATURE_RECORD")
public class TemperatureRecord implements Serializable {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "com.github.Hudic.web.index.config.ManulInsertGenerator")
    private String id;

    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 温度
     */
    @Column(name = "TEMPERATURE")
    private String temperature;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
}
