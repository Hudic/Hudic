package com.github.Hudic.web.index.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Description
 * @Author Jiangcq
 * @Date 2020-02-07 11:05:22
 */

@Entity
@Table(name = "PASSWORD_RECORD")
public class PasswordRecord implements Serializable {


    @Column(name = "ID")
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "com.github.Hudic.web.index.config.ManulInsertGenerator")
    private String id;

    /**
     * 密码源
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 账号
     */
    @Column(name = "ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
