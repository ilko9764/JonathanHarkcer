package com.example.jonathanharkcer;

import java.util.ArrayList;
import java.util.List;

public class HobbyTarget {

    private String name;
    private String enjoy;
    private String forWhomDoingThis;
    private String reasonForWanting;;
    private String inspiration;
    private String whatISeeResalt;
    private String whatDoingResalt;
    private String whatMaterialsINeed;
    private String dressCod;
    private String whatInformationINeed;
    private String whatItTakeTime;
    private String whatItTakeMoney;
    private String whatItDiffculty;
    private String nameParents;
    private List<RealActionTar> realActionList;

    public HobbyTarget(){
        name = null;
        enjoy = null;
        forWhomDoingThis = null;
        reasonForWanting = null;
        inspiration = null;
        whatISeeResalt = null;
        whatDoingResalt = null;
        whatMaterialsINeed = null;
        dressCod = null;
        whatInformationINeed = null;;
        whatItTakeTime = null;
        whatItTakeMoney = null;
        whatItDiffculty = null;
        nameParents = null;
        realActionList = new ArrayList<>();
    }


    public String getName()
    {
        return name;
    }
    public void setName(String str)
    {
        name = str;
    }

    public String getEnjoy()
    {
        return enjoy;
    }
    public void setEnjoy(String str)
    {
        enjoy = str;
    }

    public String getForWhomDoingThis()
    {
        return forWhomDoingThis;
    }
    public void setForWhomDoingThis(String str)
    {
        forWhomDoingThis = str;
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

    public String getWhatItTakeTime()
    {
        return whatItTakeTime;
    }
    public void setWhatItTakeTime(String str)
    {
        whatItTakeTime = str;
    }
    //6

    public String getWhatItTakeMoney()
    {
        return whatItTakeMoney;
    }
    public void setWhatItTakeMoney(String str)
    {
        whatItTakeMoney = str;
    }

    public String getWhatItDiffculty()
    {
        return whatItDiffculty;
    }
    public void setWhatItDiffculty(String str)
    {
        whatItDiffculty = str;
    }

    public String getDressCod()
    {
        return dressCod;
    }
    public void setDressCod(String str)
    {
        dressCod = str;
    }

    public String getWhatInformationINeed()
    {
        return whatInformationINeed;
    }
    public void setWhatInformationINeed(String str)
    {
        whatInformationINeed = str;
    }

    public String getWhatISeeResalt()
    {
        return whatISeeResalt;
    }
    public void setWhatISeeResalt(String str)
    {
        whatISeeResalt = str;
    }

    //11
    public String getWhatDoingResalt()
    {
        return whatDoingResalt;
    }
    public void setWhatDoingResalt(String str)
    {
        whatDoingResalt = str;
    }

    public String getWhatMaterialsINeed()
    {
        return whatMaterialsINeed;
    }
    public void setWhatMaterialsINeed(String str)
    {
        whatMaterialsINeed = str;
    }

    public String getNameParents()
    {
        return nameParents;
    }
    public void setNameParents(String str)
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
