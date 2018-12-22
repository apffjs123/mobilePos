package com.cookandroid.se_02_mobilepos_ver2;

/**
 * Created by LG on 2018-12-18.
 */
// 주문 메뉴에 대한 객체
//주문메뉴 디비, 주문메뉴에 대한 정보, 이름, 가격, 수량, 이미 주문여부에 대한 정보를 담음
public class orderSheet {

    private String ordMenuName;
    private int ordprice;
    private int ordEa;

    public orderSheet() {
        this.ordMenuName = null;
        this.ordprice = 0;
        this.ordEa =0;
    }

    public orderSheet(String aName, int aPrice, int aEa){
        this.ordMenuName = aName;
        this.ordprice = aPrice;
        this.ordEa = aEa;
    }

    public String getOrdMenuName() {
        return ordMenuName;
    }



    public int getOrdprice() {
        return ordprice;
    }


    public int getOrdEa() {
        return ordEa;
    }

    public void setOrdEa(int ordEa) {
        this.ordEa = ordEa;
    }
    // 갯수를 증가
    public void eaUP(){
        this.setOrdEa(this.ordEa++);
    }


}
