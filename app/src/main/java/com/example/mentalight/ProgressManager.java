package com.example.mentalight;

import android.view.View;

import com.example.mentalight.fragments.BadgeCollectionFragment;
import com.example.mentalight.fragments.ProgressFragment;
import com.example.mentalight.fragments.ProgressQuestionnaireFragment;

public class ProgressManager {

    private ProgressFragment progressScreenFragment;
    private ProgressQuestionnaireFragment progressQuestionnaireFragment;
    private BadgeCollectionFragment badgeCollectionFragment;
    private Progress progressScreen;

    private int numberOfFinishedQuestionnaires;
    private int numberOfQuestionnaires;
    private View progressBar;
    private ProgressQuestionnaireFragment pqfInstance;
    private BadgeCollectionFragment bcfInstance;
    boolean bronzeBadgeEarned;
    boolean silverBadgeEarned;
    boolean goldBadgeEarned;


    public ProgressManager(int numberOfQuestionnaires, int numberOfFinishedQuestionnaires,
                           boolean bronzeBadgeEarned, boolean silverBadgeEarned, boolean goldBadgeEarned) {
        this.numberOfQuestionnaires = numberOfQuestionnaires;
        this.numberOfFinishedQuestionnaires = numberOfFinishedQuestionnaires;
        this.bronzeBadgeEarned = bronzeBadgeEarned;
        this.silverBadgeEarned = silverBadgeEarned;
        this.goldBadgeEarned = goldBadgeEarned;
        init();
    }


    private void init() {
        initProgressScreen();
        initProgressQuestionnaire();
        initBadgeCollection();
    }

    private void initProgressScreen() {
        progressScreen = new Progress();
        progressScreenFragment = new ProgressFragment();
    }

    private void initProgressQuestionnaire() {
        if (progressScreen != null) {
            progressQuestionnaireFragment = new ProgressQuestionnaireFragment();
            pqfInstance = ProgressQuestionnaireFragment.newInstance(numberOfQuestionnaires,
                    numberOfFinishedQuestionnaires);
            System.out.println("ProgressManager: progressQuestionnaireFragment created");
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Progress progressScreen before creating a fragment");
        }
    }

    private void initBadgeCollection() {
        if (progressScreen != null) {
            badgeCollectionFragment = new BadgeCollectionFragment();

            //TODO: newInstance

            bcfInstance = BadgeCollectionFragment.newInstance(bronzeBadgeEarned,
                    silverBadgeEarned, goldBadgeEarned);

            System.out.println("ProgressManager: badgeCollectionFragment created");
        } else {
            throw new RuntimeException(this.toString()
                    + " must initiate Progress progressScreen before creating a fragment");
        }
    }

    //replaced by newInstance in ProgressQuestionnaireFragment
    /*
    public void initProgressBar() {
        //this.numberOfQuestionnaires = numberOfQuestionnaires;
        //this.numberOfFinishedQuestionnaires = numberOfFinishedQuestionnaires;
        //progressQuestionnaireFragment.initProgressBar();

        //pqfInstance.initProgressBar();
    }

    public void updateProgressBar() {
        //this.numberOfQuestionnaires = numberOfQuestionnaires;
        //this.numberOfFinishedQuestionnaires = numberOfFinishedQuestionnaires;
        //progressQuestionnaireFragment.updateProgressBar();

        //pqfInstance.updateProgressBar();
    }

     */



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

    //returns Instance of ProgressQuestionnaireFragment
    public ProgressQuestionnaireFragment getProgressQuestionnaireFragmentInstance() {
        if (pqfInstance != null) {
            return pqfInstance;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated progressQuestionnaireFragmentInstance");
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

    //returns fragment as BadgeCollectionFragment-object
    public BadgeCollectionFragment getBadgeCollectionFragmentInstance() {
        if (bcfInstance != null) {
            return bcfInstance;
        } else {
            throw new RuntimeException(this.toString()
                    + " has not initiated badgeCollectionFragmentInstance");
        }

    }


}
