package com.redButton;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Objects;
public class AhmActivity extends AppCompatActivity {
   private SensorManager mSensorManager;
   private float mAccel;
   private float mAccelCurrent;
   private float mAccelLast;
   private TextView textview1;
   private Intent go = new Intent();
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.ahm);
      mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
      Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
      SensorManager.SENSOR_DELAY_NORMAL);
      mAccel = 10f;
      mAccelCurrent = SensorManager.GRAVITY_EARTH;
      mAccelLast = SensorManager.GRAVITY_EARTH;
   }
   private final SensorEventListener mSensorListener = new SensorEventListener() {
      @Override
      public void onSensorChanged(SensorEvent event) {
         float x = event.values[0];
         float y = event.values[1];
         float z = event.values[2];
         mAccelLast = mAccelCurrent;
         mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
         float delta = mAccelCurrent - mAccelLast;
         mAccel = mAccel * 0.2f + delta;
         if (mAccel > 20) {
            go.setClass(getApplicationContext(), NotgoodActivity.class);
				startActivity(go);
         }
      }
      
      @Override
      public void onAccuracyChanged(Sensor sensor, int accuracy) {
      }
   };
   @Override
   protected void onResume() {
      mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
      SensorManager.SENSOR_DELAY_NORMAL);
      super.onResume();
   }
   @Override
   protected void onPause() {
      mSensorManager.unregisterListener(mSensorListener);
      super.onPause();
   }
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
	}
}