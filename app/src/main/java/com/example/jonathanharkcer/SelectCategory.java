package com.example.jonathanharkcer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SelectCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        //----------------------------------------------------------
        ActionBar actionBar = getSupportActionBar(); // получаю настройки action bar

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000"))); // установка изображения фона actionbar, изображению даётся полностью прозрачный цвет (первые две цыфры отвечают за прозрачность)

        TextView tv = new TextView(getApplicationContext()); // Создание TextView и установка состояния всего приложения
        Typeface typeface = ResourcesCompat.getFont(this, R.font.manuskript); //создание объектной переменной, установка шрифта
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // ширина TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // высота TextView
        tv.setLayoutParams(lp); //передача ширины и высоты TextView
        tv.setText(R.string.app_name); //текст ActionBar
        tv.setTextSize(25); // размер текста
        tv.setTextColor(Color.BLACK); // цвет текста
        tv.setTypeface(typeface, typeface.ITALIC); // пероедача шрифта TextView
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); // опция actionBar котороя позволяет передавать кастомный вид
        actionBar.setCustomView(tv); // передача actionBar TextView
        //-------------------------------------------------------------
    }

    public void hobby(View view)
    {
        Intent intent = new Intent(this, HobbyObj.class);
        startActivity(intent);
    }

    public void personalLife(View view)
    {
        Intent intent = new Intent(this, PersonalLifeObj.class);
        startActivity(intent);
    }

    public void selfRealization(View view)
    {
        Intent intent = new Intent(this, SelfRealizationObj.class);
        startActivity(intent);
    }
}
