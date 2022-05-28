package com.example.hankki;

public class User_Class {
       private String id;
       private String password;
       private String name;
       private int genre;
       private int spicy;
       public double latitude;
       public double longitude;

       public User_Class(String id, String password, String name, int genre, int spicy, double latitude, double longitude){
            this.id =  id;
            this.password = password;
            this.name = name;
            this.genre = genre;
            this.spicy = spicy;
            this.latitude = latitude;
            this.longitude = longitude;
       }

       public String getId() {
              return id;
       }

       public int getGenre() {
              return genre;
       }

       public String getName() {
              return name;
       }

       public int getSpicy() {
              return spicy;
       }

       public double getLatitude() { return latitude; }

       public double getLongitude() { return longitude; }
}


