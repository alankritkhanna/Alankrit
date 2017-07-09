package com.example.alankrit.twitterapp;

/**
 * Created by Alankrit on 07-Jul-17.
 */

public class User {

    String screen_name,user_id,name,profile_image_url_https;

    public User(String screen_name, String user_id, String name, String profile_image_url_https) {
        this.screen_name = screen_name;
        this.user_id = user_id;
        this.name = name;
        this.profile_image_url_https = profile_image_url_https;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }
}
