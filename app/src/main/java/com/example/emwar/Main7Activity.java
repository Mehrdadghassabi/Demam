package com.example.emwar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import mypack.WrongInputPassException;

public class Main7Activity extends AppCompatActivity {

    EditText medit;
    private String str;
    private int counter;
    private int score=0;
    TextView textView;
    Main7Activity main7Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        textView=findViewById(R.id.textView6);
        //main7Activity=new Main7Activity();
        //MainActivity.scenariohistory.add(main7Activity);

      countingscore();

      ScoreManeger scoreManeger=new ScoreManeger(MainActivity.name,score);
        File file = new File("/storage/emulated/0/Android/data/com.example.emwar/files/emwar.txt");
      textView.setText(String.valueOf(file.length()));
    }

    public void onclick(View view) {
        medit = (EditText) (findViewById(R.id.editText3));
        String stranswer = medit.getText().toString();
        String password=Integer.toString(Main2Activity.main.getPassword());

        try {
            if (!Stringisappropriate(stranswer))
                throw new WrongInputPassException();
            else {

                if (stranswer.equals(password)) {
                    str = "YOU WIN!!";
                    this.score +=500;
                }
                else {
                    str = "YOU LOSE!!";
                }

                counter++;
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                counter++;
                if (counter >= 3) {
                    try {
                        Thread.sleep(30);
                        Intent svc=new Intent(this, BackgroundSoundService.class);
                        getApplicationContext().stopService(svc);
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                        finishAffinity();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (WrongInputPassException e){
            Toast.makeText(getApplicationContext(), "inappropriateinput", Toast.LENGTH_LONG).show();
        }



    }

    private boolean Stringisappropriate(String str){
        if(isnum(str)){
            return (str.length()<4 && str.length()>0);
        }
        else
            return false;
    }

    private  boolean isnum(String str){
        int len=str.length();
        boolean flag=true;
        for(int i=0;i<len;i++){
            if(!Character.isDigit(str.charAt(i)))
                flag=false;
        }
        return flag;
    }

    private void countingscore(){
        this.score+=100*(5-Main2Activity.ky.getkey());
    }
}
