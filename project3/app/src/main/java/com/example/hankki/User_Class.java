package com.example.hankki;

public class User_Class {
       private String id;
       private String password;
       private String name;
       private int genre;
       private int spicy;
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

       public double getLatitude() { return latitude; }

       public void setLatitude(double latitude) { this.latitude = latitude; }

       public double getLongitude() { return longitude; }
}


