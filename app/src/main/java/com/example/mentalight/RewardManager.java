package com.example.mentalight;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.example.mentalight.fragments.IntroFragment;
import com.example.mentalight.fragments.RewardFragment;

public class RewardManager {

    private Reward reward;
    private Reward rewardScreen;
    private Badge badge;

    private String title;
    private String subtitle;
    private String text;

    private boolean hasBadge;

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
        //TODO: condition for reward with or without badge
        if(hasBadge){
            rewardScreen = rewardWithBadge();
        } else {
            rewardScreen = rewardWithoutBadge();
        }
    }

    private void showRewardScreen() {
        makeRewardScreen();


        //TODO: might move this to MainActivity
        RewardFragment fragment = new RewardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", rewardScreen.getTitle());
        bundle.putString("text", rewardScreen.getText());
        fragment.setArguments(bundle);

        //TODO: FragmentManager only available in Activities or Fragment --> might need to put in MainActivity
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //getSupportFragmentManager().beginTransaction()
        //        .replace(R.id.intro_container, fragment)
        //        .commit();
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
