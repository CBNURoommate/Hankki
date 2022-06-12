package com.example.hankki;

public class Menu_Class {
    private String id;
    private String name;
    private int img;

    public Menu_Class(String id, String name,int img){
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getId() {
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


