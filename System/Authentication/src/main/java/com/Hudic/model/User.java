package com.Hudic.model;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * jiangcq
 * 2018/12/7 9:18
 * 登录的用户，包括后台管理员、前台访问用户
 */
@Entity
@Table(name = "USER")
public class User {
    private long id;
    private String username;
    private String password;
    private int role;//角色：0后台管理员/1前台访问用户

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

//    //转换为Json格式的String
//    public String toJsonString() {
//        return "{username: " + username + ", password: " + password + ", role: " + role + "}";
//    }
}
