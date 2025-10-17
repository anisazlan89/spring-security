package com.springsecurity.login.demo.model;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String email;

    private String pwd;

    @Transient
    private String confirmPwd;

    public Users() {
    }

    public Users(int userId, String email, String pwd, String confirmPwd) {
        this.userId = userId;
        this.email = email;
        this.pwd = pwd;
        confirmPwd = confirmPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        confirmPwd = confirmPwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", ConfirmPwd='" + confirmPwd + '\'' +
                '}';
    }
}
