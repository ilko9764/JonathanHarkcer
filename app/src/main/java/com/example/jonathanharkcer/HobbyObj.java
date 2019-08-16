package com.example.jonathanharkcer;

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
import android.text.format.DateUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
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

public class HobbyObj extends AppCompatActivity implements DataDialog {

    private  String fileName = "Hobby.json";
    private JasonHelp<HobbyTarget> jasonHelp;

    List<HobbyTarget> list;

    private HobbyTarget hobbyTarget = null;

    private String name = null;
    private String enjoy = null;
    private String forWhomDoingThis = null;
    private String reasonForWanting = null;
    private String inspiration = null;
    private String whatISeeResalt = null;
    private String whatDoingResalt = null;
    private String whatMaterialsINeed = null;
    private String dressCod = null;
    private String whatInformationINeed = null;
    private String whatItTakeTime = null;
    private String whatItTakeMoney = null;
    private String whatItDiffculty = null;
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
        setContentView(R.layout.activity_hobby_obj);

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


        Spinner spinnerEnj = (Spinner) findViewById(R.id.addEnjoy);
        Spinner spinnerDif = (Spinner) findViewById(R.id.addWhatItDiffculty);

        String[] enj = getResources().getStringArray(R.array.hobbyEnjArr);
        String[] dif = getResources().getStringArray(R.array.hobbyDifArr);

        ArrayAdapter<String> adapterEnj = new ArrayAdapter<String>(this, R.layout.spinner_style, enj);
        ArrayAdapter<String> adapterDif = new ArrayAdapter<String>(this, R.layout.spinner_style, dif);

        adapterEnj.setDropDownViewResource(R.layout.spinner_dropdown_style);
        adapterDif.setDropDownViewResource(R.layout.spinner_dropdown_style);

        spinnerEnj.setAdapter(adapterEnj);
        spinnerDif.setAdapter(adapterDif);


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

        jasonHelp = new JasonHelp<>(fileName);

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
        Button bt3 = (Button)findViewById(R.id.AddSelfRealiz);

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
        Button bt3 = (Button)findViewById(R.id.AddSelfRealiz);

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
        list = jasonHelp.imoportFronJSON(this, HobbyTarget.class);
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
        new DatePickerDialog(HobbyObj.this, dac,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void setTime(View v){
        new TimePickerDialog(HobbyObj.this, tic,
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

        Spinner addEnjoy = (Spinner)findViewById(R.id.addEnjoy);
        enjoy = addEnjoy.getSelectedItem().toString();

        EditText addForWhomDoingThis = (EditText)findViewById(R.id.addForWhomDoingThis);
        forWhomDoingThis = addForWhomDoingThis.getText().toString();

        EditText addReasonForWanting = (EditText)findViewById(R.id.addReasonForWanting);
        reasonForWanting = addReasonForWanting.getText().toString();

        EditText addInspiration = (EditText) findViewById(R.id.addInspiration);
        inspiration = addInspiration.getText().toString();

        EditText addIWhatISeeResalt = (EditText) findViewById(R.id.addWhatISeeResalt);
        whatISeeResalt = addIWhatISeeResalt.getText().toString();

        EditText addWhatDoingResalt = (EditText) findViewById(R.id.addWhatDoingResalt);
        whatDoingResalt = addWhatDoingResalt.getText().toString();

        EditText addWhatMaterialsINeed = (EditText) findViewById(R.id.addWhatMaterialsINeed);
        whatMaterialsINeed = addWhatMaterialsINeed.getText().toString();

        EditText addDressCod = (EditText) findViewById(R.id.addDressCod);
        dressCod = addDressCod.getText().toString();

        EditText addWhatInformationINeed = (EditText) findViewById(R.id.addWhatInformationINeed);
        whatInformationINeed = addWhatInformationINeed.getText().toString();

        EditText addWhatItTakeTime = (EditText) findViewById(R.id.addWhatItTakeTime);
        whatItTakeTime = addWhatItTakeTime.getText().toString();

        EditText addWhatItTakeMoney = (EditText) findViewById(R.id.addWhatItTakeMoney);
        whatItTakeMoney = addWhatItTakeMoney.getText().toString();

        Spinner addWhatItDiffculty = (Spinner) findViewById(R.id.addWhatItDiffculty);
        whatItDiffculty = addWhatItDiffculty.getSelectedItem().toString();

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
        hobbyTarget = new  HobbyTarget();
        if (name.length() != 0)
            hobbyTarget.setName(name);
        if (enjoy.length() != 0)
            hobbyTarget.setEnjoy(enjoy);
        if (forWhomDoingThis.length() != 0)
            hobbyTarget.setForWhomDoingThis(forWhomDoingThis);
        if (reasonForWanting.length() != 0)
            hobbyTarget.setReasonForWanting(reasonForWanting);
        if (inspiration.length() != 0)
            hobbyTarget.setInspiration(inspiration);
        if (whatISeeResalt.length() != 0)
            hobbyTarget.setWhatISeeResalt(whatISeeResalt);
        if (whatDoingResalt.length() != 0)
            hobbyTarget.setWhatDoingResalt(whatDoingResalt);
        if (whatMaterialsINeed.length() != 0)
            hobbyTarget.setWhatMaterialsINeed(whatMaterialsINeed);
        if (dressCod.length() != 0)
            hobbyTarget.setDressCod(dressCod);

        if (whatInformationINeed.length() != 0)
            hobbyTarget.setWhatInformationINeed(whatInformationINeed);
        if (whatItTakeTime.length() != 0)
            hobbyTarget.setWhatItTakeTime(whatItTakeTime);
        if (whatItTakeMoney.length() != 0)
            hobbyTarget.setWhatItTakeMoney(whatItTakeMoney);
        if (whatItDiffculty.length() != 0)
            hobbyTarget.setWhatItDiffculty(whatItDiffculty);
        if (nameParents.length() != 0)
            hobbyTarget.setNameParents(nameParents);
        if (realActionTarListObj.size() != 0)
            hobbyTarget.setRealActionList(realActionTarListObj);

        name = null;
        enjoy = null;
        forWhomDoingThis = null;
        reasonForWanting = null;
        inspiration = null;
        whatISeeResalt = null;
        whatDoingResalt = null;
        whatMaterialsINeed = null;
        dressCod = null;
        whatInformationINeed = null;
        whatItTakeTime = null;
        whatItTakeMoney = null;
        whatItDiffculty = null;
        nameParents = null;
        realActionTarListObj = null;
    }
    //------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------Записать SelfRealiz в список list; Очистить буфер SelfRealiz ( инициализизировать null)
    public void StepSix()
    {
        if(hobbyTarget.getName() != null){
            list.add(hobbyTarget);
            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Необходимо ввести что я хочю, нужно повторить", Toast.LENGTH_LONG).show();
        }



        hobbyTarget = null;
    }
    //-----------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------Записати в ясон
    public void StepSewen()
    {
        boolean result = jasonHelp.exportToJSON(this, list, HobbyTarget.class);

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
