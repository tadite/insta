package com.csf.insta.dto;

public class ProfileDataDto {



    private String username;

    private String fullname;

    private String info;

    public ProfileDataDto(String username, String fullname, String info) {
        this.username = username;
        this.fullname = fullname;
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
