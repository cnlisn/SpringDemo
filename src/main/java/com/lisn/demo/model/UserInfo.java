package com.lisn.demo.model;

import javax.persistence.*;

/**
 * 用户表
 */
@Table(name = "user_info")
public class UserInfo {
    /**
     * 用户ID
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码，经过加密之后的
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码，经过加密之后的
     *
     * @return password - 用户密码，经过加密之后的
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码，经过加密之后的
     *
     * @param password 用户密码，经过加密之后的
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取加密盐值
     *
     * @return salt - 加密盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密盐值
     *
     * @param salt 加密盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}