package com.example.hankki;

import android.graphics.drawable.Drawable;

public class getImg {


    public static int getImg(int n)
    {
        int dr;
        switch(n)
        {
            case 0:
                dr=R.drawable.budae;
                break;

            case 1:
                dr= R.drawable.lotte;
                break;
            case 2:
                dr=R.drawable.chupo;
                break;
            case 3:
                dr=R.drawable.samchun;
                break;
            case 4:
                dr=R.drawable.bigdonburi;
                break;
            case 5:
                dr=R.drawable.cookmesia;
                break;
            case 6:
                dr=R.drawable.sammi;
                break;
            case 7:
                dr=R.drawable.soinbobu;
                break;
            case 8:
                dr=R.drawable.banish;
                break;
            case 9:
                dr=R.drawable.hanga;
                break;
            case 10:
                dr=R.drawable.menya;
                break;
            case 501: case 502:
                dr=R.drawable.budae;
                break;
            case 503:
                dr=R.drawable.lotte;
                break;
            case 504: case 505: case 506:
                dr=R.drawable.soin_bosam;
                break;
            case  507:
                dr=R.drawable.soin_ramen;
                break;
            case 508:
                dr=R.drawable.bani_maho;
                break;
            case  509:
                dr=R.drawable.bani_berchi;
                break;
            case 510:
                dr=R.drawable.bani_berchi2;
                break;
            case 511:
                dr=R.drawable.bani_bella;
                break;
            case 512:
                dr=R.drawable.bani_fore;
                break;
            case 513:
                dr=R.drawable.hanga_marine;
                break;
            case 514:
                dr=R.drawable.hanga_jam;
                break;
            case 515:
                dr=R.drawable.hanga_marinebob;
                break;
            case 516:
                dr=R.drawable.hanga_cco;
                break;
            case 517:
                dr=R.drawable.hanga_tang;
                break;
            case 518:
                dr=R.drawable.menya_don;
                break;
            case 519:
                dr=R.drawable.menya_kara;
                break;
            case 520:
                dr=R.drawable.menya_miso;
                break;
            case 521:
                dr=R.drawable.menya_oco;
                break;
            case 522:
                dr=R.drawable.menya_chca;
                break;
            case 523:
                dr=R.drawable.menya_gyu;
                break;
            case 524:
                dr=R.drawable.menya_gyo;
                break;

            default:
                dr=0;
                break;
        }
        return dr;
    }
}
