package com.aengussong.randomuserlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUserResponse {

    @SerializedName("results")
    @Expose
    private List<RandomUser> randomUsers = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<RandomUser> getRandomUsers() {
        return randomUsers;
    }

    public void setRandomUsers(List<RandomUser> randomUsers) {
        this.randomUsers = randomUsers;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
