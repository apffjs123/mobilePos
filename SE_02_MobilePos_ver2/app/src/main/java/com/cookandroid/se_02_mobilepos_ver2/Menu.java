package com.cookandroid.se_02_mobilepos_ver2;

/**
 * Created by LG on 2018-12-18.
 */

public class Menu {

    private String menuName;
    private int price;
    private int ea;
    private boolean ordered;

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public int getEa() {
        return ea;
    }

    public void setEa(int ea) {
        this.ea = ea;
    }

    public int getPrice() {
        return price;
    }

    public String getMenuName() {
        return menuName;
    }

    public Menu(){
        this.menuName = null;
        this.price =0;
        this.ea =0;
        this.ordered = false;
    }

    public Menu(String aUserName, int aPrice, int aEa){
        this.menuName = aUserName;
        this.price = aPrice;
        this.ea = aEa;
        this.ordered = false;
    }
}

