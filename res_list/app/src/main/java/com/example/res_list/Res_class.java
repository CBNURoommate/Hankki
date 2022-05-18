package com.example.res_list;

public class Res_class {
    private String Res_id; // 식당 고유 id
    private String Res_name; // 가게 이름
    private int Res_img; // 가게 이미지
    public double latitude; // 가게 lat좌표
    private double longitude; // 가게 long좌표
    private String Res_address; // 가게 실제 주소
    private String food_Genre; // 음식종류
    private Menu_class menu;

    public Res_class(String Res_id, String Res_name, int Res_img, double latitude, double longitude){
        this.Res_id = Res_id;
        this.Res_name = Res_name;
        this.Res_img = Res_img;
        this.latitude = latitude;
        this.longitude = longitude;
        
    }


    public String getRes_id(){
        return Res_id;
    }

    public void setRes_id(String Res_id){
        this.Res_id = Res_id;
    }

    public String getRes_name(){
        return Res_name;
    }

    public void setRes_name(String Res_name){
        this.Res_name = Res_name;
    }

    public int getRes_img(){
        return Res_img;
    }

    public void setRes_img(int Res_img){
        this.Res_img = Res_img;
    }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }
}
