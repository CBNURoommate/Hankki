package com.example.hankki;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CafeteriaFragmentAdapter extends FragmentStateAdapter {
    public int mCount;

    public CafeteriaFragmentAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index==0) return new CafmonFrame();
        else if(index==1) return new CaftueFrame();
        else if(index==2) return new CafwedFrame();
        else if(index==3) return new CafthrFrame();
        else return new CaffriFrame();
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public int getRealPosition(int position) {
        return position % mCount;
    }
}
