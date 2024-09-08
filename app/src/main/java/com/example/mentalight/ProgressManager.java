package com.example.mentalight;

import com.example.mentalight.fragments.BadgeCollectionFragment;
import com.example.mentalight.fragments.BadgeFragment;
import com.example.mentalight.fragments.ProgressFragment;
import com.example.mentalight.fragments.ProgressQuestionaireFragment;

public class ProgressManager {

    private ProgressFragment progressScreenFragment;
    private ProgressQuestionaireFragment progressQuestionaireFragment;
    private BadgeCollectionFragment badgeCollectionFragment;
    private Progress progressScreen;


    public ProgressManager() {

        init();
    }


    private void init() {
        initProgressScreen();
        //initProgressBar();
        initProgressQuestionaire();
        initBadgeCollection();
    }

    private void initProgressBar() {

    }

    private void initProgressScreen() {
        progressScreen = new Progress();
        progressScreenFragment = new ProgressFragment();
    }

    private void initProgressQuestionaire() {
        if (progressScreen != null) {
            progressQuestionaireFragment = new ProgressQuestionaireFragment();
            System.out.println("ProgressManager: progressQuestionaireFragment created");
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Progress progressScreen before creating a fragment");
        }

    }

    private void initBadgeCollection() {
        if (progressScreen != null) {
            badgeCollectionFragment = new BadgeCollectionFragment();
            System.out.println("ProgressManager: badgeCollectionFragment created");
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Progress progressScreen before creating a fragment");
        }
    }



    //Getters:

    //returns complete progress screen as Progress-object

    //returns fragment as progressFragment-object
    public ProgressFragment getProgressScreenFragment() {
        if (progressScreenFragment != null) {
            return progressScreenFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated progressScreenFragment");
        }

    }

    //returns fragment as ProgressQuestionaireFragment-object
    public ProgressQuestionaireFragment getProgressQuestionaireFragment() {
        if (progressQuestionaireFragment != null) {
            return progressQuestionaireFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated progressQuestionaireFragment");
        }

    }

    //returns fragment as BadgeCollectionFragment-object
    public BadgeCollectionFragment getBadgeCollectionFragment() {
        if (badgeCollectionFragment != null) {
            return badgeCollectionFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated badgeCollectionFragment");
        }

    }


}
