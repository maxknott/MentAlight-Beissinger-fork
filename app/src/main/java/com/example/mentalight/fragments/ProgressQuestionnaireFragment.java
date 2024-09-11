package com.example.mentalight.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mentalight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressQuestionnaireFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressQuestionnaireFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "numberOfQuestionnaires";
    private static final String ARG_PARAM2 = "numberOfFinishedQuestionnaires";

    private int numberOfFinishedQuestionnaires;
    private int numberOfQuestionnaires;



    public ProgressQuestionnaireFragment() {
        // Required empty public constructor
    }


    public static ProgressQuestionnaireFragment newInstance(int numberOfQuestionnaires,
                                                            int numberOfFinishedQuestionnaires) {
        ProgressQuestionnaireFragment fragment = new ProgressQuestionnaireFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, numberOfQuestionnaires);
        args.putInt(ARG_PARAM2, numberOfFinishedQuestionnaires);
        fragment.setArguments(args);
        return fragment;
    }


    //replaced by newInstance
    /*
    public void initProgressBar() {
        //progressBar = view.findViewById(R.id.progress_questionnaire_progress_bar);

        progressBar.setMax(numberOfQuestionnaires);

        String text = numberOfFinishedQuestionnaires + " / " + numberOfQuestionnaires;

        //progressBarText = view.findViewById(R.id.progress_questionnaire_progress_bar_text);
        progressBarText.setText(text);
        progressBar.setProgress(0);
    }

    public void updateProgressBar() {
        progressBar.setMax(numberOfQuestionnaires);

        String text = numberOfFinishedQuestionnaires + " / " + numberOfQuestionnaires;

        progressBar.setProgress(numberOfFinishedQuestionnaires);
        progressBarText.setText(text);
    }

     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            numberOfQuestionnaires = getArguments().getInt(ARG_PARAM1);
            numberOfFinishedQuestionnaires = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress_questionnaire, container, false);


        ProgressBar progressBar = view.findViewById(R.id.progress_questionnaire_progress_bar);
        TextView progressBarText = view.findViewById(R.id.progress_questionnaire_progress_bar_text);


        progressBar.setMax(numberOfQuestionnaires);

        String text = numberOfFinishedQuestionnaires + " / " + numberOfQuestionnaires;

        progressBarText.setText(text);
        progressBar.setProgress(numberOfFinishedQuestionnaires);

        return view;
    }
}