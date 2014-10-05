package com.example.bluedrop;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Data>{

	private Context mContext;
	private int mLayoutResource;
	private ArrayList<Data> mList;
	private LinkedList<Data> mList_linked;
	
	private LayoutInflater mInflater;
	
	public CustomAdapter(Context context, int rowLayoutResource, ArrayList<Data> objects) {
		super(context, rowLayoutResource, objects);
		
		this.mContext = context;
		this.mLayoutResource = rowLayoutResource;
		this.mList = objects;
		this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public CustomAdapter(Context context, int rowLayoutResource, LinkedList<Data> objects) {
		super(context, rowLayoutResource, objects);
		
		this.mContext = context;
		this.mLayoutResource = rowLayoutResource;
		this.mList_linked = objects;
		this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		if(convertView == null)
			convertView = mInflater.inflate(mLayoutResource, null);
		
		Data data = getItem(position);
		if(data !=null){
			
			ImageView ivImage = (ImageView)convertView.findViewById(R.id.profile_thumbnail);
			TextView tvTitle = (TextView)convertView.findViewById(R.id.user_name);
			TextView tvDescription = (TextView)convertView.findViewById(R.id.sns_text);
			
			ivImage.setImageResource(data.getImage());
			tvTitle.setText(data.getTitle());
			tvDescription.setText(data.getDescription());
		}
		
		return convertView;
	}

	@Override
	public int getCount() //리스트 크기 반환
	{
		//return mList.size();
		return mList_linked.size();
	}

	@Override
	public Data getItem(int position) //아이템 위치 인자로 데이터 반환
	{
		//return mList.get(position);
		return mList_linked.get(position);
	}

	@Override
	public int getPosition(Data item) //아이템 데이터 인자로 인덱스 반환
	{
		//return mList.indexOf(item);
		return mList_linked.indexOf(item);
	}
}
