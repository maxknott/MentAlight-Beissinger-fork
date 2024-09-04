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


    public RewardManager(boolean hasBadge) {
        this.hasBadge = hasBadge;
        init();
    }

    private void init() {
        makeRewardScreen();
    }

    private void makeRewardScreen() {
        if(hasBadge) {
            System.out.println("RewardManager: Reward + Badge objects created");
            makeBadge();
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

    private void makeBadge() {
        badge = new Badge();
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
