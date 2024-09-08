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

    private int badgeType;


    //Constructor for RewardManager to create RewardScreen without Badge
    public RewardManager(boolean hasBadge) {
        this.hasBadge = hasBadge;
        init();
    }

    //Constructor for RewardManager to create RewardScreen with Badge
    public RewardManager(boolean hasBadge, int badgeType) {
        this.hasBadge = hasBadge;
        if (hasBadge) {
            this.badgeType = badgeType;
            init();
        } else {
            System.out.println("badgeType argument set, but hasBadge = false");
            throw new RuntimeException(this.toString()
                    + " not a valid input");
        }
    }

    private void init() {
        makeRewardScreen();
    }

    //create object and fragment for Reward (and for Badge if hasBadge = true)
    private void makeRewardScreen() {
        if(hasBadge) {
            makeBadge(badgeType);
            rewardScreen = rewardWithBadge();
            System.out.println("RewardManager: Reward + Badge objects created");
            makeRewardFragment();
            makeBadgeFragment(badgeType);
        } else {
            System.out.println("RewardManager: Reward object created (no Badge)");
            rewardScreen = rewardWithoutBadge();
            makeRewardFragment();
        }
    }

    //create fragment for Reward
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

    //create Badge-object dependent on badgeType
    private void makeBadge(int badgeType) {

        if (badgeType == BADGE_TYPE_BRONZE) {
            badge = badgeBronze();
        } else if (badgeType == BADGE_TYPE_SILVER) {
            badge = badgeSilver();
        } else if (badgeType == BADGE_TYPE_GOLD) {
            badge = badgeGold();
        } else {
            System.out.println("badgeType not accepted");
            throw new RuntimeException(this.toString()
                    + " not a valid input");
        }

        /* switch does not work even with enum so changed to if-else
        String s = getString(badgeType);
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

    //create fragment for Badge
    private void makeBadgeFragment(int badgeType) {
        if (rewardScreen != null) {
            badgeFragment = BadgeFragment.newInstance(badgeType);
            System.out.println("RewardManager: badgeFragment created");
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Reward rewardScreen before creating a fragment");
        }
    }

    //return Reward-object with Badge-object as argument
    private Reward rewardWithBadge() {
        if(badge != null) {
            reward = new Reward(badge);
            return reward;
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Badge badge before creating a Reward with Badge");
        }
    }

    //return Reward-object without Badge
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

    //returns fragment as RewardFragment-object
    public RewardFragment getRewardFragment() {
        if (rewardFragment != null) {
            return rewardFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated rewardFragment");
        }
    }

    //returns fragment as BadgeFragment-object
    public BadgeFragment getBadgeFragment() {
        if (badgeFragment != null) {
            return badgeFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated badgeFragment");
        }
    }

}
