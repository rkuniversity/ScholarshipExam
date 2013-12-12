package com.demorku;

//import com.example.parivartaneng.student_form;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class student_form extends Activity {
	EditText editTextNameOfCandiate,editTextResidentialAddress,editTextCityName,editTextDistrictName,editTextPincodeName,editTextStudentEmailID,editTextStudentMobileNo;
	EditText editTextParentMobileNo,editTextNameOfSchool ,editTextLastName;
	String nameOfCandidate,Address,City,District,Pincode,EmailId,StudentMobileNo,ParentMobileNo,NameOfSchool;
	Button buttonRegSubmit;
	RadioButton radioMediumEnglish,radioMediumGujarati,radioGroupA,radioGroupB;
	String groupofStudent,mediumOfStudent;
	RadioGroup radioGroupofGroup,radioGroupOfMedium;
	String FullAddress;
	String mobilePattern = "^[0-9]{10}$";
	String pincodePattern = "^[0-9]{6}$";
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	String tempfirstname,tempLastName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_form);
		editTextNameOfCandiate = (EditText) findViewById(R.id.editTextNameOfCandiate);
		editTextLastName = (EditText) findViewById(R.id.editTextLastName);
		//if( editTextNameOfCandiate.getText().toString().length() == 0 || editTextNameOfCandiate.getText().toString().equals("") )
		//	editTextNameOfCandiate.setError( "Full name is required" );
		
		editTextResidentialAddress = (EditText) findViewById(R.id.editTextResidentialAddress);
		editTextCityName = (EditText) findViewById(R.id.editTextCityName);
		editTextDistrictName = (EditText) findViewById(R.id.editTextDistrictName);
		editTextPincodeName = (EditText) findViewById(R.id.editTextPincodeName);
		editTextStudentEmailID =(EditText) findViewById(R.id.editTextStudentEmailID);
		editTextStudentMobileNo = (EditText) findViewById(R.id.editTextStudentMobileNo);
		editTextParentMobileNo = (EditText) findViewById(R.id.editTextParentMobileNo);
		editTextNameOfSchool = (EditText) findViewById(R.id.editTextNameOfSchool);
		radioGroupA = (RadioButton) findViewById(R.id.radioGroupA);
		radioGroupB =(RadioButton) findViewById(R.id.radioGroupB);
		radioMediumEnglish = (RadioButton) findViewById(R.id.radioMediumEnglish);
		radioMediumGujarati = (RadioButton) findViewById(R.id.radioMediumGujarati);
		buttonRegSubmit  =(Button) findViewById(R.id.buttonRegSubmit);
		
		radioGroupofGroup = (RadioGroup) findViewById(R.id.radioGroupOfGroup);
		radioGroupOfMedium = (RadioGroup) findViewById(R.id.radioGroupOfMedium);
		
		  RadioGroup radioGroupgroup = (RadioGroup)  findViewById(R.id.radioGroupOfGroup);
	        radioGroupgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) 
	            {
	               switch (checkedId)
	               {
				case R.id.radioGroupA:
					radioGroupA = (RadioButton) findViewById(checkedId);
					  groupofStudent =radioGroupA.getText().toString();
				   
					break;
				case R.id.radioGroupB:
					radioGroupB = (RadioButton) findViewById(checkedId);
					  groupofStudent =radioGroupB.getText().toString();
					break;

				
				}
	            }
	        });
	
	        RadioGroup radioGroupMedium = (RadioGroup)  findViewById(R.id.radioGroupOfMedium);
	        radioGroupMedium.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) 
	            {
	               switch (checkedId)
	               {
				case R.id.radioMediumEnglish:
					radioMediumEnglish = (RadioButton) findViewById(checkedId);
					  mediumOfStudent =radioMediumEnglish.getText().toString();
				  
					break;
				case R.id.radioMediumGujarati:
					radioMediumGujarati = (RadioButton) findViewById(checkedId);
					mediumOfStudent =radioMediumGujarati.getText().toString();
					  
					break;

				
				}
	            }
	        });
	
		
        
		buttonRegSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
			//	DispalyQuestion mDispalyQuestion = new DispalyQuestion();
			//	mDispalyQuestion.TEmpTable=true;
				SharedPreferences setting = getSharedPreferences("Pref", 0);
			    String imported= setting.getString("imported", "");
			    
				tempfirstname = editTextNameOfCandiate.getText().toString();
				tempLastName = editTextLastName.getText().toString();
				
				Address = editTextResidentialAddress.getText().toString();
				City = editTextCityName.getText().toString();
				District = editTextDistrictName.getText().toString();
				Pincode = editTextPincodeName.getText().toString();
				EmailId = editTextStudentEmailID.getText().toString();
				StudentMobileNo = editTextStudentMobileNo.getText().toString();
				ParentMobileNo =editTextParentMobileNo.getText().toString();
				NameOfSchool = editTextNameOfSchool.getText().toString();
			//	FullAddress = Address+" " +City+ " "+District+" "+Pincode;
				
	    	if( v== buttonRegSubmit)
        	{
	    		buttonRegSubmit.setBackgroundResource(R.drawable.btn4);
            }
	       new Handler().postDelayed(new Runnable() {
	            public void run() {
	            	if( v== buttonRegSubmit)
	            	{
	            		buttonRegSubmit.setBackgroundResource(R.drawable.btn2);
	                }
	            }
	        }, 100L); 
	       
	       int flag;
	       if(!imported.equals("Yes"))
		    {
	    	   flag=0;
		    	Toast.makeText(student_form.this, "Can not start exam. Contact your supervisor",Toast.LENGTH_SHORT).show();
		    	
		    }
	       else if( tempfirstname.matches("^[a-zA-Z\\s+]+") == false )
	        {
	        	flag=0;
	        	Toast.makeText(student_form.this, "Please Enter First Name", Toast.LENGTH_SHORT).show();
	        }
	       else if( tempLastName.matches("^[a-zA-Z\\s+]+") == false )
	        {
	        	flag=0;
	        	Toast.makeText(student_form.this, "Please Enter Last Name", Toast.LENGTH_SHORT).show();
	        }
			else if( Address.length() == 0  )
	        {
	        	flag=0;
	        	Toast.makeText(student_form.this, "Please Enter Address", Toast.LENGTH_SHORT).show();
	        }
			else if( City.matches("^[a-zA-Z\\s+]+") == false )
	        {
	        	flag=0;
	        	Toast.makeText(student_form.this, "Please Enter city", Toast.LENGTH_SHORT).show();
	        }
			else if( District.matches("^[a-zA-Z\\s+]+") == false  )
	        {
	        	flag=0;
	        	Toast.makeText(student_form.this, "Please Enter District", Toast.LENGTH_SHORT).show();
	        }
			else if(Pincode.matches(pincodePattern) == false )
			{
				
					flag=0;
					Toast.makeText(student_form.this, "Invalid pincode", Toast.LENGTH_SHORT).show();
			}	
			
			else if(!(StudentMobileNo.equals("")) && StudentMobileNo.matches(mobilePattern) == false )
			{
					flag=0;
					Toast.makeText(student_form.this, "Invalid Student Mobile Number", Toast.LENGTH_SHORT).show();	
			}
			else if(ParentMobileNo.matches(mobilePattern) == false)
			{
				flag=0;
				Toast.makeText(student_form.this, "Invalid Parent mobile nubmer", Toast.LENGTH_SHORT).show();
			}
			
			
			else if(NameOfSchool.trim().equals(""))
			{
				flag=0;
				Toast.makeText(student_form.this, "Please Enter SchoolName", Toast.LENGTH_SHORT).show();
			}
			else if(!(radioGroupA.isChecked() || radioGroupB.isChecked()))
			{
				flag=0;
				Toast.makeText(student_form.this, "Please select Group A or B", Toast.LENGTH_SHORT).show();
			}
			else if(!(radioMediumEnglish.isChecked() || radioMediumGujarati.isChecked()))
			{
				flag=0;
				Toast.makeText(student_form.this, "Please select Medium Gujarati or English", Toast.LENGTH_SHORT).show();
			}
			else
				{	flag=1;	}
			
			
			if(flag==0)
			{
				
			}
			else
			{
				nameOfCandidate = tempfirstname.trim().toUpperCase() +" " +tempLastName.trim().toUpperCase();
				DatabaseOfStudent mStudent = new DatabaseOfStudent(student_form.this);
			       mStudent=mStudent.open();
			        mStudent.createEntry(nameOfCandidate.trim(),Address.trim(),City.trim(),District.trim(),Pincode,EmailId.trim(),StudentMobileNo,ParentMobileNo,NameOfSchool.trim(),groupofStudent,"Gujarati");
			mStudent.close();
				Intent openstartpoint  = new Intent(student_form.this,RulesActivity.class);
				startActivity(openstartpoint);
					finish();	
			}

			
//			Intent openstartpoint  = new Intent(student_form.this,RulesActivity.class);
//			startActivity(openstartpoint);
//				finish();	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rku_main, menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
			case R.id.FileImport:
				 Intent i = new Intent(student_form.this,MainActivity.class);
				 startActivity(i);
				break;
			
			case R.id.resultExport:
			//	Toast.makeText(student_form.this, "hello", Toast.LENGTH_SHORT).show();
				Thread mThread = new Thread(new Backup(student_form.this));
				mThread.start();
			
				break;
			
		}return false;
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
