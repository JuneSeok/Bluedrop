package com.example.dbinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private String jsonResult;
	private String url ="http://ec2-54-68-237-185.us-west-2.compute.amazonaws.com/androidtest/connect.php";
	private ListView listView;
	private Button inputBtn;
	private Button searchBtn;
	private EditText inputid;
	private EditText inputpw;
	
	String email = null;
	String pw = null;
	
	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  	setContentView(R.layout.activity_main);
	  	listView = (ListView) findViewById(R.id.listView1);
	  	inputBtn = (Button)findViewById(R.id.btninsert);
	  	searchBtn = (Button)findViewById(R.id.btnsearch);
	  	inputid = (EditText)findViewById(R.id.editText1);
	  	inputpw = (EditText)findViewById(R.id.editText2);
	  	
	  	accessWebService();
	  	
	  	searchBtn.setOnClickListener(new OnClickListener(){
	  		@Override
	  		public void onClick(View v){
	  			Toast.makeText(MainActivity.this, "데이터 조회", Toast.LENGTH_SHORT).show();
	  			accessWebService();
	  		}
	  	});
	  	
	  	
	  	inputBtn.setOnClickListener(new OnClickListener(){
	  		@Override
	  		public void onClick(View v){
	  			Toast.makeText(MainActivity.this, "입력하였습니다.", Toast.LENGTH_SHORT).show();
	  			
	  			//email = inputid.getText();
	  			
	  			//이부분에 전송하는 함수
	  			
	  			accessWebService();
	  		}
	  	});
	 }
	 
	 
	 public void accessWebService() {
		  JsonReadTask task = new JsonReadTask();
		  task.execute(new String[] { url });  //url 주소를 넘겨준다
	}
	 
	 
	 // Async Task to access the web
	 private class JsonReadTask extends AsyncTask<String, Void, String> {
	  
	  @Override
	  protected String doInBackground(String... params) { //Background작업 진행
		  
	   HttpClient httpclient = new DefaultHttpClient();
	   HttpPost httppost = new HttpPost(params[0]);
	   
	   try {
	    HttpResponse response = httpclient.execute(httppost);
	    jsonResult = inputStreamToString(
	      response.getEntity().getContent()).toString();
	   }
	 
	   catch (ClientProtocolException e) {
	    e.printStackTrace();
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	   return null;
	  }
	 
	  private StringBuilder inputStreamToString(InputStream is) {
	   String rLine = "";
	   StringBuilder answer = new StringBuilder();
	   BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	 
	   try {
	    while ((rLine = rd.readLine()) != null) {
	     answer.append(rLine);
	    }
	   }
	 
	   catch (IOException e) {
	    Toast.makeText(getApplicationContext(),
	      "Error..." + e.toString(), Toast.LENGTH_LONG).show();
	   }
	   return answer;
	  }
	 
	  @Override
	  protected void onPostExecute(String result) { //Background 작업 끝난 후 UI진행
	   ListDrwaer();
	  }
	 }// end async task
	 

	 //리스트 뷰를 위한 해쉬 셋을 만듦
	 public void ListDrwaer() {
	  List<Map<String, String>> MemberList = new ArrayList<Map<String, String>>();
	 
	  try {
	   JSONObject jsonResponse = new JSONObject(jsonResult);
	   JSONArray jsonMainNode = jsonResponse.optJSONArray("Member");
	 
	   for (int i = 0; i < jsonMainNode.length(); i++) {
	    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i); //차일드 노드 오브젝트에 메인 노드 배열의 오브젝트 담기
	    String idx = jsonChildNode.optString("idx"); // 차일드 노드에서 하나씩 뺴냄
	    String name = jsonChildNode.optString("name"); 
	    String outPut = idx + " : " + name;
	    MemberList.add(createMember("members", outPut)); //멤버 해쉬맵
	   }
	  } catch (JSONException e) {//에러
	   Toast.makeText(getApplicationContext(), "데이터를 받아오지 못했습니다" + e.toString(),Toast.LENGTH_SHORT).show();
	  }
	 
	  // 멤버 리스트로 어댑터 만들기 
	  SimpleAdapter simpleAdapter = new SimpleAdapter(this, MemberList,
	    android.R.layout.simple_list_item_1,
	    new String[] { "members" }, new int[] { android.R.id.text1 });
	  listView.setAdapter(simpleAdapter);
	 }
	 
	 private HashMap<String, String> createMember(String name, String number) {
	  HashMap<String, String> employeeNameNo = new HashMap<String, String>();
	  employeeNameNo.put(name, number);
	  return employeeNameNo;
	 }
	 
	 
	 
}
