package com.example.bluedrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class GongActivity extends Activity {
	ListView listView1;
	IconTextListAdapter adapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gong);
		
		ActionBar abar = getActionBar();
		abar.hide();
		
		ListView listView1 =(ListView) findViewById(R.id.listView1);
		
		adapter = new IconTextListAdapter(this);
		
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.haniem),"IT,공학","한이음 공모대전","미래창조과학부 | NIPA","9.12","9.30","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.moon),"글쓰기","문화가 있는 날","문화체육관광부","9.15","10.13","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.han),"글쓰기","대한민국 한식사진 공모전","농림축산식품부 | 한식재단","8.1","9.30","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.cool),"푸드","쿨부산 청춘 포스팅 대회","부산시청 |미디어센터","9.26","10.20","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.mrpizza),"푸드","제 8회 그녀들만의 피자 콘테스트","Mr.Pizza","9.22","10.12","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.asan),"영상,UCC","제 1회 아산 광고대첩 광고제","아산시청","9.15","10.13","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.chang),"IT,공학","창의 IT융합 미래기술 아이디어 공모","미래창조과학부 | 기술진흥센터","10.10","10.30","2014"));
		
		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				
				Intent intent1 = new Intent(GongActivity.this, Gong_Pizza.class);
				 
		         startActivity(intent1);
		         
				//IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				//String[] curData = curItem.getData();
				//Toast.makeText(getApplicationContext(), "Selectd : "+ curData[0], 2000).show();
			}
		});
	}
}
