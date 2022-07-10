package com.example.emwar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

public  class timetask extends AsyncTask<TextView,TextView , TextView> {
    private static int timeleft=180000;
    private  String mtn;
    private boolean ayabakhte=false;
    private TextView text;
    private Activity act;
    private Context con;

    timetask(Context con,Activity act){
        this.con=con;
        this.act=act;
    }

    @Override
    protected TextView doInBackground(TextView... textViews) {

        this.text = textViews[0];
        while (timeleft>0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeleft-=10;
            mtn = timeleft(timeleft);
            publishProgress(text);
        }
        {
            this.con.startActivity(new Intent(this.con, Main7Activity.class));
            act.finish();
        }
        return this.text;
    }

    @Override
    protected void onProgressUpdate(TextView... values) {
        super.onProgressUpdate(values);
        values[0].setText(this.mtn);
    }

    @Override
    protected void onPostExecute(TextView s) {
        super.onPostExecute(s);

    }

    protected String timeleft(final int tl){
        class time{
            int t=tl/10;
            int min=t/6000;
            int sec=(t-6000*min)/100;
            int persec=t-6000*min-100*sec;

        }
        time time=new time();
        if(time.sec<10)
        return time.min+":"+"0"+time.sec+":"+time.persec;
        else
            return time.min+":"+time.sec+":"+time.persec;
    }

    public String getMtn(){
        return mtn;
    }
}
