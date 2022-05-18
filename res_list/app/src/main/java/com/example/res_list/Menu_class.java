package com.example.res_list;

public class Menu_class extends Res_Detail {
    private int res_id;
    private String name; //메뉴 이름
    private String genre; //음식 장르 한식,중식 등등
    private int price; //메뉴 가격
    private int img; //메뉴 이미지
    private int spicy; // 맵기의 정도

    public Menu_class(int res_id, String name, String genre, int price, int img, int spicy) {
        this.res_id = res_id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.img = img;
        this.spicy = spicy;
    }

    public int getRes_id() { return res_id; }

    public String getName() { return name; }

    public String getGenre() { return genre; }

    public int getPrice() { return price; }

    public int getImg() { return img; }

    public int getSpicy() { return spicy; }

}
