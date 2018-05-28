package college;


import java.util.*;

public class Subject{

    private String mName;
    private int mCode;
    private int mChapterCount;

    public Subject(){
        this("English", 1, 10);
    }

    public Subject(String x,int y,int z){
        mName=x;
        mCode=y;
        mChapterCount=z;
    }

    public String toString(){
     return "Name:"+mName+"\tCode:"+mCode+"\tChapter Count:"+mChapterCount;
    }
}
