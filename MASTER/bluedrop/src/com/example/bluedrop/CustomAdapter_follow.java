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
	
	private Context mContext; // Context ��ü
	private int mLayoutResource;
	private ArrayList<Data> mList; //Data�� �ϳ��� ������ ���� �迭 ����
	private LayoutInflater mInflater; // Inflater��ü
	
	//CustomAdapter ������
	public CustomAdapter_follow(Context context, int rowLayoutResource, ArrayList<Data> objects)
	{
		super(context, rowLayoutResource, objects);
		//���ؽ�Ʈ
		this.mContext = context;
		//���ҽ�
		this.mLayoutResource = rowLayoutResource;
		//����Ʈ ��ü
		this.mList = objects;
		//���÷����� ��ü
		this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		
	}
	

	@Override
	public int getCount() //����Ʈ ũ�� ��ȯ
	{
		return mList.size();
	}

	@Override
	public Data getItem(int position) //������ ��ġ ���ڷ� ������ ��ȯ
	{
		return mList.get(position);
	}

	@Override
	public int getPosition(Data item) //������ ������ ���ڷ� �ε��� ��ȯ
	{
		return mList.indexOf(item);
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{//����Ͱ� ���� �����͸� ��� �������� ������

		if(convertView == null)
		{
			convertView = mInflater.inflate(mLayoutResource, null); //������� �����Դ� ���ҽ��� ���÷���Ʈ
		}
		
		Data data = getItem(position); //������ ������
		
		if(data != null) //������ ����
		{
			ImageView ivImage = (ImageView)convertView.findViewById(R.id.profile_thumbnail); //�������̹���
		//	TextView tvTitle = (TextView)convertView.findViewById(R.id.user_name);
			TextView tvDescription = (TextView)convertView.findViewById(R.id.sns_text);
			
			ivImage.setImageResource(data.getImage());
		//	tvTitle.setText(data.getTitle());
			tvDescription.setText(data.getDescription());
		}

		return convertView;
	}
}
