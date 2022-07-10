package com.example.emwar;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Scenariohistory<T extends AppCompatActivity> {
    private ArrayList<T> history;
    private T sen;

    Scenariohistory(T t){

        history=new ArrayList<T>();
        history.add(t);
        this.sen=t;
    }

    public void add(T s){

        history.add(s);
        this.sen=s;
    }

    public T undo(){

        return this.sen;
    }

}
