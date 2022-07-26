package com.jaydedaniya.sqlite_database__notification__permission_demo;

import java.io.Serializable;

public class UserDataClass implements Serializable {

    private int userId;
    private String userName;
    private String userNumber;
    private String userEmail;
    private String userPass;

    public UserDataClass() {
    }

    public UserDataClass(int userId, String userName, String userNumber, String userEmail, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userNumber = userNumber;
        this.userEmail = userEmail;
        this.userPass = userPass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    @Override
    public String toString() {
        return "UserDataClass{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
