package com.aengussong.randomuserlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Dob implements Serializable {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;

    public String getDate() {
        return date;
    }

    public String getFormattedDate() {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateFormatted = date;
        try {
            dateFormatted = out.format(in.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormatted;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
