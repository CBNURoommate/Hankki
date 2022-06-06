package com.example.hankki;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_genre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_genre extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_genre() {
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
    public static fragment_genre newInstance(String param1, String param2) {
        fragment_genre fragment = new fragment_genre();
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
        View view = inflater.inflate(R.layout.fragment_genre, container, false);

        RadioButton kor_btn = view.findViewById(R.id.kor_btn);
        RadioButton chn_btn = view.findViewById(R.id.chn_btn);
        RadioButton usa_btn = view.findViewById(R.id.usa_btn);

        RadioGroup genre_group = view.findViewById(R.id.genre_group);
        // Inflate the layout for this fragment

        switch (RestaurantActivity.user.getGenre()){
            case 1:
                kor_btn.setChecked(true);
                break;
            case 2:
                chn_btn.setChecked(true);
                break;
            case 3:
                usa_btn.setChecked(true);
                break;
            default:
                break;
        }

        genre_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 RadioButton genre_group = group.findViewById(checkedId);
                 switch (checkedId){
                     case R.id.kor_btn:
                          RestaurantActivity.user.setGenre(1);
                          MatchingActivity.viewpager.setCurrentItem(3,true);
                          break;
                     case R.id.chn_btn:
                          RestaurantActivity.user.setGenre(2);
                          MatchingActivity.viewpager.setCurrentItem(3,true);
                          break;
                     case R.id.usa_btn:
                          RestaurantActivity.user.setGenre(3);
                          MatchingActivity.viewpager.setCurrentItem(3,true);
                          break;
                 }
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_genre, container, false);
    }
}