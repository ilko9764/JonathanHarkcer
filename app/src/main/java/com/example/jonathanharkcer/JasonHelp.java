package com.example.jonathanharkcer;

import android.content.Context;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JasonHelp<T>
{
    private static String fileName; // = "SelfRealization.json";


    public JasonHelp(String s){
        fileName = s;
    }

     public boolean exportToJSON(Context context, List<T> dataList, Type type){
        Gson gson = new Gson();
         String jsonString = null;
        if(type.equals(SelfRealizationTarget.class)) {
            DataItemsSelfRealization dataItemsSelfRealization = new DataItemsSelfRealization();
            dataItemsSelfRealization.setTargets((ArrayList<SelfRealizationTarget>)dataList);
            jsonString = gson.toJson(dataItemsSelfRealization);
        } else if(type.equals(HobbyTarget.class)){
            DataItemsHobby dataItemsHobby = new DataItemsHobby();
            dataItemsHobby.setTargets((ArrayList<HobbyTarget>)dataList);
            jsonString = gson.toJson(dataItemsHobby);
        } else if(type.equals(PersonalLifeTarget.class)){
            DataItemsPersonalLife dataItemsPersonalLife = new DataItemsPersonalLife();
            dataItemsPersonalLife.setTargets((ArrayList<PersonalLifeTarget>)dataList);
            jsonString = gson.toJson(dataItemsPersonalLife);
        } else { jsonString = null; }
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public List<T> imoportFronJSON(Context context, Type type){
        InputStreamReader streamReader = null;
        FileInputStream filterInputStream = null;
        try {
            filterInputStream = context.openFileInput(fileName);
            streamReader = new InputStreamReader(filterInputStream);
            Gson gson = new Gson();
            if(type.equals(SelfRealizationTarget.class)) {
                DataItemsSelfRealization dateItemsSelfRealization = gson.fromJson(streamReader, DataItemsSelfRealization.class);
                return (List<T>) dateItemsSelfRealization.getTargets();
            } else if(type.equals(HobbyTarget.class)){
                DataItemsHobby dataItemsHobby = new DataItemsHobby();
                dataItemsHobby = gson.fromJson(streamReader, DataItemsHobby.class);
                return (List<T>)dataItemsHobby.getTargets();
            } else if(type.equals(PersonalLifeTarget.class)){
                DataItemsPersonalLife dataItemsPersonalLife = new DataItemsPersonalLife();
                dataItemsPersonalLife = gson.fromJson(streamReader, DataItemsPersonalLife.class);
                return (List<T>)dataItemsPersonalLife.getTargets();
            } else {return null;}

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(streamReader !=null){
                try {
                    streamReader.close();
                } catch (IOException e)
                {e.printStackTrace();}
            }
            if(filterInputStream != null){try {
                filterInputStream.close();
            } catch (IOException e){e.printStackTrace();}
            }
        }
        return null;
    }

    private  class DataItemsSelfRealization
    {
        private List<SelfRealizationTarget> targets = new  ArrayList<>();

        List<SelfRealizationTarget> getTargets(){return targets;}

        void setTargets(List<SelfRealizationTarget> targets)
        {
            this.targets = targets;
        }
    }
    private  class DataItemsHobby
    {
        private List<HobbyTarget> targets = new  ArrayList<>();

        List<HobbyTarget> getTargets(){return targets;}

        void setTargets(List<HobbyTarget> targets)
        {
            this.targets = targets;
        }
    }
    private  class DataItemsPersonalLife
    {
        private List<PersonalLifeTarget> targets = new  ArrayList<>();

        List<PersonalLifeTarget> getTargets(){return targets;}

        void setTargets(List<PersonalLifeTarget> targets)
        {
            this.targets = targets;
        }
    }
}

