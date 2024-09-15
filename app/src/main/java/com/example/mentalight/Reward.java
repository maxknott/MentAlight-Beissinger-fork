package com.example.mentalight;

//Klasse für einen Reward (Belohnung)
public class Reward {

    private Badge badge;


    //Konstruktor für Reward mit Badge
    public Reward(Badge badge) {
        this.badge = badge;
    }

    //Konstruktor für Reward ohne Badge
    public Reward() {

    }

    //returns Badge-object
    public Badge getBadge() {
        return badge;
    }


}
