package com.example.hankki;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CaftueFrame extends Fragment {
    final Bundle bundle = new Bundle();

    TextView textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13;
    String hbm = ""; String hbs = ""; String hlm = ""; String hls = ""; String hdm = ""; String hds = "";
    Element hbA, hlA, hdA; Elements hbB, hlB, hdB;
    String blm = ""; String bls = "";
    Element blA; Elements blB;
    String elm = ""; String els = ""; String edm = ""; String eds = "";
    Element elA, edA; Elements elB, edB;
    String sdate = "";
    Element edate;

    String url = "https://www.cbnucoop.com/service/restaurant/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.frame_caftue, container, false);

        textView = (TextView) view.findViewById(R.id.tue_h_bm);
        textView2 = (TextView) view.findViewById(R.id.tue_h_bs);
        textView3 = (TextView) view.findViewById(R.id.tue_h_lm);
        textView4 = (TextView) view.findViewById(R.id.tue_h_ls);
        textView5 = (TextView) view.findViewById(R.id.tue_h_dm);
        textView6 = (TextView) view.findViewById(R.id.tue_h_ds);
        textView7 = (TextView) view.findViewById(R.id.tue_b_lm);
        textView8 = (TextView) view.findViewById(R.id.tue_b_ls);
        textView9 = (TextView) view.findViewById(R.id.tue_e_lm);
        textView10 = (TextView) view.findViewById(R.id.tue_e_ls);
        textView11 = (TextView) view.findViewById(R.id.tue_e_dm);
        textView12 = (TextView) view.findViewById(R.id.tue_e_ds);
        textView13 = (TextView) view.findViewById(R.id.tue_date);

        new Thread(){
            @Override
            public void run(){
                Document document = null;

                try {
                    document = Jsoup.connect(url).get();

                    hbA = document.select(".menu[data-table='18-9-17-1'] h6").first();
                    hbB = document.select(".menu[data-table='18-9-17-1'] .side");
                    hlA = document.select(".menu[data-table='18-8-16-1'] h6").first();
                    hlB = document.select(".menu[data-table='18-8-16-1'] .side");
                    hdA = document.select(".menu[data-table='18-10-18-1'] h6").first();
                    hdB = document.select(".menu[data-table='18-10-18-1'] .side");
                    blA = document.select(".menu[data-table='19-7-14-1'] h6").first();
                    blB = document.select(".menu[data-table='19-7-14-1'] .side");
                    elA = document.select(".menu[data-table='20-6-12-1'] h6").first();
                    elB = document.select(".menu[data-table='20-6-12-1'] .side");
                    edA = document.select(".menu[data-table='20-13-25-1'] h6").first();
                    edB = document.select(".menu[data-table='20-13-25-1'] .side");
                    edate = document.select("#tab1 > div:nth-child(1) > table:nth-child(1) > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(2)").first();

                    if(hbA != null){
                        hbm = hbA.text();
                    } else hbm = " ";
                    if(hbB != null){
                        for(int i = 0; i < hbB.size(); i++){
                            hbs += hbB.get(i).text() + " ";
                        }
                    } else hbs = " ";
                    if(hlA != null){
                        hlm += hlA.text();
                    } else hlm = " ";
                    if(hlB != null){
                        for(int i = 0; i < hlB.size(); i++){
                            hls += hlB.get(i).text() + " ";
                        }
                    } else hls = " ";
                    if(hdA != null){
                        hdm = hdA.text();
                    } else hdm = " ";
                    if(hdB != null){
                        for(int i = 0; i < hdB.size(); i++){
                            hds += hdB.get(i).text() + " ";
                        }
                    } else hds = " ";

                    if(blA != null){
                        blm += blA.text();
                    } else blm = " ";
                    if(blB != null){
                        for(int i = 0; i < blB.size(); i++){
                            bls += blB.get(i).text() + " ";
                        }
                    } else bls = " ";

                    if(elA != null){
                        elm += elA.text();
                    } else elm = " ";
                    if(elB != null){
                        for(int i = 0; i < elB.size(); i++){
                            els += elB.get(i).text() + " ";
                        }
                    } else els = " ";
                    if(edA != null){
                        edm = edA.text();
                    } else edm = " ";
                    if(edB != null){
                        for(int i = 0; i < edB.size(); i++){
                            eds += edB.get(i).text() + " ";
                        }
                    } else eds = " ";
                    if(edate != null){
                        sdate = edate.text();
                    } else sdate = " ";

                    bundle.putString("hbm", hbm);
                    bundle.putString("hbs", hbs);
                    bundle.putString("hlm", hlm);
                    bundle.putString("hls", hls);
                    bundle.putString("hdm", hdm);
                    bundle.putString("hds", hds);
                    bundle.putString("blm", blm);
                    bundle.putString("bls", bls);
                    bundle.putString("elm", elm);
                    bundle.putString("els", els);
                    bundle.putString("edm", edm);
                    bundle.putString("eds", eds);
                    bundle.putString("date", sdate);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return view;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            textView.setText(bundle.getString("hbm"));
            textView2.setText(bundle.getString("hbs"));
            textView3.setText(bundle.getString("hlm"));
            textView4.setText(bundle.getString("hls"));
            textView5.setText(bundle.getString("hdm"));
            textView6.setText(bundle.getString("hds"));
            textView7.setText(bundle.getString("blm"));
            textView8.setText(bundle.getString("bls"));
            textView9.setText(bundle.getString("elm"));
            textView10.setText(bundle.getString("els"));
            textView11.setText(bundle.getString("edm"));
            textView12.setText(bundle.getString("eds"));
            textView13.setText(bundle.getString("date"));
        }
    };
}
