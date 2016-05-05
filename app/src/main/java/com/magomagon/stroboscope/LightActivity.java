package com.magomagon.stroboscope;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class LightActivity extends AppCompatActivity {

    private RelativeLayout lightView;
    private boolean darkState = true;
    Handler lightHandler = new Handler();

    Runnable periodicChange = new Runnable() {
        public void run() {
            if(darkState){
                lightView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
            } else {
                lightView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
            }
            darkState = !darkState;
            lightHandler.postDelayed(periodicChange, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        lightView = (RelativeLayout) findViewById(R.id.light_view);
        lightHandler.post(periodicChange);
    }
}
