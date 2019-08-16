package com.jonathanharkcer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentZero extends Fragment {

        Context context;

        public static FragmentZero newInstance() {

        Bundle args = new Bundle();

        FragmentZero fragment = new FragmentZero();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentZero(){

    }

    @Override
    public void onCreate(Bundle savedInstanseState)
    {
        super.onCreate(savedInstanseState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){
            View result = inflater.inflate(R.layout.fragment_zero, container, false);
            context = result.getContext();
            Button addTar = (Button)result.findViewById(R.id.AddTarget);
            addTar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SelectCategory.class);
                    startActivity(intent);
                }
            });
            return result;
    }
}
