package com.example.hali.braingame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Q1 extends AppCompatActivity {

    TextView clk ;
    TextView quesnum;
    TextView ques;
    TextView result;
    TextView answer;                                        //ANSWERS FOR DEVELOPER !!
    static int quesnumber = 1;
    static  int score = 0;
    Button b1,b2,b3,b4,retry;
    int c;

    public void run ()
    {
        generateques();

        new CountDownTimer(30000+100,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                clk.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                showresults();
            }
        }.start();
    }

    public void retry (View view)
    {
        quesnumber = 1;
        score = 0;
        Intent q1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(q1);

    }

    public void question (View view) {
            int tag;
            tag = Integer.parseInt(view.getTag().toString());
            if (tag == c ) {
                score++;
                generateques();
            } else
                generateques();
    }

    public void generateques()
    {
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        quesnum.setText("Question No. "+String.valueOf(quesnumber));
        ques.setText(String.valueOf(a)+" + "+String.valueOf(b));
        c = rand.nextInt(4)+1;
        if (c==1)
        {
            b1.setText(String.valueOf(a+b));
            b2.setText(String.valueOf(rand.nextInt(200)));
            b3.setText(String.valueOf(rand.nextInt(200)));
            b4.setText(String.valueOf(rand.nextInt(200)));
        }
        else if (c==2)
        {
            b1.setText(String.valueOf(rand.nextInt(200)));
            b2.setText(String.valueOf(a+b));
            b3.setText(String.valueOf(rand.nextInt(200)));
            b4.setText(String.valueOf(rand.nextInt(200)));
        }
        else if (c==3)
        {
            b1.setText(String.valueOf(rand.nextInt(200)));
            b2.setText(String.valueOf(rand.nextInt(200)));
            b3.setText(String.valueOf(a+b));
            b4.setText(String.valueOf(rand.nextInt(200)));
        }
        else if (c==4)
        {
            b1.setText(String.valueOf(rand.nextInt(200)));
            b2.setText(String.valueOf(rand.nextInt(200)));
            b3.setText(String.valueOf(rand.nextInt(200)));
            b4.setText(String.valueOf(a+b));
        }
        quesnumber++;
    }

    public void showresults()
    {
        result.setText("Your Score is "+String.valueOf(score)+" out of "+String.valueOf(--quesnumber));
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        clk.setVisibility(View.INVISIBLE);
        ques.setVisibility(View.INVISIBLE);
        quesnum.setVisibility(View.INVISIBLE);
        result.setVisibility(View.VISIBLE);
        retry.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        clk = (TextView)findViewById(R.id.timer);
        quesnum = (TextView)findViewById(R.id.quesnumber);
        ques = (TextView)findViewById(R.id.ques);
        result = (TextView)  findViewById(R.id.result);
        answer = (TextView)  findViewById(R.id.ans);
        b1 = (Button)findViewById(R.id.a1);
        b2 = (Button)findViewById(R.id.a2);
        b3 = (Button)findViewById(R.id.a3);
        b4 = (Button)findViewById(R.id.a4);
        retry = (Button)findViewById(R.id.retry);

        retry.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        run();

    }
}
