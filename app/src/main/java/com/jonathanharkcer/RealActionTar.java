package com.jonathanharkcer;

import java.util.Calendar;

public class RealActionTar {
    private Calendar calendar;
    private String action;

    public void setCalendar(Calendar cal)
    {
        calendar = cal;
    }
    public Calendar getCalendar()
    {
        return calendar;
    }

    public void setAction(String str){
        action = str;
    }
    public String getAction()
    {
        return action;
    }
}
