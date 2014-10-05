package com.example.bluedrop;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

 

public class CustomAdapter_follow extends ArrayAdapter<Data>{
	
	private Context mContext; // Context 객체
	private int mLayoutResource;
	private ArrayList<Data> mList; //Data를 하나의 값으로 갖는 배열 선언
	private LayoutInflater mInflater; // Inflater객체
	
	//CustomAdapter 생성자
	public CustomAdapter_follow(Context context, int rowLayoutResource, ArrayList<Data> objects)
	{
		super(context, rowLayoutResource, objects);
		//컨텍스트
		this.mContext = context;
		//리소스
		this.mLayoutResource = rowLayoutResource;
		//리스트 객체
		this.mList = objects;
		//인플레이터 객체
		this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		
	}
	

	@Override
	public int getCount() //리스트 크기 반환
	{
		return mList.size();
	}

	@Override
	public Data getItem(int position) //아이템 위치 인자로 데이터 반환
	{
		return mList.get(position);
	}

	@Override
	public int getPosition(Data item) //아이템 데이터 인자로 인덱스 반환
	{
		return mList.indexOf(item);
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{//어댑터가 가진 데이터를 어떻게 보여줄지 정의함

		if(convertView == null)
		{
			convertView = mInflater.inflate(mLayoutResource, null); //비었으면 가져왔던 리소스를 인플레이트
		}
		
		Data data = getItem(position); //데이터 가져옴
		
		if(data != null) //데이터 넣음
		{
			ImageView ivImage = (ImageView)convertView.findViewById(R.id.profile_thumbnail); //프로필이미지
		//	TextView tvTitle = (TextView)convertView.findViewById(R.id.user_name);
			TextView tvDescription = (TextView)convertView.findViewById(R.id.sns_text);
			
			ivImage.setImageResource(data.getImage());
		//	tvTitle.setText(data.getTitle());
			tvDescription.setText(data.getDescription());
		}

		return convertView;
	}
}
