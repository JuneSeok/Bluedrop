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
	private String[] mStrings = { "리스트", "내용", "들어가는", "데이터", "SNS", "배고팡" };
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
		
		//타이틀 액션바 숨김
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		ActionBar abar = getActionBar();
		abar.hide();
		
		//리스트 뷰 찾기
		mTimelineList = (PullToRefreshListView) findViewById(R.id.TimeineList);

		//리스트 뷰 리프레시 리스너 
				mTimelineList.setOnRefreshListener(new OnRefreshListener<ListView>() {
							@Override
							public void onRefresh(PullToRefreshBase<ListView> refreshView) {
								
								String label = DateUtils.formatDateTime(
										getApplicationContext(),
										System.currentTimeMillis(), //현재시간
										DateUtils.FORMAT_SHOW_TIME	//날짜
												| DateUtils.FORMAT_SHOW_DATE
												| DateUtils.FORMAT_ABBREV_ALL
												);

								//리프레시 뷰에 라벨(위에서 가져온 날짜시간내용)붙임 
								refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

								// 여기서 실제 리스트 리프레시 작업 실행
								new GetDataTask().execute();
							}//리프레시 하는 동안 ..
						});
//				//리스트의 마지막 부분임을 알려주는 리스너 (맨아래까지 당겼을 때 발생)
//				mTimelineList.setOnLastItemVisibleListener(
//						new OnLastItemVisibleListener() {
//							@Override
//							public void onLastItemVisible() {
//								Toast.makeText(MainActivity.this, "여기가 리스트의 끝부분입니다",
//										Toast.LENGTH_SHORT).show();
//							}
//						});

				// 실제(?) 리스트 뷰 객체 생성
				ListView actualListView = mTimelineList.getRefreshableView();

				// 컨텍스트 메뉴(롱 클릭)를 사용하려면 추가
				//registerForContextMenu(actualListView);
				
				//데이터 링크드 리스트 객체 생성
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
		
		//상단 버튼 4개 동작
		Button ActivityBtn = (Button)findViewById(R.id.btn_activity);	//대외활동
		Button FollowBtn = (Button)findViewById(R.id.btn_follow);		//팔로우
		Button ProfileBtn = (Button)findViewById(R.id.btn_profile);		//프로필
		Button SettingBtn = (Button)findViewById(R.id.btn_setting);		//설정
		
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
				//백그라운드에서 수행될 작업을 추가한다. 내용을 서버에서 받아오는 등?
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			return mStrings;
		}
	

		@Override
		protected void onPostExecute(String[] result) {
			//mListItems.addFirst("리프레시하여 새로 추가된 내용");
			if(refresh !=true){
			mList_linked.addFirst(new Data(R.string.title_8, R.string.history_8, R.drawable.group));
			mList_linked.addFirst(new Data(R.string.title_9, R.string.history_9, R.drawable.alert));
			mCustomAdapter.notifyDataSetChanged();
			refresh = true;
			}
			//리스트가 리프레시되면 onRefreshComplete를 호출
			mTimelineList.onRefreshComplete();

			super.onPostExecute(result);
		}
		
	}
		
}
