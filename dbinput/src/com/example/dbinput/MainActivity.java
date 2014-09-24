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
	  			Toast.makeText(MainActivity.this, "������ ��ȸ", Toast.LENGTH_SHORT).show();
	  			accessWebService();
	  		}
	  	});
	  	
	  	
	  	inputBtn.setOnClickListener(new OnClickListener(){
	  		@Override
	  		public void onClick(View v){
	  			Toast.makeText(MainActivity.this, "�Է��Ͽ����ϴ�.", Toast.LENGTH_SHORT).show();
	  			
	  			//email = inputid.getText();
	  			
	  			//�̺κп� �����ϴ� �Լ�
	  			
	  			accessWebService();
	  		}
	  	});
	 }
	 
	 
	 public void accessWebService() {
		  JsonReadTask task = new JsonReadTask();
		  task.execute(new String[] { url });  //url �ּҸ� �Ѱ��ش�
	}
	 
	 
	 // Async Task to access the web
	 private class JsonReadTask extends AsyncTask<String, Void, String> {
	  
	  @Override
	  protected String doInBackground(String... params) { //Background�۾� ����
		  
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
	  protected void onPostExecute(String result) { //Background �۾� ���� �� UI����
	   ListDrwaer();
	  }
	 }// end async task
	 

	 //����Ʈ �並 ���� �ؽ� ���� ����
	 public void ListDrwaer() {
	  List<Map<String, String>> MemberList = new ArrayList<Map<String, String>>();
	 
	  try {
	   JSONObject jsonResponse = new JSONObject(jsonResult);
	   JSONArray jsonMainNode = jsonResponse.optJSONArray("Member");
	 
	   for (int i = 0; i < jsonMainNode.length(); i++) {
	    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i); //���ϵ� ��� ������Ʈ�� ���� ��� �迭�� ������Ʈ ���
	    String idx = jsonChildNode.optString("idx"); // ���ϵ� ��忡�� �ϳ��� ����
	    String name = jsonChildNode.optString("name"); 
	    String outPut = idx + " : " + name;
	    MemberList.add(createMember("members", outPut)); //��� �ؽ���
	   }
	  } catch (JSONException e) {//����
	   Toast.makeText(getApplicationContext(), "�����͸� �޾ƿ��� ���߽��ϴ�" + e.toString(),Toast.LENGTH_SHORT).show();
	  }
	 
	  // ��� ����Ʈ�� ����� ����� 
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
