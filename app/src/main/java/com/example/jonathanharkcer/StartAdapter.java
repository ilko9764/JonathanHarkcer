package com.example.jonathanharkcer;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class StartAdapter extends FragmentPagerAdapter {
    public StartAdapter(FragmentManager mgr){
        super(mgr);
    }

    @Override
    public int getCount(){
        return (3);
    } // кол-во страниц

    @Override
    public Fragment getItem(int position){ // возврящает фрагмент по номеру страницы

            if (position == 0)
                return (FragmentZero.newInstance());
            if (position == 1)
                return (FragmentOne.newInstance());
            if (position == 2)
                return (FragmentTwo.newInstance());
            else
                return (FragmentOne.newInstance());
    }
}

