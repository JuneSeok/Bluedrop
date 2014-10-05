package com.example.bluedrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out);
		
		//액션바 숨김
		ActionBar abar = getActionBar();
		abar.hide();
		
		
		//상단 버튼 4개 동작
				Button gongBtn = (Button)findViewById(R.id.btn_gong);	//
				Button bongBtn = (Button)findViewById(R.id.btn_bong);		//
				Button surBtn = (Button)findViewById(R.id.btn_sur);		//
				Button dongBtn = (Button)findViewById(R.id.btn_dong);		//
				Button stdBtn = (Button)findViewById(R.id.btn_study);
				Button etcBtn = (Button)findViewById(R.id.btn_etc);
				
				gongBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToActivity = new Intent(getApplicationContext(),GongActivity.class);
						startActivity(moveToActivity);
					}
				});
				
				bongBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToFollow = new Intent(getApplicationContext(),VolunteerActivity.class);
						startActivity(moveToFollow);
					}
				});
				
				surBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToProfile = new Intent(getApplicationContext(),SupportActivity.class);
						startActivity(moveToProfile);
					}
				});
				
				dongBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToSetting = new Intent(getApplicationContext(),DongActivity.class);
						startActivity(moveToSetting);
					}
				});
				
				stdBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToSetting = new Intent(getApplicationContext(),StudyActivity.class);
						startActivity(moveToSetting);
					}
				});
				
				etcBtn.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						Intent moveToSetting = new Intent(getApplicationContext(),ElseActivity.class);
						startActivity(moveToSetting);
					}
				});
		
	}

	}
