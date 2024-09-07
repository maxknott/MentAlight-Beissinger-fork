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


    /*
    private static final int BADGE_TYPE_BRONZE = R.string.badge_type_bronze;
    private static final int BADGE_TYPE_SILVER = R.string.badge_type_silver;
    private static final int BADGE_TYPE_GOLD = R.string.badge_type_gold;
    */

    /*
    private String badgeTypeBronze = getString(BadgeType.BRONZE.num);
    private String badgeTypeSilver = getString(BadgeType.SILVER.num);
    private String badgeTypeGold = getString(BadgeType.GOLD.num);

     */

    private int badgeType;

    private View view;
    private ImageView imgView;
    private TextView txtView;

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
            //badgeType = getArguments().getString(BADGE_TYPE);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_badge, container, false);

        imgView = view.findViewById(R.id.imgView_medal);
        txtView = view.findViewById(R.id.badge_name);


        //medal icons from R.drawable
        // license: <a href="https://www.flaticon.com/free-icons/medal" title="medal icons">Medal icons created by Pixel Buddha - Flaticon</a>

        /*
        int badgeTypeBronze = BadgeType.BRONZE.num;
        int badgeTypeSilver = BadgeType.SILVER.num;
        int badgeTypeGold = BadgeType.GOLD.num;
        /*
        if (badgeType != null) {

        }
         */

        /*
        String badgeTypeBronze = getString(BadgeType.BRONZE.num);
        String badgeTypeSilver = getString(BadgeType.SILVER.num);
        String badgeTypeGold = getString(BadgeType.GOLD.num);
         */

        /*
        final int badgeTypeBronze = BadgeType.BRONZE.num;
        final int badgeTypeSilver = BadgeType.BRONZE.num;
        final int badgeTypeGold = BadgeType.BRONZE.num;
        */


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