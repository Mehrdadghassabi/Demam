package com.example.emwar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreManeger {
    ArrayList<Score> scoreManegers;

    ScoreManeger(String str,int num){

        scoreManegers=new ArrayList<Score>();
        Score score=new Score(str,num);
        scoreManegers.add(score);

        writtinginFile();
        ArrayListsort();
    }

    ScoreManeger(Score score){
        scoreManegers=new ArrayList<Score>();
        scoreManegers.add(score);

        writtinginFile();
        ArrayListsort();
    }

    public void addScore(Score score){

        scoreManegers.add(score);

        writtinginFile();
        ArrayListsort();
    }

    public void addScore(String name,int Score){
        Score score=new Score(name,Score);
        scoreManegers.add(score);

        writtinginFile();
        ArrayListsort();
    }

    private void writtinginFile(){
        File file = new File("/storage/emulated/0/Android/data/com.example.emwar/files/emwar.txt");

        try {
            FileWriter fr = new FileWriter(file,true);
            for(Score score:scoreManegers)
                fr.write("name: "+score.name+"score: "+score.Score+"\n");

            fr.flush();
            fr.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

   private void ArrayListsort(){

        Collections.sort(scoreManegers);
   }

}
