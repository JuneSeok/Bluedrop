package com.example.bluedrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class StudyActivity extends Activity {
	ListView volunteerList;
	IconTextListAdapter adapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study);
		
		ActionBar abar = getActionBar();
		abar.hide();
		
		ListView listView1 =(ListView) findViewById(R.id.studyList);
		
		adapter = new IconTextListAdapter(this);
		
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"영어스터디","목표 토익 750","영어","20140924","20140929","4일"));

		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();
				Toast.makeText(getApplicationContext(), "Selectd : "+ curData[0], 2000).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
