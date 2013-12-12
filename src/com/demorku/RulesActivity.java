package com.demorku;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class RulesActivity extends Activity {
	CheckBox Chkagree;
	Button buttonStartExam;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.rules);
	    
	    Chkagree = (CheckBox) findViewById(R.id.checkBoxCheckAgree);
	    buttonStartExam = (Button) findViewById(R.id.buttonStartExam);
	    buttonStartExam.setOnClickListener(new OnClickListener() {
			
			@Override
			
			public void onClick(final View e) {
				// TODO Auto-generated method stub
				
				if(e == buttonStartExam)
	        	{ 
					buttonStartExam.setBackgroundResource(R.drawable.btn4);
	            }
		       new Handler().postDelayed(new Runnable() {
		            public void run() {
		            	if( e == buttonStartExam)
		            	{
		            		buttonStartExam.setBackgroundResource(R.drawable.btn2);
		                }
		            }
		        }, 100L); 
		       SharedPreferences setting = getSharedPreferences("Pref", 0);
		       String imported= setting.getString("imported", "");
		       if(imported.equals("Yes"))
		       {
				if(Chkagree.isChecked())
				{
			Intent mIntent = new Intent(RulesActivity.this, DispalyQuestion.class);
			startActivity(mIntent);
			finish();
				}
				else
				{
					Toast.makeText(RulesActivity.this, "Please Agree",Toast.LENGTH_SHORT).show();
				}
		       }
		       else
		       {
		    	   Toast.makeText(RulesActivity.this, "Answers not imported",Toast.LENGTH_LONG).show();
		       }
			}
		});
	
	    // TODO Auto-generated method stub
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
	    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	        // do something on back.
	        return true;
	    }

	    return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onBackPressed() {
		//Toast.makeText(MainActivity.this, "Don't back here", Toast.LENGTH_SHORT).show();
	}

}
