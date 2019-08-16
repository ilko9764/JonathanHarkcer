package com.jonathanharkcer;

import java.util.ArrayList;
import java.util.List;

class SelfRealizationTarget {
    private String name;
    private String whatFor;
    private String reward;
    private String forWhomIDoingThis;
    private String reasonForWanting;
    private String inspiration;
    private String influence;
    private String thereAfter;
    private String nameParents;

    private List<RealActionTar> realActionList;

    public SelfRealizationTarget(){
        name = null;
        whatFor = null;
        reward = null;
        forWhomIDoingThis = null;
        reasonForWanting = null;
        inspiration = null;
        influence = null;
        thereAfter = null;
        nameParents = null;
        realActionList = new  ArrayList<>();
    }


    public String getName()
    {
        return name;
    }
    public void setName(String str)
    {
        name = str;
    }

    public String getWhatFor()
    {
        return whatFor;
    }
    public void setWhatFor(String str)
    {
        whatFor = str;
    }

    public String getReward()
    {
        return reward;
    }
    public void setReward(String str)
    {
        reward = str;
    }

    public String getForWhomIDoingThis()
    {
        return forWhomIDoingThis;
    }
    public void setForWhomIDoingThis(String str)
    {
        forWhomIDoingThis = str;
    }

    public String getReasonForWanting()
    {
        return reasonForWanting;
    }
    public void setReasonForWanting(String str)
    {
        reasonForWanting = str;
    }

    public String getInspiration()
    {
        return inspiration;
    }
    public void setInspiration(String str)
    {
        inspiration = str;
    }

    public String getInfluence()
    {
        return influence;
    }
    public void setInfluence(String str)
    {
        influence = str;
    }

    public String getThereAfter()
    {
        return thereAfter;
    }
    public void setThereAfter(String str)
    {
        thereAfter = str;
    }

    public String getNameParens()
    {
        return nameParents;
    }
    public void setNameParens(String str)
    {
        nameParents = str;
    }

    public void setRealActionList(List<RealActionTar> rarList){
        for(RealActionTar real: rarList)
            realActionList.add(real);
    }
    public void getRealActionList(ArrayList<RealActionTar> rarList){
        for(RealActionTar real: realActionList)
            rarList.add(real);
    }
    public void addRealAction(RealActionTar rar){
        realActionList.add(rar);
    }
    public RealActionTar getRealAction(int i)
    {
        return realActionList.get(i);
    }
    public int getRealActionSize()
    {
        return realActionList.size();
    }


}
