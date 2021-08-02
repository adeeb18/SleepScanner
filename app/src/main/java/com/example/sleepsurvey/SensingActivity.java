package com.example.sleepsurvey;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.widget.TextView;

public class SensingActivity extends AppCompatActivity implements SensorEventListener {

    TextView lumenValues;
    TextView tempValues;

    SensorManager sensorManager;
    Sensor lightSensor;
    Sensor tempSensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensing);

        lumenValues = (TextView) findViewById(R.id.lumenValues);
        tempValues = (TextView) findViewById(R.id.tempValues);

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            lumenValues.setText("Light Value: " + event.values[0]);
        }
        if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            tempValues.setText("Temp Value" + event.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}