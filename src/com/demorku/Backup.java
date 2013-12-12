package com.demorku;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Backup implements Runnable {

	Context ctx;
	public Backup(Context ctx)
	{
		this.ctx=ctx;
	}
	@Override
	public void run() {
		
		DbHelper helper= new DbHelper(ctx);
    	SQLiteDatabase database = helper.getReadableDatabase();
    	Cursor c = database.rawQuery("SELECT * FROM Student_Information", null);
    	
    	HttpClient client; 
    	HttpPost post;
    	boolean flag=false;
    	//int i=0;
    	//c.moveToNext();
    	while(c.moveToNext())
    	{
    		client = new DefaultHttpClient();
    		post = new HttpPost("http://172.172.101.15/parivartan/export.php");
    		List<NameValuePair> data = new ArrayList<NameValuePair>(1);
    		data.add(new BasicNameValuePair("st_name", c.getString(1)));
    		data.add(new BasicNameValuePair("st_address", c.getString(2)));
    		data.add(new BasicNameValuePair("st_city", c.getString(3)));
    		data.add(new BasicNameValuePair("st_district", c.getString(4)));
    		data.add(new BasicNameValuePair("st_pincode", c.getString(5)));
    		data.add(new BasicNameValuePair("st_email", c.getString(6)));
    		data.add(new BasicNameValuePair("st_mobile", c.getString(7)));
    		data.add(new BasicNameValuePair("parent_mobile", c.getString(8)));
    		data.add(new BasicNameValuePair("st_school", c.getString(9)));
    		data.add(new BasicNameValuePair("st_group", c.getString(10)));
    		data.add(new BasicNameValuePair("st_medium", c.getString(11)));
    		data.add(new BasicNameValuePair("st_marks", ""+c.getFloat(12)));
    		
    		try {
    			post.setEntity(new UrlEncodedFormEntity(data));
    			client.execute(post);
    		} catch(Exception e){
    			flag=true;
    			//Toast.makeText(ctx, e.toString(), Toast.LENGTH_LONG).show();
    		}
    		client=null;
    		post=null;
    	//	i++;
    	}
    	database=null;
    	if(flag==false)
    	{
    		//Toast.makeText(ctx, i+" Records successfully Exported", Toast.LENGTH_SHORT).show();
    		database=helper.getWritableDatabase();
    		database.delete("Student_Information", null, null);	
    	}
	}

}
