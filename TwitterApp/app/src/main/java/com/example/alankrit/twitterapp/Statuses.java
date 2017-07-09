package com.example.alankrit.twitterapp;

/**
 * Created by Alankrit on 07-Jul-17.
 */

public class Statuses {

    User user;
    String text, link;

    public Statuses(User user, String text, String link) {
        this.user = user;
        this.text = text;
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
