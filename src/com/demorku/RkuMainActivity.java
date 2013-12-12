package com.demorku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;

public class RkuMainActivity extends Activity {
	DispalyQuestion mDispalyQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rku_main);
    	 mDispalyQuestion = new DispalyQuestion();
    //	 Toast.makeText(RkuMainActivity.this, ""+mDispalyQuestion.TEmpTable, Toast.LENGTH_SHORT).show();
  Thread timer = new Thread(){
			public void run(){
					try{
					sleep(4000);
			}catch(InterruptedException e){
				e.printStackTrace();
				
			}finally{
//					
//				if(mDispalyQuestion.TEmpTable==false)
//				{
				Intent openstartpoint  = new Intent(RkuMainActivity.this,student_form.class);
				startActivity(openstartpoint);
			//	}
//				else
//				{
//					Intent openstartpoint  = new Intent(RkuMainActivity.this,DispalyQuestion.class);
//					startActivity(openstartpoint);
//				}
			}
		}
			
		};
		timer.start();
	}
	protected void onPause(){
    super.onPause();
    
 	finish();
	 }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rku_main, menu);
        return true;
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
