package com.example.jonathanharkcer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    Context context;
    TextView text;

    public static FragmentOne newInstance() {

        Bundle args = new Bundle();

        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentOne(){

    }

    @Override
    public void onCreate(Bundle savedInstanseState)
    {
        super.onCreate(savedInstanseState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){
        View result = inflater.inflate(R.layout.fragment_one, container, false);

        context = result.getContext();

        Button stackBut = (Button)result.findViewById(R.id.RadStack);
        text = (TextView)result.findViewById(R.id.Text);
        stackBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("Стек");
            }
        });

        Button scheduleBut = (Button)result.findViewById(R.id.RadSchedule);
        scheduleBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("Расписание");
            }
        });

        return result;
    }

}
