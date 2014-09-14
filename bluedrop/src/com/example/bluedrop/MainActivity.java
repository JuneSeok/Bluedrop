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

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Ÿ��Ʋ �׼ǹ� ����
		ActionBar abar = getActionBar();
		abar.hide();
		
		//��� ��ư 4�� ����
		Button ActivityBtn = (Button)findViewById(R.id.btn_activity);	//���Ȱ��
		Button FollowBtn = (Button)findViewById(R.id.btn_follow);		//�ȷο�
		Button ProfileBtn = (Button)findViewById(R.id.btn_profile);		//������
		Button SettingBtn = (Button)findViewById(R.id.btn_setting);		//����
		
		ActivityBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent moveToActivity = new Intent(getApplicationContext(),OutActivity.class);
				startActivity(moveToActivity);
			}
		});
		
		FollowBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent moveToFollow = new Intent(getApplicationContext(),FollowActivity.class);
				startActivity(moveToFollow);
			}
		});
		
		ProfileBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent moveToProfile = new Intent(getApplicationContext(),ProfileActivity.class);
				startActivity(moveToProfile);
			}
		});
		
		SettingBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent moveToSetting = new Intent(getApplicationContext(),SettingsActivity.class);
				startActivity(moveToSetting);
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
