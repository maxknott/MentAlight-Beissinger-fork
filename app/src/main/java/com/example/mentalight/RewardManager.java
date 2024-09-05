package com.example.mentalight;

import com.example.mentalight.fragments.BadgeFragment;
import com.example.mentalight.fragments.RewardFragment;

public class RewardManager {

    private Reward reward;
    private Reward rewardScreen;
    private Badge badge;
    private RewardFragment rewardFragment;
    private BadgeFragment badgeFragment;

    private boolean hasBadge;

    private static final int BADGE_TYPE_BRONZE = R.string.badge_type_bronze;
    private static final int BADGE_TYPE_SILVER = R.string.badge_type_silver;
    private static final int BADGE_TYPE_GOLD = R.string.badge_type_gold;

    //public enum BadgeType {BADGE_TYPE_BRONZE, BADGE_TYPE_SILVER, BADGE_TYPE_GOLD}

    private int badgeType;


    public RewardManager(boolean hasBadge) {
        this.hasBadge = hasBadge;
        init();
    }

    public RewardManager(boolean hasBadge, int badgeType) {
        this.hasBadge = hasBadge;
        this.badgeType = badgeType;

    }

    private void init() {
        makeRewardScreen();
    }

    private void makeRewardScreenWithBadge(int badgeType) {

    }

    private void makeRewardScreenWithoutBadge() {

    }

    private void makeRewardScreen() {
        if(hasBadge) {

            System.out.println("RewardManager: Reward + Badge objects created");

            //TODO: makeBadge with int badgeType argument

            badge = badgeBronze();

            //makeBadge();

            rewardScreen = rewardWithBadge();
            makeRewardFragment();
            makeBadgeFragment();
        } else {
            System.out.println("RewardManager: Reward object created (no Badge)");
            rewardScreen = rewardWithoutBadge();
            makeRewardFragment();
        }
    }

    private void makeRewardFragment() {
        if (rewardScreen != null) {

            System.out.println("RewardManager: rewardFragment created");

            rewardFragment = new RewardFragment();

            /*
            Bundle bundle = new Bundle();
            bundle.putString("title", rewardScreen.getTitle());
            bundle.putString("subtitle", rewardScreen.getSubtitle());
            bundle.putString("text", rewardScreen.getText());
            fragment.setArguments(bundle);
             */

        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Reward rewardScreen before creating a fragment");
        }
    }

    //TODO: move switch to BadgeFragment
    private void makeBadge(int badgeType) {


        /* TODO: switch does not work even with enum
        switch (badgeType) {
            case BADGE_TYPE_BRONZE:
                badge = new Badge(BADGE_TYPE_BRONZE);
                break;
            case BADGE_TYPE_SILVER:
                badge = new Badge(BADGE_TYPE_SILVER);
                break;
            case BADGE_TYPE_GOLD:
                badge = new Badge(BADGE_TYPE_GOLD);
                break;
            default:
                System.out.println("badgeType not accepted");
                throw new RuntimeException(this.toString()
                        + " not a valid input");
        }

         */


        //badge = new Badge(badgeType);

        //badge = badgeBronze();

    }

    private void makeBadgeFragment() {
        if (rewardScreen != null) {
            System.out.println("RewardManager: badgeFragment created");
            badgeFragment = new BadgeFragment();
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Reward rewardScreen before creating a fragment");
        }
    }

    private Reward rewardWithBadge() {
        if(badge != null) {
            reward = new Reward(badge);
            return reward;
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Badge badge before creating a Reward with Badge");
        }

    }

    private Reward rewardWithoutBadge() {
        reward = new Reward();
        return reward;
    }

    private Badge badgeBronze() {
        badge = new Badge(BADGE_TYPE_BRONZE);
        return badge;
    }
    private Badge badgeSilver() {
        badge = new Badge(BADGE_TYPE_SILVER);
        return badge;
    }
    private Badge badgeGold() {
        badge = new Badge(BADGE_TYPE_GOLD);
        return badge;
    }


    //Getters:

    //returns complete reward screen as Reward-object
    public Reward getRewardScreen() {
        if (rewardScreen != null) {
            return rewardScreen;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated rewardScreen");
        }
    }

    //returns fragment with arguments as RewardFragment-object
    public RewardFragment getRewardFragment() {
        if (rewardFragment != null) {
            return rewardFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated rewardFragment");
        }
    }

    //returns fragment with arguments as RewardFragment-object
    public BadgeFragment getBadgeFragment() {
        if (badgeFragment != null) {
            return badgeFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated badgeFragment");
        }
    }

}
