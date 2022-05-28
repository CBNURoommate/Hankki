package com.example.hankki;

public class Menu_Class {
    private int id;
    private String name;
    private int img;

    public Menu_Class(int id, String name,int img){
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }
}


