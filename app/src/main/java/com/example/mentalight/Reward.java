package com.example.mentalight;


/////////////////////////////////
// Code By [Knott, M. (2024)]: //
/////////////////////////////////



//class for reward
public class Reward {

    private Badge badge;


    //constructor for reward with badge
    public Reward(Badge badge) {
        this.badge = badge;
    }

    //constructor for reward without badge
    public Reward() {

    }

    //returns Badge-object
    public Badge getBadge() {
        return badge;
    }


}
