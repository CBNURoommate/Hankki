package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PersonalActivity extends AppCompatActivity {

    public static TextView nowusername;
    public static TextView nowgerne;
    public static TextView nowspicy;
    public static TextView nowsalty;
    public static TextView nowsea;
    public static TextView nowmush;
    public static TextView nowcucum;
    public static TextView nowgosu;
    public static TextView nowgut;

    void settingUser()
    {
        if(((nowMember) getApplication()).getName()!=null)
            PersonalActivity.nowusername.setText(((nowMember) getApplication()).getName());
        int gerne=((nowMember)getApplication()).getGenre();
        if(gerne==1)
        {
            PersonalActivity.nowgerne.setText("한식");
        }
        else if(gerne==2)
        {
            PersonalActivity.nowgerne.setText("중식");
        }
        else if(gerne==3)
        {
            PersonalActivity.nowgerne.setText("양식");
        }
        else if(gerne==4)
        {
            PersonalActivity.nowgerne.setText("일식");
        }
        else if(gerne==5)
        {
            PersonalActivity.nowgerne.setText("분식");
        }
        else;

        PersonalActivity.nowspicy.setText(((nowMember)getApplication()).getSpicy()+"단계");
        PersonalActivity.nowsalty.setText(((nowMember)getApplication()).getSalty()+"단계");
        int sea=((nowMember)getApplication()).getSea();
        if(sea==1)
        {
            PersonalActivity.nowsea.setText("X");
        }
        else if(sea==0)
        {
            PersonalActivity.nowsea.setText("O");
        }
        else;

        int mush=((nowMember)getApplication()).getMush();
        if(mush==1)
        {
            PersonalActivity.nowmush.setText("X");
        }
        else if(mush==0)
        {
            PersonalActivity.nowmush.setText("O");
        }
        else;


        int cucum=((nowMember)getApplication()).getCucum();
        if(cucum==1)
        {
            PersonalActivity.nowcucum.setText("X");
        }
        else if(cucum==0)
        {
            PersonalActivity.nowcucum.setText("O");
        }
        else;

        int gosu=((nowMember)getApplication()).getGosu();
        if(gosu==1)
        {
            PersonalActivity.nowgosu.setText("X");
        }
        else if(gosu==0)
        {
            PersonalActivity.nowgosu.setText("O");
        }
        else;

        int gut=((nowMember)getApplication()).getGut();
        if(gut==1)
        {
            PersonalActivity.nowgut.setText("X");
        }
        else if(gut==0)
        {
            PersonalActivity.nowgut.setText("O");
        }
        else;

    }
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        RestaurantActivity.res_list.clear();
        nowusername=(TextView)findViewById(R.id.nowusername);
        nowgerne=(TextView)findViewById(R.id.genreText);
        nowspicy=(TextView)findViewById(R.id.spicyText);
        nowsalty=(TextView)findViewById(R.id.saltyText);
        nowsea=(TextView)findViewById(R.id.seaText);
        nowmush=(TextView)findViewById(R.id.mushText);
        nowcucum=(TextView)findViewById(R.id.cucumText);
        nowgosu=(TextView)findViewById(R.id.gosuText);
        nowgut=(TextView)findViewById(R.id.gutText);

        settingUser();

        // 하단바 버튼 기능
        ImageButton matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MatchingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton cafeteriaBtn = (ImageButton) findViewById(R.id.cafeteriaBtn);
        cafeteriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CafeteriaActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton restaurantBtn = (ImageButton) findViewById(R.id.restaurantBtn);
        restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });

        Button gologin=(Button) findViewById(R.id.gologin);
        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        Button goregister=(Button) findViewById(R.id.goregister);
        goregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }


}