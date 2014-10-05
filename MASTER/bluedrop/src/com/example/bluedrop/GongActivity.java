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
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.haniem),"IT,����","������ �������","�̷�â�����к� | NIPA","9.12","9.30","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.moon),"�۾���","��ȭ�� �ִ� ��","��ȭü��������","9.15","10.13","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.han),"�۾���","���ѹα� �ѽĻ��� ������","������ǰ�� | �ѽ����","8.1","9.30","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.cool),"Ǫ��","��λ� û�� ������ ��ȸ","�λ��û |�̵���","9.26","10.20","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.mrpizza),"Ǫ��","�� 8ȸ �׳�鸸�� ���� ���׽�Ʈ","Mr.Pizza","9.22","10.12","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.asan),"����,UCC","�� 1ȸ �ƻ� �����ø ������","�ƻ��û","9.15","10.13","2014"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.chang),"IT,����","â�� IT���� �̷���� ���̵�� ����","�̷�â�����к� | ������＾��","10.10","10.30","2014"));
		
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
