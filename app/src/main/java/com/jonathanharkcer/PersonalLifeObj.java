package com.jonathanharkcer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonalLifeObj extends AppCompatActivity implements DataDialog {


    private String fileName = "PersonalLife.json";
    private JasonHelp<PersonalLifeTarget> jasonHelp;

    List<PersonalLifeTarget> list;

    private PersonalLifeTarget personalLifeTarget = null;

    private String name = null;
    private String whatFor = null;
    private String reward = null;
    private String forWhomIDoingThis = null;
    private String reasonForWanting = null;
    private String inspiration = null;
    private String influence = null;
    private String thereAfter = null;
    private String nameParents = null;
    private List<RealActionTar> realActionTarListObj = null;

    private List<RealActionTar> realActionTarList = null;
    private RealActionTar realActionTar = null;

    private String nameRealActions = null;
    private Calendar dateAndTime = null;

    private boolean flagStepZero = true;

    private boolean flagButtonAnim = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_life_obj);

        //----------------------------------------------------------
        ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));

        TextView tv = new TextView(getApplicationContext());
        Typeface typeface = ResourcesCompat.getFont(this, R.font.manuskript);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText(R.string.app_name);
        tv.setTextSize(25);
        tv.setTextColor(Color.BLACK);
        tv.setTypeface(typeface, typeface.ITALIC);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(tv);
        //-------------------------------------------------------------


        Spinner spinner = (Spinner) findViewById(R.id.addReward);

        String[] rew = getResources().getStringArray(R.array.rewArr);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_style, rew);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);

        spinner.setAdapter(adapter);

        jasonHelp = new JasonHelp<>(fileName);

        //----------------------------------------------------------------





        final ScrollView sv = (ScrollView)findViewById(R.id.contDialigFragment);
        sv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if(sv.getChildAt(0).getBottom() <= (sv.getHeight() + sv.getScrollY())){
                    flagButtonAnim = animButtonRadBottom(0.5f);
                }else{
                    if(flagButtonAnim){

                        flagButtonAnim = animButtonRadTop(0.5f);
                    }
                }
            }
        });


    }

    private boolean animButtonRadBottom(float speed)
    {
        Display mdisp = getWindowManager().getDefaultDisplay();
        Point mdispSize = new Point();
        mdisp.getSize(mdispSize);
        double maxX = mdispSize.x;

        float px1 = (float)(maxX - 130 * Resources.getSystem().getDisplayMetrics().density);
        float px2 = 90 * Resources.getSystem().getDisplayMetrics().density;


        float px3 = (float)(maxX / 2 - 55 * Resources.getSystem().getDisplayMetrics().density);

        float px4 = (180 * Resources.getSystem().getDisplayMetrics().density);

        float px5 = (float)(20 * Resources.getSystem().getDisplayMetrics().density);


        speed = speed * Resources.getSystem().getDisplayMetrics().density;
        long t1, t2, t3, t4, t5;

        t1 = (long)(px1 / speed);
        t2 = (long)(px2 / speed);
        t3 = (long)(px3 / speed);
        t4 = (long)(px4 / speed);
        t5 = (long)(px5 / speed);

        Button bt = (Button)findViewById(R.id.RadHome);
        Button bt2 = (Button)findViewById(R.id.AddAct);
        Button bt3 = (Button)findViewById(R.id.AddSPersLife);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(bt, "translationX", -px1);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(bt2, "translationY", px2);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(bt2, "translationX", -px3);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(bt3, "translationY", px4);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(bt3, "translationX", -px5);

        animator1.setDuration(t1);
        animator2.setDuration(t2);
        animator3.setDuration(t3);
        animator4.setDuration(t4);
        animator5.setDuration(t5);

        AnimatorSet steck1 = new AnimatorSet();

        steck1.play(animator3).after(animator2);
        steck1.play(animator5).after(animator4);
        steck1.play(animator2).with(animator1);
        steck1.play(animator4).with(animator2);
        steck1.start();

        return true;
    }

    private boolean animButtonRadTop(float speed)
    {
        Display mdisp = getWindowManager().getDefaultDisplay();
        Point mdispSize = new Point();
        mdisp.getSize(mdispSize);
        double maxX = mdispSize.x;

        float px1 = (float)(maxX - 130 * Resources.getSystem().getDisplayMetrics().density);
        float px2 = 90 * Resources.getSystem().getDisplayMetrics().density;


        float px3 = (float)(maxX / 2 - 55 * Resources.getSystem().getDisplayMetrics().density);

        float px4 = (180 * Resources.getSystem().getDisplayMetrics().density);

        float px5 = (float)(20 * Resources.getSystem().getDisplayMetrics().density);


        speed = speed * Resources.getSystem().getDisplayMetrics().density;
        long t1, t2, t3, t4, t5;

        t1 = (long)(px1 / speed);
        t2 = (long)(px2 / speed);
        t3 = (long)(px3 / speed);
        t4 = (long)(px4 / speed);
        t5 = (long)(px5 / speed);

        Button bt = (Button)findViewById(R.id.RadHome);
        Button bt2 = (Button)findViewById(R.id.AddAct);
        Button bt3 = (Button)findViewById(R.id.AddSPersLife);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(bt, "translationX", 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(bt2, "translationY", 0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(bt2, "translationX", 0f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(bt3, "translationY", -0f);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(bt3, "translationX", 0f);

        animator1.setDuration(t1);
        animator2.setDuration(t2);
        animator3.setDuration(t3);
        animator4.setDuration(t4);
        animator5.setDuration(t5);

        AnimatorSet steck1 = new AnimatorSet();

        steck1.play(animator2).after(animator3);
        steck1.play(animator4).after(animator5);
        steck1.play(animator1).with(animator3);
        steck1.play(animator3).with(animator5);
        steck1.start();

        return false;
    }

    public void ChechList()
    {
        list = jasonHelp.imoportFronJSON(this, PersonalLifeTarget.class);
        if(list == null)
        {
            list = new ArrayList<>();
        }
    }


    //------------------------------------------------------------------Инициализировать массив-список RealTarList
    public void StepZero()
    {
        flagStepZero = false;
        realActionTarList = new ArrayList<>();
    }

    //------------------------------------------------------------------


    //------------------------------------------------------------------Инициализировать RealName, Calendar
    public void StepOne() // Создание диалогового окна
    {
        CustomDialogAction dialogAction = new CustomDialogAction();
        dialogAction.show(getSupportFragmentManager(), "custom");

        dateAndTime = Calendar.getInstance();
    }
    public void returnDate(String s)
    {
        if (s != null && s.length() != 0) {
            nameRealActions = s;
            Toast.makeText(this, "Действие добавлено", Toast.LENGTH_LONG).show();
            StepTwo();
            StepThree();
        }
        else
        {
            Toast.makeText(this, "Необходимо ввести что я хочю, нужно повторить", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void setDate(View v) {
        new DatePickerDialog(PersonalLifeObj.this, dac,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void setTime(View v){
        new TimePickerDialog(PersonalLifeObj.this, tic,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true).show();
    }

    TimePickerDialog.OnTimeSetListener tic = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, i);
            dateAndTime.set(Calendar.MINUTE, i1);
        }
    };

    DatePickerDialog.OnDateSetListener dac = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };
    //----------------------------------------------------------------------------

    //----------------------------------------------------------------------------Записать в объект realTar; Очистить буфера RealName, Calendar ( инициализизировать null)
    public void StepTwo()
    {
        realActionTar = new RealActionTar();
        realActionTar.setCalendar(dateAndTime);
        realActionTar.setAction(nameRealActions);

        dateAndTime = null;
        nameRealActions = null;
    }
    //------------------------------------------------------------------------------


    //------------------------------------------------------------------------------Записать realTar в массив-список RealTarList; Очистить буфер realTar ( инициализизировать null)
    public void StepThree()
    {

        realActionTarList.add(realActionTar);

        realActionTar = null;
    }
    //-------------------------------------------------------------------------------Можно циклицески повторять с StepOne для заполнения списка



    //----------------------------------------------------------------------------Инициализировать поля SelfRealiz; Очистить буфер RealTarList ( инициализизировать null)
    public void StepFour()
    {

        EditText addName = (EditText) findViewById(R.id.addName);
        name = addName.getText().toString();

        EditText addWhatFor = (EditText) findViewById(R.id.addWhatFor);
        whatFor = addWhatFor.getText().toString();

        Spinner addReward = (Spinner) findViewById(R.id.addReward);
        reward = addReward.getSelectedItem().toString();

        EditText addFromWhom = (EditText) findViewById(R.id.addforItDoingThis);
        forWhomIDoingThis = addFromWhom.getText().toString();

        EditText addReasonForWanting = (EditText) findViewById(R.id.addReasonForWantingText);
        reasonForWanting = addReasonForWanting.getText().toString();

        EditText addInspiration = (EditText) findViewById(R.id.addInspiration);
        inspiration = addInspiration.getText().toString();

        EditText addInfluense = (EditText) findViewById(R.id.addInfluence);
        influence = addInfluense.getText().toString();

        EditText addTheraAfter = (EditText) findViewById(R.id.addThereAfter);
        thereAfter = addTheraAfter.getText().toString();

        EditText addNamePatents = (EditText) findViewById(R.id.addNameParents);
        nameParents = addNamePatents.getText().toString();

        realActionTarListObj = new ArrayList<>();
        if(realActionTarList != null) {
            for (RealActionTar real : realActionTarList)
                realActionTarListObj.add(real);
            realActionTarList = null;
        }
    }
    //-----------------------------------------------------------------------------------




    //-----------------------------------------------------------------------------------Записать поля в объект SelfRealiz;  Очистить буфера Name, NameParens, Resolve, RealTarListObj  ... ( инициализизировать null)
    public void StepFive()
    {
        personalLifeTarget = new PersonalLifeTarget();
        if (name.length() != 0)
            personalLifeTarget.setName(name);
        if (whatFor.length() != 0)
            personalLifeTarget.setWhatFor(whatFor);
        if (reward.length() != 0)
            personalLifeTarget.setReward(reward);
        if (forWhomIDoingThis.length() != 0)
            personalLifeTarget.setForWhomIDoingThis(forWhomIDoingThis);
        if (reasonForWanting.length() != 0)
            personalLifeTarget.setReasonForWanting(reasonForWanting);
        if (inspiration.length() != 0)
            personalLifeTarget.setInspiration(inspiration);
        if (influence.length() != 0)
            personalLifeTarget.setInfluence(influence);
        if (thereAfter.length() != 0)
            personalLifeTarget.setThereAfter(thereAfter);
        if (nameParents.length() != 0)
            personalLifeTarget.setNameParens(nameParents);
        if (realActionTarListObj.size() != 0)
            personalLifeTarget.setRealActionList(realActionTarListObj);


        name = null;
        whatFor = null;
        reward = null;
        forWhomIDoingThis = null;
        reasonForWanting = null;
        inspiration = null;
        influence = null;
        thereAfter = null;
        nameParents = null;
        realActionTarListObj = null;
    }
    //------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------Записать SelfRealiz в список list; Очистить буфер SelfRealiz ( инициализизировать null)
    public void StepSix()
    {
        if(personalLifeTarget.getName() != null){
            list.add(personalLifeTarget);
            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Необходимо ввести что я хочю, нужно повторить", Toast.LENGTH_LONG).show();
        }



        personalLifeTarget = null;
    }
    //-----------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------Записати в ясон
    public void StepSewen()
    {
        boolean result = jasonHelp.exportToJSON(this, list, PersonalLifeTarget.class);

        list = null;
    }


    //---------------------------------------------------------------------------------Домой
    public void Home(View v)
    {
        Intent intent = new  Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void WriteRealTar(View v)
    {
        if(flagStepZero)
            StepZero();
        StepOne();

    }
    public void WriteSelfRealization(View v)
    {
        flagStepZero = true;
        ChechList();
        StepFour();
        StepFive();
        StepSix();
        StepSewen();
    }
}


