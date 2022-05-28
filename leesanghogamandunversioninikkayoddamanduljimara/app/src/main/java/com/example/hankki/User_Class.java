package com.example.hankki;

public class User_Class {
       private String id;
       private String password;
       private String name;
       private int genre;
       private int spicy;

       public User_Class(String id, String password, String name, int genre, int spicy){
            this.id =  id;
            this.password = password;
            this.name = name;
            this.genre = genre;
            this.spicy = spicy;
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
}


