package com.jonathanharkcer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialogAction extends DialogFragment {

    private DataDialog dataDialog;
    private Calendar dateAndTime = Calendar.getInstance();

    public void onAttach(Context context)
    {
        super.onAttach(context);
        dataDialog = (DataDialog)context;
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_action, null);

        final EditText editText = (EditText)view.findViewById(R.id.addTar);
        final TextView textView = (TextView)view.findViewById(R.id.TarText);
        //------------------------------------------------------
        Button timeButton = (Button)view.findViewById(R.id.addTime);
        Button calendarButton = (Button)view.findViewById(R.id.addCalendar);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataDialog.setDate(view);
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dataDialog.setTime(view);
            }
        });


        //-----------------------------------------------------------------------
        builder.setView(view);
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dataDialog.returnDate(editText.getText().toString());
            }
        });
        builder.setNegativeButton("Нет", null);
        return builder.create();
    }
}