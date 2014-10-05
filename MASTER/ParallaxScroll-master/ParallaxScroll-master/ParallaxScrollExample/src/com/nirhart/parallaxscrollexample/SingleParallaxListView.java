package com.nirhart.parallaxscrollexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.nirhart.parallaxscroll.views.ParallaxListView;

public class SingleParallaxListView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_one_parallax);
		
		ParallaxListView listView = (ParallaxListView) findViewById(R.id.list_view);
		CustomListAdapter adapter = new CustomListAdapter(LayoutInflater.from(this));
		
		TextView v = new TextView(this);
		v.setText("머머머머야");
		v.setGravity(Gravity.CENTER);
		v.setTextSize(40);
		v.setHeight(500);
		v.setBackgroundResource(R.drawable.item_background);
		
		listView.addParallaxedHeaderView(v);
		listView.setAdapter(adapter);
	}


}
