package com.edu.sra.trainings.utils;

/**
 * Created by sravan on 18/07/17.
 */

public class EntityUser {

    private String userName, userEmail, userPassword;
    private boolean isMale;

    public EntityUser(String userName, String userEmail, String userPassword, boolean isMale) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isMale = isMale;
    }

    public EntityUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        this.isMale = male;
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", isMale=" + isMale +
                '}';
    }

}
