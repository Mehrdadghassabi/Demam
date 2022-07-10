package com.example.emwar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

EditText editText;
TextView textView;
public static String name;
public static Scenariohistory<AppCompatActivity> scenariohistory;
MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)(findViewById(R.id.editText));
        textView=findViewById(R.id.textView10);
        mainActivity=new MainActivity();
        scenariohistory=new Scenariohistory(mainActivity);

       File a= new File("/storage/emulated/0/Android/data/com.example.emwar/files/emwar.txt");
        try {
            FileReader fr=new FileReader(a);
            StringBuffer s=new StringBuffer("");
            int hold;
            while((hold=fr.read())!=-1){
                s.append((char)hold);
            }
            textView.setText(s.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);





    }
    public void click(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        finish();
        startActivity(intent);


        name=editText.getText().toString();


        File file = new File("/storage/emulated/0/Android/data/com.example.emwar/files/emwar.txt");
        try {
            FileWriter fr = new FileWriter(file,false);
                fr.write("sfasg");

            fr.flush();
            fr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}