package com.demorku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {
	
	Button buttonExit;
	TextView textViewDiplayCorrectAnswer,textViewDiplayWrongQuestions,textViewDisplayTotalMarks;
	String CorrectAns,WrongAns,totalAnsInString;
	float totalMark;
	float  wrong,right;
	float markofWrong,markOfRight;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.result);
	    Intent mIntent = getIntent();
	    CorrectAns = mIntent.getStringExtra("correctAnswer");
	    WrongAns = mIntent.getStringExtra("mwrongAnswer");
//	    Toast.makeText(ResultActivity.this, CorrectAns, Toast.LENGTH_SHORT).show();
//	    Toast.makeText(ResultActivity.this, WrongAns, Toast.LENGTH_SHORT).show();
	  
	    right = Float.parseFloat(CorrectAns);
	    wrong =  Float.parseFloat(WrongAns);
	    markofWrong =  (float) (wrong*0.5);
	    totalMark = right-markofWrong;
	    totalAnsInString = "" + totalMark;
	   
	//   Toast.makeText(ResultActivity.this,totalAnsInString, Toast.LENGTH_SHORT).show();
	    //textViewDiplayCorrectAnswer = (TextView) findViewById(R.id.textViewDiplayCorrectAnswer);
	    //textViewDiplayWrongQuestions= (TextView) findViewById(R.id.textViewDiplayWrongQuestions);
	    //textViewDisplayTotalMarks = (TextView) findViewById(R.id.textViewDisplayTotalMarks);
	   // textViewDiplayCorrectAnswer.setText(CorrectAns);
	    //textViewDiplayWrongQuestions.setText(WrongAns);
	    //textViewDisplayTotalMarks.setText(totalAnsInString);
	    DatabaseOfStudent mDatabaseOfStudent = new DatabaseOfStudent(ResultActivity.this);
	    mDatabaseOfStudent.open();
	    String tempRowID=mDatabaseOfStudent.getlastId();
	 //   Toast.makeText(ResultActivity.this, tempRowID, Toast.LENGTH_SHORT).show();
	    mDatabaseOfStudent.setMark(totalAnsInString, tempRowID); 
		mDatabaseOfStudent.close();
	    buttonExit = (Button) findViewById(R.id.buttonExit);
	    
	    buttonExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				
				if( v== buttonExit)
	        	{
					buttonExit.setBackgroundResource(R.drawable.btn4);
	            }
		       new Handler().postDelayed(new Runnable() {
		            public void run() {
		            	if( v== buttonExit)
		            	{
		            		buttonExit.setBackgroundResource(R.drawable.btn2);
		                }
		            }
		        }, 100L); 
				
				Intent startMain = new Intent(Intent.ACTION_MAIN);
			    startMain.addCategory(Intent.CATEGORY_HOME);
			    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			    
			    finish();
			    startActivity(startMain);
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
