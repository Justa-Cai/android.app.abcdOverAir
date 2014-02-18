package com.gss.abcdoverair;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BluetoothActivity extends Activity implements OnClickListener {

	final utils mUtils = utils.GetInstance();
	final String mProcotolMark = "~";
	BluetoothAdapter mBluetoothAdapter ;
	String mProcotolContent = "ABCDABCDABCDABCDABCD";
	
	Button btnExit;
	TextView tvInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth);
		tvInfo = (TextView)findViewById(R.id.tvShareInfo);
		btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnClickListener(this);
		
		tvInfo.setText("ÕýÔÚ·ÖÏí");
	
		 mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (!mBluetoothAdapter.isEnabled())
			mBluetoothAdapter.enable();
		
		Intent intent = getIntent();
		if (intent!=null)
		{
			String content = intent.getStringExtra("content");
			if (content!=null && content.length()>0)
				mProcotolContent = content;
		}
		
		String name;
		name = mProcotolMark + mProcotolContent + mProcotolMark;
		mBluetoothAdapter.setName(name);
		
		mUtils.Logx(name);
		mUtils.Logx("len:" + name.length());
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	@Override
	protected void onPause() {
	//	if (mBluetoothAdapter!=null)
	//	mBluetoothAdapter
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnExit)
		{
			//mBluetoothAdapter.disable();
			this.finish();
		}
	}
}
