package com.jonathanharkcer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    public static FragmentTwo newInstance() {

        Bundle args = new Bundle();

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentTwo(){

    }

    @Override
    public void onCreate(Bundle savedInstanseState)
    {
        super.onCreate(savedInstanseState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){
        View result = inflater.inflate(R.layout.fragment_two, container, false);
        return result;
    }
}
