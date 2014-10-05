package com.example.bluedrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
	
	ListView scrapList;
	IconTextListAdapter_profile adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		
		//타이틀 액션바 숨김
		ActionBar abar = getActionBar();
		abar.hide();
		
		ListView scrapList = (ListView) findViewById(R.id.scrapList);
		
		adapter = new IconTextListAdapter_profile(this);
		
		Resources res = getResources();
		adapter.addItem(new IconTextItem_profile(res.getDrawable(R.drawable.study),"자기계발","중국어 HSK 스터디"," "));
		adapter.addItem(new IconTextItem_profile(res.getDrawable(R.drawable.it),"공모전,IT","한이음 IT공모전"," "));
		adapter.addItem(new IconTextItem_profile(res.getDrawable(R.drawable.movie),"UCC,영상","땅땅치킨 UCC공모전"," "));
		adapter.addItem(new IconTextItem_profile(res.getDrawable(R.drawable.study),"자기계발,외국어","토익 700점"," "));
		
		scrapList.setAdapter(adapter);
		
		scrapList.setOnItemClickListener(new OnItemClickListener(){
			
		@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				IconTextItem_profile curItem = (IconTextItem_profile) adapter.getItem(position);
				String[] curData = curItem.getData();
				Toast.makeText(getApplicationContext(), "Selectd : "+ curData[0], 2000).show();
			}
		});
		
		
		
	}


}
