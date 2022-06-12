package com.example.hankki;

public class User_Class {
       private String id;
       private String password;
       private String name;
       private int genre; // 1:한식 2:중식 3:양식 4:일식 5:분식
       private int spicy;
       private int salty;
       private int sea; // 해산물 여부 0,1  1이 못먹는거고 0이 먹는거로 하자.
       private int mush; // 버섯 여부 0,1
       private int cucum; // 오이 여부 0,1
       private int gosu; // 고수 여부 0,1
       private int gut; // 내장 여부 0,1;
       public double latitude;
       public double longitude;

       public User_Class(String id, String password, String name, double latitude, double longitude){
            this.id =  id;
            this.password = password;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

       public int getGenre() {
              return genre;
       }

       public void setGenre(int genre) { this.genre = genre; }

       public String getName() {
              return name;
       }

       public int getSpicy() {
              return spicy;
       }

       public void setSpicy(int spicy) {  this.spicy = spicy; }

       public int getSalty() {
              return salty;
       }

       public void setSalty(int salty) {  this.salty = salty; }

       public void setSea(int sea) {
              this.sea = sea;
       }

       public int getSea() {
              return sea;
       }

       public void setMush(int mush) {
              this.mush = mush;
       }

       public int getMush() {
              return mush;
       }

       public void setCucum(int cucum) {
              this.cucum = cucum;
       }

       public int getCucum() {
              return cucum;
       }

       public void setGosu(int gosu) {
              this.gosu = gosu;
       }

       public int getGosu() {
              return gosu;
       }

       public void setGut(int gut) {
              this.gut = gut;
       }

       public int getGut() {
              return gut;
       }

       public double getLatitude() { return latitude; }

       public void setLatitude(double latitude) { this.latitude = latitude; }

       public double getLongitude() { return longitude; }
}


