package com.example.bluedrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Gong_Pizza extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gong__pizza);
		
		ActionBar abar = getActionBar();
		abar.hide();
		
		Button zzim = (Button)findViewById(R.id.button1);
		zzim.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(Gong_Pizza.this,"공유 합니다.",Toast.LENGTH_LONG).show();	
			}
		});
		Button gong = (Button)findViewById(R.id.button2);
		gong.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(Gong_Pizza.this,"찜 하였습니다!",Toast.LENGTH_LONG).show();	
			}
		});
		Button back = (Button)findViewById(R.id.button3);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				finish();
			}
		});
				
	}

}
