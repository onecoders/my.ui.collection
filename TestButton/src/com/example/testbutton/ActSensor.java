package com.example.testbutton;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.widget.Toast;

public class ActSensor extends Activity {

	private SensorManager sensorManager;
	private Vibrator vibrator;

	private static final int SENSOR_SHAKE = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (sensorManager != null) {
			sensorManager.registerListener(sensorEventListener,
					sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
					SensorManager.SENSOR_DELAY_NORMAL);

		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (sensorManager != null) {
			sensorManager.unregisterListener(sensorEventListener);
		}
	}

	private SensorEventListener sensorEventListener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			float[] values = event.values;
			float x = values[0];
			float y = values[1];
			float z = values[2];

			int medumValue = 19;
			if (Math.abs(x) > medumValue || Math.abs(y) > medumValue
					|| Math.abs(z) > medumValue) {
				vibrator.vibrate(500);
				Message msg = new Message();
				msg.what = SENSOR_SHAKE;
				handler.sendMessage(msg);
			}
		}

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {

		}
	};

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case SENSOR_SHAKE:
				Toast.makeText(ActSensor.this, "检测到摇晃，执行操作！",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};

}
