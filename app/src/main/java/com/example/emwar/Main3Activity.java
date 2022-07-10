package com.example.emwar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mypack.Box;
import mypack.key;
import mypack.letter;
import mypack.mathmatic;

public class Main3Activity extends AppCompatActivity {

    EditText medit;
    private TextView textView;
    private  String str;
    Main3Activity main3Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       main3Activity=new Main3Activity();
       MainActivity.scenariohistory.add(main3Activity);


    }

    public void onokclick(View view){
        medit=(EditText)(findViewById(R.id.editText3));
        String stranswer=medit.getText().toString();
        letter ltr=new letter(Main2Activity.main);
        Box bx=new Box(Main2Activity.main);

        try {

            if (!isappropriatestring(stranswer))
                throw new mypack.WrongInputPassException();
            else {
                if (stranswer.equals("letter")) {
                    str = ltr.Showletter();
                    Intent intent = new Intent(this, Main4Activity.class);
                    finish();
                    startActivity(intent);
                }

                if (stranswer.equals("key")) {
                    Main2Activity.ky.setkey(Main2Activity.ky.getkey() + 1);
                    str = "ok you gained one key";
                    Intent intent = new Intent(this, Main4Activity.class);
                    finish();
                    startActivity(intent);
                }

                if (stranswer.equals("box")) {
                    if (Main2Activity.ky.getkey() > 0) {
                        str = bx.ShowDigit();
                        Main2Activity.ky.setkey(Main2Activity.ky.getkey() - 1);
                        Intent intent = new Intent(this, Main4Activity.class);
                        finish();
                        startActivity(intent);
                    } else {
                        str = "Not enough keys";
                    }
                }

                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        }
        catch (mypack.WrongInputPassException e){
            Toast.makeText(getApplicationContext(), "inappropriateinput", Toast.LENGTH_LONG).show();
        }

    }

    public void onnexthallclick(View view){
        Intent intent=new Intent(this,Main4Activity.class);
        finish();
        startActivity(intent);

    }

    public boolean isappropriatestring(String str){
        return (str.equals("letter")||str.equals("box")||str.equals("key"));
    }
}
