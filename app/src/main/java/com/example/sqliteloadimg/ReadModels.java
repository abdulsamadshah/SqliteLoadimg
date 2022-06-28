package com.example.sqliteloadimg;

public class ReadModels {
    String name;
    String userimg;

    public ReadModels(String name, String userimg) {
        this.name = name;
        this.userimg = userimg;
    }

    public ReadModels() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }
}
