package com.example.mentalight;

import com.example.mentalight.fragments.BadgeCollectionFragment;
import com.example.mentalight.fragments.ProgressFragment;
import com.example.mentalight.fragments.ProgressQuestionnaireFragment;

public class ProgressManager {

    private ProgressFragment progressScreenFragment;
    private ProgressQuestionnaireFragment progressQuestionnaireFragment;
    private BadgeCollectionFragment badgeCollectionFragment;
    private Progress progressScreen;


    public ProgressManager() {

        init();
    }


    private void init() {
        initProgressScreen();
        //initProgressBar();
        initProgressQuestionnaire();
        initBadgeCollection();
    }

    private void initProgressBar() {

    }

    private void initProgressScreen() {
        progressScreen = new Progress();
        progressScreenFragment = new ProgressFragment();
    }

    private void initProgressQuestionnaire() {
        if (progressScreen != null) {
            progressQuestionnaireFragment = new ProgressQuestionnaireFragment();
            System.out.println("ProgressManager: progressQuestionnaireFragment created");
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

    //returns fragment as ProgressQuestionnaireFragment-object
    public ProgressQuestionnaireFragment getProgressQuestionnaireFragment() {
        if (progressQuestionnaireFragment != null) {
            return progressQuestionnaireFragment;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated progressQuestionnaireFragment");
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
