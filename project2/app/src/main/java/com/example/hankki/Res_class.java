package com.example.hankki;

import java.util.ArrayList;

public class Res_class {
    private String Res_id; // 식당 고유 id
    private String Res_name; // 가게 이름
    private int Res_img; // 가게 이미지
    public double latitude; // 가게 lat좌표
    public double longitude; // 가게 long좌표
    private String Res_address; // 가게 실제 주소
    private int genre; // 음식종류 ex) 1:한식 2:중식 3:양식
    private int spicy; // 매움 1 안매움 0
    private float star; // 별점
    public ArrayList<Menu_Class> menu_list;

    public Res_class(String Res_id, String Res_name, int Res_img, double latitude, double longitude, int genre, int spicy,ArrayList<Menu_Class> menu_list,float star){
        this.Res_id = Res_id;
        this.Res_name = Res_name;
        this.Res_img = Res_img;
        this.latitude = latitude;
        this.longitude = longitude;
        this.genre = genre;
        this.spicy = spicy;
        this.menu_list = menu_list;
        this.star = star;
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

    public int getGenre() {
        return genre;
    }

    public int getSpicy() {
        return spicy;
    }

    public ArrayList<Menu_Class> getMenu_list() {
        return menu_list;
    }

    public void setMenu_list(ArrayList<Menu_Class> menu_list) {
        this.menu_list = menu_list;
    }

    public float getStar() { return star; }

    public void setStar(float star) { this.star = star; }
}
