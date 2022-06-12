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
            default:
                dr=0;
                break;
        }
        return dr;
    }
}
