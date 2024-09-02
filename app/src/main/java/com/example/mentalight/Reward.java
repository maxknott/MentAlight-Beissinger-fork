package com.example.mentalight;

//Klasse für einen Reward (Belohnung)
public class Reward {

    private String title;
    private String subtitle;
    private String text;
    private Badge badge;


    //Konstruktor für Reward mit Badge
    public Reward(String title, String subtitle, String text, Badge badge) {
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
        this.badge = badge;
    }

    //Konstruktor für Reward ohne Badge
    public Reward(String title, String subtitle, String text) {
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getText() {
        return text;
    }

    public Badge getBadge() {
        return badge;
    }


}
