package com.gss.abcdoverair;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ClientListActivity extends Activity {
	BluetoothAdapter mBluetoothAdapter;
	
	TextView tvInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_client);
		tvInfo = (TextView)findViewById(R.id.tvInfo);
		tvInfo.setText("ÕýÔÚËÑË÷...");
	
		 mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (!mBluetoothAdapter.isEnabled())
			mBluetoothAdapter.enable();
	}
	
}
