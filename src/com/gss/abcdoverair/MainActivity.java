package com.gss.abcdoverair;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button m_btnServer, m_btnClient;
	private utils mUtils = utils.GetInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		m_btnServer = (Button) findViewById(R.id.btnServer);
		m_btnClient = (Button) findViewById(R.id.btnClient);

		m_btnServer.setOnClickListener(this);
		m_btnClient.setOnClickListener(this);
	
		mUtils.Init(this);
		
		//startActivity(new Intent(this, ListViewLoader.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnServer:
			startActivity(new Intent(this, ServerListActivity.class));
			break;

		case R.id.btnClient:
			startActivity(new Intent(this, ClientListActivity.class));
			break;
		}

	}

}
