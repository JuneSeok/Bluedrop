package com.example.bluedrop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 타이틀바 없애기
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.splash);

		Handler handler = new Handler();
		handler.postDelayed(new splashHandler(), 4000);
	}

	class splashHandler implements Runnable {

		@Override
		public void run() {
			Intent it = new Intent(Intro.this, MainActivity.class);
			startActivity(it);
			finish();

			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}