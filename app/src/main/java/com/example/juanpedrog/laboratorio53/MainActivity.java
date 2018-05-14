package com.example.juanpedrog.laboratorio53;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements android.hardware.SensorEventListener{

    private android.hardware.Sensor mysensor;
    private android.hardware.SensorManager senman;
    android.widget.TextView ejex,ejey,ejez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        senman = (android.hardware.SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor=senman.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE);
        ejex = (android.widget.TextView) findViewById(R.id.ejex);
        ejey = (android.widget.TextView) findViewById(R.id.ejey);
        ejez = (android.widget.TextView) findViewById(R.id.ejez);
        senman.registerListener(this,mysensor,android.hardware.SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(android.hardware.SensorEvent event) {
        ejex.setText("X:"+event.values[0]);
        ejey.setText("Y:"+event.values[1]);
        ejez.setText("Z:"+event.values[2]);
    }
    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {
    // Hacer nada
    }
}
