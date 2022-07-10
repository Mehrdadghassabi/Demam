package com.example.emwar;

import android.support.annotation.NonNull;

public class Score implements Comparable<Score> {
    int Score;
    String name;
    Score(String name,int Score){
        this.name=name;
        this.Score=Score;
    }

    @Override
    public int compareTo(@NonNull com.example.emwar.Score o) {
       return this.Score-o.Score;
    }
}
