package com.example.testbutton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView phoneId;
	private TextView fromAssets;
	private Button shake;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		phoneId = (TextView) findViewById(R.id.phoneId);
		fromAssets = (TextView) findViewById(R.id.fromAssets);
		shake = (Button) findViewById(R.id.shake);

		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		phoneId.setText(tm.getDeviceId());

		Properties pro = new Properties();
		InputStream is;
		try {
			is = this.getAssets().open("bruts.properties");
			pro.load(is);
			String businessid = (String) pro.get("bussesid");
			String APKID = (String) pro.get("apkId");
			Boolean login = Boolean.valueOf(pro.get("login").toString());
			Boolean register = Boolean.valueOf(pro.get("register").toString());
			String[] modelnames = pro.get("ModuleNames").toString().split(",");
			String[] modelids = pro.get("ModuleIdsIds").toString().split(",");
			is.close();
			fromAssets.setText(businessid + "/n" + APKID + "/n" + login + "/n"
					+ register + "/n" + modelnames.toString() + "/n"
					+ modelids.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		shake.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		startActivity(new Intent(this, ActSensor.class));
	}

}
