package com.example.mentalight;

public class RewardManager {

    private Reward reward;
    private Reward rewardScreen;
    private Badge badge;

    private String title;
    private String subtitle;
    private String text;

    public RewardManager() {
        init();
    }

    private void init() {
        //TODO: string constants for title, subtitle, text
        //title =
        //subtitle =
        //text =
        makeRewardScreen();
    }

    private void makeRewardScreen() {
        if(true){
            rewardScreen = rewardWithBadge();
        } else {
            rewardScreen = rewardWithoutBadge();
        }
    }

    private Reward rewardWithBadge() {
        reward = new Reward(title, subtitle, text, badge);
        return reward;
    }

    private Reward rewardWithoutBadge() {
        reward = new Reward(title, subtitle, text);
        return reward;
    }


    //returns complete reward screen
    public Reward getRewardScreen() {
        return rewardScreen;
    }

}
