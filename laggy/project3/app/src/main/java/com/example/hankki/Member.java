package com.example.hankki;

public class Member {

    private String name;
    private String id;
    private String passwd;
    private int genre; // 음식종류 ex) 1:한식 2:중식 3:양식 4:일식 5:분식
    private int spicy; // 매움 0~4
    private int salty; // 짠 정도 0~4
    private int sea; // 해산물 0,1 1이 해산물 있는거 0이 없는거
    private int mush; // 버섯 0,1
    private int cucum; // 오이 0,1
    private int gosu; // 고수 0,1
    private int gut; // 내장 0,1

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getSpicy() {
        return spicy;
    }

    public void setSpicy(int spicy) {
        this.spicy = spicy;
    }

    public int getSalty() {
        return salty;
    }

    public void setSalty(int salty) {
        this.salty = salty;
    }

    public int getSea() {
        return sea;
    }

    public void setSea(int sea) {
        this.sea = sea;
    }

    public int getMush() {
        return mush;
    }

    public void setMush(int mush) {
        this.mush = mush;
    }

    public int getCucum() {
        return cucum;
    }

    public void setCucum(int cucum) {
        this.cucum = cucum;
    }

    public int getGosu() {
        return gosu;
    }

    public void setGosu(int gosu) {
        this.gosu = gosu;
    }

    public int getGut() {
        return gut;
    }

    public void setGut(int gut) {
        this.gut = gut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
