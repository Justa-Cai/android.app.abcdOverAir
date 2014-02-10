package com.gss.abcdoverair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;

public class ServerListActivity extends ListActivity implements OnClickListener, ViewBinder {

	List<Map<String, Object>> listItems;
	ListView mListView;
	Button mButton;
	SimpleAdapterEx mSimpleAdapter;
	utils mUtils =utils.GetInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_server);

		listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 30; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("tick", String.format("%d", i + 1));
			listItem.put("A", false);
			listItem.put("B", false);
			listItem.put("C", false);
			listItem.put("D", false);
			listItem.put("E", false);
			listItem.put("F", false);
			listItems.add(listItem);
		}

		mSimpleAdapter = new SimpleAdapterEx(this, listItems,
				R.layout.listview_item, 
				new String[] { "tick", "A", "B", "C", "D", "E", "F"},
				new int[] { R.id.tvTick , R.id.checkBoxA,
				R.id.checkBoxB,
				R.id.checkBoxC,
				R.id.checkBoxD,
				R.id.checkBoxE,
				R.id.checkBoxF
				});
	
		//mSimpleAdapter.setViewBinder(this);
		setListAdapter(mSimpleAdapter);
		
		mListView = getListView();
		
		mButton = (Button)findViewById(R.id.btnShare);
		mButton.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.btnShare:
			for (int i=0; i<listItems.size(); i++)
			{
				Map<String, Object> listItem = listItems.get(i);
				Boolean bV = (Boolean) listItem.get("A");
				if (bV== true)
				{
					new AlertDialog.Builder(this)
					.setTitle("Message Title")
					.setMessage("XXX")
					.create().show();
				}
			}
			break;
		}
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mUtils.Logx("position:" + position + " id:" + id);
	}
	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mUtils.Logx("onContentChanged");
	}

	@Override
	public boolean setViewValue(View view, Object data,
			String textRepresentation) {
		if (view instanceof Checkable)
		{
			Checkable checkable = (Checkable) view;
			return true;
		}
		return false;
	}
	
}
