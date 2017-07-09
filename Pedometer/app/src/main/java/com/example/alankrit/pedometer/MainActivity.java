package com.example.alankrit.pedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView= (TextView) findViewById(R.id.textView);

        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor s=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(steps==0){
                    steps=event.values[0];
                }

                Log.d("TAG", "onSensorChanged: "+(event.values[0]-steps));

                textView.setText(""+(event.values[0]-steps));

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },s,10000);
    }
}
