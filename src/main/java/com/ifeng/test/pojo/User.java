package com.ifeng.test.pojo;

/**
 * Created by whling on 2017/12/12.
 */
public class User {

    private int id;
    private String username;
    private String descr;

    public User() {
    }

    public User(int id, String username, String descr) {
        this.id = id;
        this.username = username;
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return descr;
    }

    public void setDesc(String desc) {
        this.descr = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
