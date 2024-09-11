package com.example.mentalight.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mentalight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BadgeCollectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BadgeCollectionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "bronzeBadgeCollected";
    private static final String ARG_PARAM2 = "silverBadgeCollected";

    private static final String ARG_PARAM3 = "goldBadgeCollected";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private boolean bronzeBadgeCollected;
    private boolean silverBadgeCollected;
    private boolean goldBadgeCollected;


    public BadgeCollectionFragment() {
        // Required empty public constructor
    }


    public static BadgeCollectionFragment newInstance(boolean bronzeBadgeCollected,
                                                      boolean silverBadgeCollected,
                                                      boolean goldBadgeCollected) {
        BadgeCollectionFragment fragment = new BadgeCollectionFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, bronzeBadgeCollected);
        args.putBoolean(ARG_PARAM2, silverBadgeCollected);
        args.putBoolean(ARG_PARAM3, goldBadgeCollected);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bronzeBadgeCollected = getArguments().getBoolean(ARG_PARAM1);
            silverBadgeCollected = getArguments().getBoolean(ARG_PARAM2);
            goldBadgeCollected = getArguments().getBoolean(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_badge_collection, container, false);

        //TODO: functionality here

        LinearLayout badgeCollectionContainer = view.findViewById(R.id.horizontal_badge_collection);
        ImageView imgViewBadge1 = view.findViewById(R.id.badge_collection_badge1);
        ImageView imgViewBadge2 = view.findViewById(R.id.badge_collection_badge2);
        ImageView imgViewBadge3 = view.findViewById(R.id.badge_collection_badge3);


        //check for earned badges and show medal-img when true
        if (bronzeBadgeCollected) {
            imgViewBadge1.setImageResource(R.drawable.bronze_medal);
            if (silverBadgeCollected) {
                imgViewBadge2.setImageResource(R.drawable.silver_medal);
                if (goldBadgeCollected) {
                    imgViewBadge3.setImageResource(R.drawable.gold_medal);
                } else {
                    imgViewBadge3.setImageResource(R.drawable.baseline_close_24);
                }
            } else {
                imgViewBadge2.setImageResource(R.drawable.baseline_close_24);
                imgViewBadge3.setImageResource(R.drawable.baseline_close_24);
            }
        } else {
            //TODO: set img res for all badge to "?"
            imgViewBadge1.setImageResource(R.drawable.baseline_close_24);
            imgViewBadge2.setImageResource(R.drawable.baseline_close_24);
            imgViewBadge3.setImageResource(R.drawable.baseline_close_24);
        }



        return view;
    }
}