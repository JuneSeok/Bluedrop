package com.example.bluedrop;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class FollowActivity extends Activity {

	ListView mfollowList;				// ����Ʈ ��
	CustomAdapter_follow mfollowAdapter;	// �����
	ArrayList<Data> mList;			// ����Ʈ
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_follow);
		
				//����Ʈ �� ã��
				mfollowList = (ListView)findViewById(R.id.listView1);
				
				//�迭 ��ü ����
				mList = new ArrayList<Data>();
				
				//����� ����
				mfollowAdapter = new CustomAdapter_follow(this, R.layout.list_follow, mList); //context, resource ,object
				mfollowList.setAdapter(mfollowAdapter);
				
				mList.add(new Data(R.string.blank, R.string._9, R.drawable.hanium));
				mList.add(new Data(R.string.blank, R.string._1, R.drawable.donggun));
				mList.add(new Data(R.string.blank, R.string._2, R.drawable.hyunbin));
				mList.add(new Data(R.string.blank, R.string._3, R.drawable.jungmin));
				mList.add(new Data(R.string.blank, R.string._4, R.drawable.nara));
				mList.add(new Data(R.string.blank, R.string._5, R.drawable.sooae));
				mList.add(new Data(R.string.blank, R.string._6, R.drawable.soyoung));
				mList.add(new Data(R.string.blank, R.string._7, R.drawable.taehyun));
				mList.add(new Data(R.string.blank, R.string._8, R.drawable.yunhee));
					
		
			//	mfollowList.setOnItemClickListener(new OnItemClickListener(){
			
//			@Override
//				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//					Data curItem = (Data) mfollowAdapter.getItem(position);
//					//int curData = curItem.getDescription();
//					Toast.makeText(getApplicationContext(), "�ȷο��ϱ�", 2000).show();
//				}
//			});
		
		
	}


}
