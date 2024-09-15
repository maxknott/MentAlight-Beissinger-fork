package com.example.mentalight.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentalight.BadgeType;
import com.example.mentalight.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BadgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BadgeFragment extends Fragment {

    private static final String BADGE_TYPE = "badge_type";

    private static final String BADGE_TYPE_BRONZE = "bronze";
    private static final String BADGE_TYPE_SILVER = "silver";
    private static final String BADGE_TYPE_GOLD = "gold";

    private int badgeType;


    public BadgeFragment() {
        // Required empty public constructor
    }


    public static BadgeFragment newInstance(int badgeType) {
        BadgeFragment fragment = new BadgeFragment();
        Bundle args = new Bundle();
        //args.putString(BADGE_TYPE, badgeType);
        args.putInt(BADGE_TYPE, badgeType);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            badgeType = getArguments().getInt(BADGE_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_badge, container, false);

        ImageView imgView = view.findViewById(R.id.imgView_medal);
        TextView txtView = view.findViewById(R.id.badge_name);


        //medal icons from R.drawable
        // license: <a href="https://www.flaticon.com/free-icons/medal" title="medal icons">Medal icons created by Pixel Buddha - Flaticon</a>

        String badgeTypeString = getString(badgeType);

        //set image and name for fragment
        // hardcoded because switch does not work with my constants, even with enum (--> "constant expression required") - compile time constant
        // TODO: change to else-if and compare ints instead
        switch (badgeTypeString) {
            case BADGE_TYPE_BRONZE:
                imgView.setImageResource(R.drawable.bronze_medal);
                txtView.setText(R.string.badge_name_bronze);
                break;
            case BADGE_TYPE_SILVER:
                imgView.setImageResource(R.drawable.silver_medal);
                txtView.setText(R.string.badge_name_silver);
                break;
            case BADGE_TYPE_GOLD:
                imgView.setImageResource(R.drawable.gold_medal);
                txtView.setText(R.string.badge_name_gold);
                break;
            default:
                System.out.println("badgeType not accepted");
                throw new RuntimeException(this.toString()
                        + " not a valid input");
        }


        return view;
    }
}