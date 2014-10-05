package com.example.bluedrop;

import java.util.ArrayList;
import java.util.LinkedList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends Activity {
	private String[] mStrings = { "����Ʈ", "����", "����", "������", "SNS", "�����" };
	 boolean refresh=false;
	private LinkedList<String> mListItems;
	private PullToRefreshListView mTimelineList;
	private ArrayAdapter<String> mAdapter;
	
	ArrayList<Data> mList;
	LinkedList<Data> mList_linked;
	CustomAdapter mCustomAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Ÿ��Ʋ �׼ǹ� ����
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		ActionBar abar = getActionBar();
		abar.hide();
		
		//����Ʈ �� ã��
		mTimelineList = (PullToRefreshListView) findViewById(R.id.TimeineList);

		//����Ʈ �� �������� ������ 
				mTimelineList.setOnRefreshListener(new OnRefreshListener<ListView>() {
							@Override
							public void onRefresh(PullToRefreshBase<ListView> refreshView) {
								
								String label = DateUtils.formatDateTime(
										getApplicationContext(),
										System.currentTimeMillis(), //����ð�
										DateUtils.FORMAT_SHOW_TIME	//��¥
												| DateUtils.FORMAT_SHOW_DATE
												| DateUtils.FORMAT_ABBREV_ALL
												);

								//�������� �信 ��(������ ������ ��¥�ð�����)���� 
								refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

								// ���⼭ ���� ����Ʈ �������� �۾� ����
								new GetDataTask().execute();
							}//�������� �ϴ� ���� ..
						});
//				//����Ʈ�� ������ �κ����� �˷��ִ� ������ (�ǾƷ����� ����� �� �߻�)
//				mTimelineList.setOnLastItemVisibleListener(
//						new OnLastItemVisibleListener() {
//							@Override
//							public void onLastItemVisible() {
//								Toast.makeText(MainActivity.this, "���Ⱑ ����Ʈ�� ���κ��Դϴ�",
//										Toast.LENGTH_SHORT).show();
//							}
//						});

				// ����(?) ����Ʈ �� ��ü ����
				ListView actualListView = mTimelineList.getRefreshableView();

				// ���ؽ�Ʈ �޴�(�� Ŭ��)�� ����Ϸ��� �߰�
				//registerForContextMenu(actualListView);
				
				//������ ��ũ�� ����Ʈ ��ü ����
				mList_linked = new LinkedList<Data>();
				mCustomAdapter = new CustomAdapter(this,R.layout.timeline_item, mList_linked);
				
				actualListView.setAdapter(mCustomAdapter);
				
				mList_linked.add(new Data(R.string.title_1, R.string.history_1, R.drawable.scrap));
				mList_linked.add(new Data(R.string.title_6, R.string.history_6, R.drawable.zim));
				mList_linked.add(new Data(R.string.title_3, R.string.history_3, R.drawable.timeend));
				mList_linked.add(new Data(R.string.title_4, R.string.history_4, R.drawable.zoom));
				mList_linked.add(new Data(R.string.title_5, R.string.history_5, R.drawable.group));
				mList_linked.add(new Data(R.string.title_2, R.string.history_2, R.drawable.alert));
				mList_linked.add(new Data(R.string.title_7, R.string.history_7, R.drawable.member));
		
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
	
	
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {
		@Override
		protected String[] doInBackground(Void... params) {
			try {
				//��׶��忡�� ����� �۾��� �߰��Ѵ�. ������ �������� �޾ƿ��� ��?
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			return mStrings;
		}
	

		@Override
		protected void onPostExecute(String[] result) {
			//mListItems.addFirst("���������Ͽ� ���� �߰��� ����");
			if(refresh !=true){
			mList_linked.addFirst(new Data(R.string.title_8, R.string.history_8, R.drawable.group));
			mList_linked.addFirst(new Data(R.string.title_9, R.string.history_9, R.drawable.alert));
			mCustomAdapter.notifyDataSetChanged();
			refresh = true;
			}
			//����Ʈ�� �������õǸ� onRefreshComplete�� ȣ��
			mTimelineList.onRefreshComplete();

			super.onPostExecute(result);
		}
		
	}
		
}
