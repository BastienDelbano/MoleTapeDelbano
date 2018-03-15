package org.diiage.delbano.moletapdelbano;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private static Timer timer = new Timer("timer");
    private static int chrono = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        List<ImageButton> moles = new ArrayList<>();
        ImageButton mole1 = findViewById(R.id.mole1);
        ImageButton mole2 = findViewById(R.id.mole2);
        ImageButton mole3 = findViewById(R.id.mole3);
        ImageButton mole4 = findViewById(R.id.mole4);
        ImageButton mole5 = findViewById(R.id.mole5);
        ImageButton mole6 = findViewById(R.id.mole6);
        ImageButton mole7 = findViewById(R.id.mole7);
        ImageButton mole8 = findViewById(R.id.mole8);
        ImageButton mole9 = findViewById(R.id.mole9);
        moles.add(mole1);
        moles.add(mole2);
        moles.add(mole3);
        moles.add(mole4);
        moles.add(mole5);
        moles.add(mole6);
        moles.add(mole7);
        moles.add(mole8);
        moles.add(mole9);

        Intent intent = getIntent();
        //on recup les info de la session
        Session session = getIntent().getExtras().getParcelable(MainActivity.SESSION);

        startTimer();

        //retire toutes les taupes
        for (ImageButton item : moles){
            item.setImageDrawable(null);
        }

        /*while (chrono >= 0){
            final ImageButton mole = anyItem(moles);
            mole.setImageResource(R.drawable.lilmole);
            mole.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mole.setImageDrawable(null);
                }
            });
        }*/

    }

    private  int randomTime(int min, int max){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt((max - min)+1) + min;
    }

    private ImageButton anyItem(List<ImageButton> list)
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(list.size());
        ImageButton item = list.get(index);
        return item;
    }

    private void startTimer() {
        boolean isTimerRunning = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                chrono -= 1; //increase every sec
                mHandler.obtainMessage(1).sendToTarget();
            }
        }, 0, 1000);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            TextView txtChrono = findViewById(R.id.txtChrono);
            txtChrono.setText(String.valueOf(chrono));
        }
    };
}
