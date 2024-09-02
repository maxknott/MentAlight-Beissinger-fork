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
import com.example.mentalight.OnStartButtonClickListener;
import com.example.mentalight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RewardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RewardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private TextView title, subtitle, text;
    private OnProgressButtonClickedListener listener;

    public RewardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RewardFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reward, container, false);

        //TODO: put title, subtitle, text
        title = view.findViewById(R.id.reward_title);
        subtitle = view.findViewById(R.id.reward_subtitle);
        text = view.findViewById(R.id.reward_text);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String titleText = bundle.getString("title", "");
            String subtitleText = bundle.getString("subtitle", "");
            String textText = bundle.getString("text", "");
            title.setText(titleText);
            subtitle.setText(subtitleText);
            text.setText(textText);
        }

        Button progressButton = view.findViewById(R.id.progress_button);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onProgressButtonClicked();
            }
        });


        return view;
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

}