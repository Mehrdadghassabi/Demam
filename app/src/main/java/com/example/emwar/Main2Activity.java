package com.example.emwar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import mypack.*;

public class Main2Activity extends AppCompatActivity {
    EditText medit;
    private  String str;
    static   key ky=new key();
    static  String time;
    static mathmatic main=new mathmatic();
    private TextView text;
    Main2Activity main2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text=(TextView)(findViewById(R.id.textView7));
        new timetask(this,this).execute(text);
    }

    public void onokclick(View view){
        medit=(EditText)(findViewById(R.id.editText3));
        String stranswer=medit.getText().toString();
        letter ltr=new letter(Main2Activity.main);
        Box bx=new Box(Main2Activity.main);
        time=text.getText().toString();
        main2Activity=new Main2Activity();
        MainActivity.scenariohistory.add(main2Activity);


        try {
            if (!isappropriatestring(stranswer))
                throw new mypack.WrongInputPassException();
            else {
                if (stranswer.equals("letter")) {
                    str = ltr.Showletter();
                    Intent intent = new Intent(this, Main3Activity.class);
                    finish();
                    startActivity(intent);
                }

                if (stranswer.equals("key")) {
                    ky.setkey(ky.getkey() + 1);
                    str = "ok you gained one key";
                    Intent intent = new Intent(this, Main3Activity.class);
                    finish();
                    startActivity(intent);
                }

                if (stranswer.equals("box")) {
                    str = "Not enough keys";
                }

                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        }
        catch (mypack.WrongInputPassException e){
            Toast.makeText(getApplicationContext(), "inappropriateinput", Toast.LENGTH_LONG).show();
        }
    }

    public void onnexthallclick(View view){
        Intent intent=new Intent(this,Main3Activity.class);
        finish();
        startActivity(intent);

        time=text.getText().toString();
    }

    public boolean isappropriatestring(String str){
        return (str.equals("letter")||str.equals("box")||str.equals("key"));
    }

}
