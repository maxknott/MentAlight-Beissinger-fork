package com.example.mentalight.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mentalight.OnProgressButtonClickedListener;
import com.example.mentalight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RewardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


/////////////////////////////////
// Code By [Knott, M. (2024)]: //
/////////////////////////////////



public class RewardFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1, mParam2;


    private OnProgressButtonClickedListener listener;


    public RewardFragment() {
        // Required empty public constructor
    }


    public static RewardFragment newInstance(String param1, String param2) {
        RewardFragment fragment = new RewardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProgressButtonClickedListener) {
            listener = (OnProgressButtonClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProgressButtonClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reward, container, false);


        //view.findViewById(R.id.badge_container) ----> moved to MainActivity

        //set background color to hide ProgressBar and BackButton
        view.setBackgroundColor(getResources().getColor(R.color.beige));


        Button progressButton = view.findViewById(R.id.progress_button);

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onProgressButtonClicked();
                System.out.println("progress_button OnClick-function from RewardFragment called");
            }
        });

        return view;
    }



}