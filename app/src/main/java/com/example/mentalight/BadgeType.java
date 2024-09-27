package com.example.mentalight;


/////////////////////////////////
// Code By [Knott, M. (2024)]: //
/////////////////////////////////


public enum BadgeType {

    BRONZE (R.string.badge_type_bronze),
    SILVER (R.string.badge_type_silver),
    GOLD (R.string.badge_type_gold);

    public final int num;

    BadgeType(int num){
        this.num = num;
    }

}
