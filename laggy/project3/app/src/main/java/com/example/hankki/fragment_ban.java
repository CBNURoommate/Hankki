package com.example.hankki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_ban#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_ban extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public CheckBox sea_btn;
    public CheckBox mush_btn;
    public CheckBox cucum_btn;
    public CheckBox gosu_btn;
    public CheckBox gut_btn;

    public fragment_ban() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_ban newInstance(String param1, String param2) {
        fragment_ban fragment = new fragment_ban();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ban, container, false);

        sea_btn = view.findViewById(R.id.sea_btn);
        mush_btn = view.findViewById(R.id.mush_btn);
        cucum_btn = view.findViewById(R.id.cucum_btn);
        gosu_btn = view.findViewById(R.id.gosu_btn);
        gut_btn = view.findViewById(R.id.gut_btn);

        Button next_btn = view.findViewById(R.id.bannext_btn);

       /* if(RestaurantActivity.user.getSea() == 1){
            sea_btn.setChecked(true);
        }

        else if(RestaurantActivity.user.getSea() == 0){
            sea_btn.setChecked(false);
        }

        if(RestaurantActivity.user.getMush() == 1){
            mush_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getCucum() == 1){
            cucum_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getGosu() == 1){
            gosu_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getGut() == 1){
            gut_btn.setChecked(true);
        } */

        // Inflate the layout for this fragment

        if(RestaurantActivity.user.getSea() == 1){
            sea_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getMush() == 1){
            mush_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getCucum() == 1){
            cucum_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getGosu() == 1){
            gosu_btn.setChecked(true);
        }

        if(RestaurantActivity.user.getGut() == 1){
            gut_btn.setChecked(true);
        }

        sea_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                    RestaurantActivity.user.setSea(1);
                else if(!buttonView.isChecked())
                    RestaurantActivity.user.setSea(0);
            }
        });

        mush_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                    RestaurantActivity.user.setMush(1);
                else if(!buttonView.isChecked())
                    RestaurantActivity.user.setMush(0);
            }
        });

        cucum_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                    RestaurantActivity.user.setCucum(1);
                else if(!buttonView.isChecked())
                    RestaurantActivity.user.setCucum(0);
            }
        });

        gosu_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                    RestaurantActivity.user.setGosu(1);
                else if(!buttonView.isChecked())
                    RestaurantActivity.user.setGosu(0);
            }
        });

        gut_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                    RestaurantActivity.user.setGut(1);
                else if(!buttonView.isChecked())
                    RestaurantActivity.user.setGut(0);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MatchingActivity.viewpager.setCurrentItem(5,true);
            }
        });


        return view;
        //return inflater.inflate(R.layout.fragment_genre, container, false);
    }
}