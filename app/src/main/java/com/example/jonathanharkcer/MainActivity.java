package com.example.jonathanharkcer;

import androidx.appcompat.app.AppCompatActivity;

// import android.app.ActionBar;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.TypefaceSpan;
import android.util.LruCache;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------
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
        //---------------------------------------------------------------------------

        ViewPager pager = (ViewPager)findViewById(R.id.startPager); // поиск елемента ViewPager в коде xml
        pager.setAdapter(new StartAdapter(getSupportFragmentManager())); // связь елемента ViewPager с адаптером
        pager.setCurrentItem(1); // устанавливает номер страницы которая будет отображатся при запуске
    }
}

