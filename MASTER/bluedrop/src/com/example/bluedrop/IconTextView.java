package com.example.bluedrop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconTextView extends LinearLayout {
	private ImageView mIcon;
	private TextView mText01;
	private TextView mText02;
	private TextView mText03;
	private TextView mText04;
	private TextView mText05;
	private TextView myear2014;
	public IconTextView(Context context, IconTextItem aItem) {
		super(context);
		
	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	inflater.inflate(R.layout.listitem,this,true);
	
	mIcon = (ImageView) findViewById(R.id.activityImage);
	mIcon.setImageDrawable(aItem.getIcon());
	
	mText01 = (TextView) findViewById(R.id.activitySubject);
	mText01.setText(aItem.getData(0));
	
	mText02 = (TextView) findViewById(R.id.activityTitle);
	mText02.setText(aItem.getData(1));
	
	mText03 = (TextView) findViewById(R.id.activityCompany);
	mText03.setText(aItem.getData(2));
	
	mText04 = (TextView) findViewById(R.id.startDay);
	mText04.setText(aItem.getData(3));
	
	mText05 = (TextView) findViewById(R.id.endDay);
	mText05.setText(aItem.getData(4));
	
	myear2014= (TextView) findViewById(R.id.year2014);
	myear2014.setText(aItem.getData(5));
	}
	
	public void setText(int index, String data){
		if (index ==0){
			mText01.setText(data);
		}else if (index ==1) {
			mText02.setText(data);
		}else if (index ==2) {
			mText03.setText(data);
		}else if (index ==3) {
			mText04.setText(data);
		}else if (index ==4) {
			mText05.setText(data);
		}else if (index ==5) {
			myear2014.setText(data+"05");
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setIcon(Drawable icon){
		mIcon.setImageDrawable(icon);
	}	
}
