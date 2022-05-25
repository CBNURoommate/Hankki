package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Res_Detail extends AppCompatActivity implements OnMapReadyCallback {

    Res_class selectedRestaurant;
    private android.app.FragmentManager fragmentManager;
    private MapFragment mapFragment;
    private double x;
    private double y;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);

        getSelectedRestaurant();

        setValues();

        btn();

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);


    }

    private void btn(){

        Button menu_btn = (Button) findViewById(R.id.menu_btn);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu_list.class);
                intent.putExtra("id",selectedRestaurant.getRes_id());
                startActivity(intent);
            }
        });

    }

    private void setValues() {
        TextView tv = findViewById(R.id.res_detail_name);
        ImageView iv = findViewById(R.id.res_detail_img);

        tv.setText(selectedRestaurant.getRes_name());
        iv.setImageResource(selectedRestaurant.getRes_img());
        x = selectedRestaurant.getLatitude();
        y = selectedRestaurant.getLongitude();
    }

    private void getSelectedRestaurant() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        selectedRestaurant = RestaurantActivity.res_list.get(Integer.valueOf(id));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(x, y);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(selectedRestaurant.getRes_name()); //이름
        markerOptions.snippet(selectedRestaurant.getRes_name());
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }

}