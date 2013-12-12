package com.demorku;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DispalyQuestion extends Activity implements OnClickListener {
	 ActivityStatus objStatus = new ActivityStatus();	
	int N =45; //20 Random numbers
	int[] randomNumber = new int[N];
	 	TextView textViewQuestionNumberDisplay;
	  Button SaveAndNext,buttonNext;
	  Button buttonSubmit;
	  RadioButton radioButtonAnswerA,radioButtonAnswerB,radioButtonAnswerC,radioButtonAnswerD;
	  int noOfquestion;
	  int attempted=0;
	  RadioGroup  radioGroupOption;
	  String answerOption;
	  ImageView imageViewQuestionAnswer;
	  	  String queNo, que,optionA,optionB,optionC,optionD;
	  int counter;
	  String tempAnswerfromData,mrightAnwer,mwrongAnswer,tempuserAnswer;
	  HashMap< String, Integer> mMap[] = new  HashMap[50];
		QuestionDatabase mQuestionDatabase;
		String []answerStore = new String[90];
		CountDownTimer mCountDown;
		TextView displayTime,displayAttempted;
		Button[] myButtons;
		CheckBox[] mCheckBoxs;
		int rightAnswer,wrongAnser;
		Intent mIntent;
		String nameOfSubject ="Result OF Exam"; 
		int maxQuestionNo=45;
		int random=0;
		int setTextOfNoQuestion;
		String temp ;
		int physicsMinNo=1,physicsMaxNo=40;
		int ChemistryMinNo=41,ChemistryMaxNo=80;
		int MathsMinNo=81,MathsMaxNo=120;
		int BiologiyMinNo=121,BiologiyMaxNo=160;
		int sizeOFquestion=15;
		
	//	boolean TEmpTable;
		
		
		private int[] mImageViews ={
				   R.drawable.question_1,
				   R.drawable.question_2,
				   R.drawable.question_3,
				   R.drawable.question_4,
				   R.drawable.question_5,
				   R.drawable.question_6,
				   R.drawable.question_7,
				   R.drawable.question_8,
				   R.drawable.question_9,
				   R.drawable.question_10,
				   R.drawable.question_11,
				   R.drawable.question_12,
				   R.drawable.question_13,
				   R.drawable.question_14,
				   R.drawable.question_15,
				   R.drawable.question_16,
				   R.drawable.question_17,
				   R.drawable.question_18,
				   R.drawable.question_19,
				   R.drawable.question_20,
				   R.drawable.question_21,
				   R.drawable.question_22,
				   R.drawable.question_23,
				   R.drawable.question_24,
				   R.drawable.question_25,
				   R.drawable.question_26,
				   R.drawable.question_27,
				   R.drawable.question_28,
				   R.drawable.question_29,
				   R.drawable.question_30,
				   R.drawable.question_31,
				   R.drawable.question_32,
				   R.drawable.question_33,
				   R.drawable.question_34,
				   R.drawable.question_35,
				   R.drawable.question_36,
				   R.drawable.question_37,
				   R.drawable.question_38,
				   R.drawable.question_39,
				   R.drawable.question_40,
				   R.drawable.question_41,
				   R.drawable.question_42,
				   R.drawable.question_43,
				   R.drawable.question_44,
				   R.drawable.question_45,
				   R.drawable.question_46,
				   R.drawable.question_47,
				   R.drawable.question_48,
				   R.drawable.question_49,
				   R.drawable.question_50,
				   R.drawable.question_51,
				   R.drawable.question_52,
				   R.drawable.question_53,
				   R.drawable.question_54,
				   R.drawable.question_55,
				   R.drawable.question_56,
				   R.drawable.question_57,
				   R.drawable.question_58,
				   R.drawable.question_59,
				   R.drawable.question_60,
				   R.drawable.question_61,
				   R.drawable.question_62,
				   R.drawable.question_63,
				   R.drawable.question_64,
				   R.drawable.question_65,
				   R.drawable.question_66,
				   R.drawable.question_67,
				   R.drawable.question_68,
				   R.drawable.question_69,
				   R.drawable.question_70,
				   R.drawable.question_71,
				   R.drawable.question_72,
				   R.drawable.question_73,
				   R.drawable.question_74,
				   R.drawable.question_75,
				   R.drawable.question_76,
				   R.drawable.question_77,
				   R.drawable.question_78,
				   R.drawable.question_79,
				   R.drawable.question_80,
				   R.drawable.question_81,
				   R.drawable.question_82,
				   R.drawable.question_83,
				   R.drawable.question_84,
				   R.drawable.question_85,
				   R.drawable.question_86,
				   R.drawable.question_87,
				   R.drawable.question_88,
				   R.drawable.question_89,
				   R.drawable.question_90,
				   R.drawable.question_91,
				   R.drawable.question_92,
				   R.drawable.question_93,
				   R.drawable.question_94,
				   R.drawable.question_95,
				   R.drawable.question_96,
				   R.drawable.question_97,
				   R.drawable.question_98,
				   R.drawable.question_99,
				   R.drawable.question_100,
				   R.drawable.question_101,
				   R.drawable.question_102,
				   R.drawable.question_103,
				   R.drawable.question_104,
				   R.drawable.question_105,
				   R.drawable.question_106,
				   R.drawable.question_107,
				   R.drawable.question_108,
				   R.drawable.question_109,
				   R.drawable.question_110,
				   R.drawable.question_111,
				   R.drawable.question_112,
				   R.drawable.question_113,
				   R.drawable.question_114,
				   R.drawable.question_115,
				   R.drawable.question_116,
				   R.drawable.question_117,
				   R.drawable.question_118,
				   R.drawable.question_119,
				   R.drawable.question_120,
				   R.drawable.question_121,
				   R.drawable.question_122,
				   R.drawable.question_123,
				   R.drawable.question_124,
				   R.drawable.question_125,
				   R.drawable.question_126,
				   R.drawable.question_127,
				   R.drawable.question_128,
				   R.drawable.question_129,
				   R.drawable.question_130,
				   R.drawable.question_131,
				   R.drawable.question_132,
				   R.drawable.question_133,
				   R.drawable.question_134,
				   R.drawable.question_135,
				   R.drawable.question_136,
				   R.drawable.question_137,
				   R.drawable.question_138,
				   R.drawable.question_139,
				   R.drawable.question_140,
				   R.drawable.question_141,
				   R.drawable.question_142,
				   R.drawable.question_143,
				   R.drawable.question_144,
				   R.drawable.question_145,
				   R.drawable.question_146,
				   R.drawable.question_147,
				   R.drawable.question_148,
				   R.drawable.question_149,
				   R.drawable.question_150,
				   R.drawable.question_151,
				   R.drawable.question_152,
				   R.drawable.question_153,
				   R.drawable.question_154,
				   R.drawable.question_155,
				   R.drawable.question_156,
				   R.drawable.question_157,
				   R.drawable.question_158,
				   R.drawable.question_159,
				   R.drawable.question_160,
			};
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.display_question);
			DatabaseOfStudent mDatabaseOfStudent = new DatabaseOfStudent(DispalyQuestion.this);
			mDatabaseOfStudent.open();
		String GroupOFStudent=	mDatabaseOfStudent.getlastGroup();
				mDatabaseOfStudent.close();
	//	Toast.makeText(DispalyQuestion.this,GroupOFStudent, Toast.LENGTH_SHORT).show();
			
		 RandomMethod(sizeOFquestion,physicsMinNo,physicsMaxNo,0,14);
		 RandomMethod(sizeOFquestion,ChemistryMinNo,ChemistryMaxNo,15,29);
		 if(GroupOFStudent.equals("A"))
		 	{	
			// Toast.makeText(DispalyQuestion.this,"A", Toast.LENGTH_SHORT).show();
			 RandomMethod(sizeOFquestion,MathsMaxNo,MathsMinNo,30,44);
		 }
		 else
		 {
		//	 Toast.makeText(DispalyQuestion.this,"B", Toast.LENGTH_SHORT).show();
			 RandomMethod(sizeOFquestion,BiologiyMinNo,BiologiyMaxNo,30,44);
		 }
		
			
			
			imageViewQuestionAnswer = (ImageView) findViewById(R.id.imageViewQuestionAnswer);
			textViewQuestionNumberDisplay = (TextView) findViewById(R.id.textViewQuestionNumberDisplay);
			//imageViewQuestionAnswer.setBackgroundResource(ic)
			
			displayTime = (TextView) findViewById(R.id.textViewDisplayTimeLeft);
			displayAttempted=(TextView) findViewById(R.id.textViewDisplayAttempted);
		    mCountDown= new CountDownTimer(3000000, 1000) {

			     public void onTick(long millisUntilFinished) {
			         displayTime.setText("" + millisUntilFinished / 60000+":"+(millisUntilFinished/1000)%60);
			         if(millisUntilFinished / 60000==10 && (millisUntilFinished/1000)%60==0)
			         {
			        	 buttonSubmit.setEnabled(true);
			         }
			     }

			     public void onFinish() {
			         displayTime.setText("done!");
			         resultOfStudent();
			         TempDatabase mTempDatabase = new TempDatabase(DispalyQuestion.this);
			         try{
			       
			         
						mTempDatabase.open();
						mTempDatabase.deleteTable();
						mTempDatabase.close();
			         }
			         catch(Exception e)
			         {
			         
			         }
			         mCountDown.cancel();
//			         if(TEmpTable==false)
//			       {
			         finish();
			     //    }
			     }
			  }.start();
			  
			  buttonSubmit = (Button) findViewById(R.id.buttonsubmit);
				buttonSubmit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(final View e) {
						// TODO Auto-generated method stub
						
					//	TEmpTable=false;
						if(e == buttonSubmit)
			        	{ 
							buttonSubmit.setBackgroundResource(R.drawable.btn4);
			            }
				       new Handler().postDelayed(new Runnable() {
				            public void run() {
				            	if( e == buttonSubmit)
				            	{
				            		buttonSubmit.setBackgroundResource(R.drawable.btn2);
				                }
				            }
				        }, 100L); 
				      // mCountDown.onFinish();
				       AlertDialog.Builder builder = new AlertDialog.Builder(DispalyQuestion.this);
						  builder.setMessage("You Have Not Attempted " + (45-attempted)+" Questions.\nAre you sure you want to submit?")
						         .setCancelable(false)
						         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						             public void onClick(DialogInterface dialog, int id) {
//						            	       Intent mIntent = new Intent(DispalyQuestion.this,ResultActivity.class);     	
//											mIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//											
//											startActivity(mIntent);
						            	 mCountDown.onFinish();
						             }
						         })
						         .setNegativeButton("No", new DialogInterface.OnClickListener() {
						             public void onClick(DialogInterface dialog, int id) {
						                  dialog.cancel();
						             }
						         });
						  AlertDialog alert = builder.create();
						  alert.show();
						
				       
						//Intent mIntent = new Intent(DispalyQuestion.this,ResultActivity.class);
						//mIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						//startActivity(mIntent);
					}
				});

				
			
			idOfButtonAndCheckbox();
			radioGroupOption = (RadioGroup)  findViewById(R.id.radioGroupQuestionOption);
			 radioGroupOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				 
		            @Override
		            public void onCheckedChanged(RadioGroup group, int checkedId) 
		            {
		            	mMap[noOfquestion]= new HashMap<String, Integer>();
		               switch (checkedId)
		               {
					case R.id.radioDisplayOptionA:
						radioButtonAnswerA = (RadioButton) findViewById(checkedId);
						  answerOption =radioButtonAnswerA.getText().toString();
						  mMap[noOfquestion].put("answer", 1);
						  
											    
						break;
					case R.id.radioDisplayOptionB:
						radioButtonAnswerB= (RadioButton) findViewById(checkedId);
						answerOption =radioButtonAnswerB.getText().toString();
						mMap[noOfquestion].put("answer", 2);
					
						
						 
						break;
						
					case R.id.radioDisplayOptionC:
						radioButtonAnswerC = (RadioButton) findViewById(checkedId);
						  answerOption =radioButtonAnswerC.getText().toString();
						  mMap[noOfquestion].put("answer", 3);
						
						  
						  
						break;
					case R.id.radioDisplayOptionD:
						radioButtonAnswerD= (RadioButton) findViewById(checkedId);
						answerOption =radioButtonAnswerD.getText().toString();
						mMap[noOfquestion].put("answer", 4);
						
						
						break;
						
					
					}
		               
		            }

					
		        });
			
			
			 Drawable d = getResources().getDrawable(mImageViews[randomNumber[noOfquestion]-1]);
			
				imageViewQuestionAnswer.setBackgroundDrawable(d);
				noOfquestion=1;
				setTextOfNoQuestion=1;
				 textViewQuestionNumberDisplay.setText("Que- "+setTextOfNoQuestion);
				buttonNext = (Button) findViewById(R.id.buttonNext);
				buttonSubmit.setEnabled(false);
				buttonNext.setOnClickListener(this);
				  
			SaveAndNext = (Button) findViewById(R.id.buttonSaveAndNext);
			SaveAndNext.setOnClickListener(this);
			 myButtons = new Button[]
					    {
				(Button) findViewById(R.id.buttonConform ),
				(Button) findViewById(R.id.button2),
				(Button) findViewById(R.id.button3),
				(Button) findViewById(R.id.button4),
				(Button) findViewById(R.id.button5),
				(Button) findViewById(R.id.button6),
				(Button) findViewById(R.id.button7),
				(Button) findViewById(R.id.button8),
				(Button) findViewById(R.id.button9),
				(Button) findViewById(R.id.button10),
				(Button) findViewById(R.id.button11),
				(Button) findViewById(R.id.button12),
				(Button) findViewById(R.id.button13),
				(Button) findViewById(R.id.button14),
				(Button) findViewById(R.id.button15),
				(Button) findViewById(R.id.button16),
				(Button) findViewById(R.id.button17),
				(Button) findViewById(R.id.button18),
				(Button) findViewById(R.id.button19),
				(Button) findViewById(R.id.button20),
				(Button) findViewById(R.id.button21),
				(Button) findViewById(R.id.button22),
				(Button) findViewById(R.id.button23),
				(Button) findViewById(R.id.button24),
				(Button) findViewById(R.id.button25),
				(Button) findViewById(R.id.button26),
				(Button) findViewById(R.id.button27),
				(Button) findViewById(R.id.button28),
				(Button) findViewById(R.id.button29),
				(Button) findViewById(R.id.button30),
				(Button) findViewById(R.id.button31),
				(Button) findViewById(R.id.button32),
				(Button) findViewById(R.id.button33),
				(Button) findViewById(R.id.button34),
				(Button) findViewById(R.id.button35),
				(Button) findViewById(R.id.button36),
				(Button) findViewById(R.id.button37),
				(Button) findViewById(R.id.button38),
				(Button) findViewById(R.id.button39),
				(Button) findViewById(R.id.button40),
				(Button) findViewById(R.id.button41),
				(Button) findViewById(R.id.button42),
				(Button) findViewById(R.id.button43),
				(Button) findViewById(R.id.button44),
				(Button) findViewById(R.id.button45),
					    };
			 for(int i = 0; i< myButtons.length; i++)
					myButtons[i].setOnClickListener(new OnClickListener() {
				
				@Override 
				public void onClick(final View v) {
					// TODO Auto-generated method stub
					Button btn = (Button)v;
					int question = Integer.parseInt(btn.getText().toString());
					noOfquestion=question;
					setTextOfNoQuestion=question;
					//Toast.makeText(DispalyQuestion.this,""+noOfquestion, Toast.LENGTH_SHORT).show();
					buttonselected(noOfquestion);
					
					
				}
			});
			 mCheckBoxs = new  CheckBox[]
						{
				 (CheckBox) findViewById(R.id.checkBox1),
	   			 (CheckBox) findViewById(R.id.checkBox2),
				 (CheckBox) findViewById(R.id.checkBox3),
				 (CheckBox) findViewById(R.id.checkBox4),
				 (CheckBox) findViewById(R.id.checkBox5),
				 (CheckBox) findViewById(R.id.checkBox6),
				 (CheckBox) findViewById(R.id.checkBox7),
				 (CheckBox) findViewById(R.id.checkBox8),
				 (CheckBox) findViewById(R.id.checkBox9),
				 (CheckBox) findViewById(R.id.checkBox10),
				 (CheckBox) findViewById(R.id.checkBox11),
				 (CheckBox) findViewById(R.id.checkBox12),
				 (CheckBox) findViewById(R.id.checkBox13),
				 (CheckBox) findViewById(R.id.checkBox14),
				 (CheckBox) findViewById(R.id.checkBox15),
				 (CheckBox) findViewById(R.id.checkBox16),
				 (CheckBox) findViewById(R.id.checkBox17),
				 (CheckBox) findViewById(R.id.checkBox18),
				 (CheckBox) findViewById(R.id.checkBox19),
				 (CheckBox) findViewById(R.id.checkBox20),
				 (CheckBox) findViewById(R.id.checkBox21),
				 (CheckBox) findViewById(R.id.checkBox22),
				 (CheckBox) findViewById(R.id.checkBox23),
				 (CheckBox) findViewById(R.id.checkBox24),
				 (CheckBox) findViewById(R.id.checkBox25),
				 (CheckBox) findViewById(R.id.checkBox26),
				 (CheckBox) findViewById(R.id.checkBox27),
				 (CheckBox) findViewById(R.id.checkBox28),
				 (CheckBox) findViewById(R.id.checkBox29),
				 (CheckBox) findViewById(R.id.checkBox30),
				 (CheckBox) findViewById(R.id.checkBox31),
				 (CheckBox) findViewById(R.id.checkBox32),
				 (CheckBox) findViewById(R.id.checkBox33),
				 (CheckBox) findViewById(R.id.checkBox34),
				 (CheckBox) findViewById(R.id.checkBox35),
				 (CheckBox) findViewById(R.id.checkBox36),
				 (CheckBox) findViewById(R.id.checkBox37),
				 (CheckBox) findViewById(R.id.checkBox38),
				 (CheckBox) findViewById(R.id.checkBox39),
				 (CheckBox) findViewById(R.id.checkBox40),
				 (CheckBox) findViewById(R.id.checkBox41),
				 (CheckBox) findViewById(R.id.checkBox42),
				 (CheckBox) findViewById(R.id.checkBox43),
				 (CheckBox) findViewById(R.id.checkBox44),
				 (CheckBox) findViewById(R.id.checkBox45),
						};
				}

		

	

		private void RandomMethod(int max,int MinNo,int MaxNo,int storeno,int endno ) {
			// TODO Auto-generated method stub
			int satrting=0;
		//	Toast.makeText(DispalyQuestion.this, ""+storeno, Toast.LENGTH_SHORT).show();
			while( satrting <max)
				
			{
				random = generateRandom(MinNo, MaxNo);
				boolean flag=false;
				
			    for( int tempstoreno=0;tempstoreno<45;tempstoreno++)
			    {
			    	if(random==randomNumber[tempstoreno])
			    	{
			    			flag=true;
			    			
			    	//Toast.makeText(DispalyQuestion.this, "hello", Toast.LENGTH_SHORT).show();
			    	}
			    	
			    }
			    if(flag==false)
			    {
			    	randomNumber[storeno]=random;
			   	temp =""+randomNumber[storeno];
			   // Toast.makeText(DispalyQuestion.this, temp, Toast.LENGTH_SHORT).show();
			    	storeno++;
			    	satrting++;
			    }
			}
			
		}





		private int generateRandom(int min, int max) {
			// TODO Auto-generated method stub
			return min + (int)(Math.random() * ((max - min) + 1));
		}





		private void idOfButtonAndCheckbox() {
			// TODO Auto-generated method stub
			
			
			
			
			radioButtonAnswerA = (RadioButton) findViewById(R.id.radioDisplayOptionA);
			radioButtonAnswerB = (RadioButton) findViewById(R.id.radioDisplayOptionB);
			radioButtonAnswerC = (RadioButton) findViewById(R.id.radioDisplayOptionC);
			radioButtonAnswerD = (RadioButton) findViewById(R.id.radioDisplayOptionD);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.rku_main, menu);
			return true;
		}

		@Override
		public void onClick(final View p) {

			switch(p.getId())
			{
			case R.id.buttonSaveAndNext:
			{
				
				answerStore[noOfquestion-1]=answerOption;
				if( p== SaveAndNext)
				{
					SaveAndNext.setBackgroundResource(R.drawable.btn4);

				}
				new Handler().postDelayed(new Runnable() {
					public void run() {
						if( p== SaveAndNext)
						{
							SaveAndNext.setBackgroundResource(R.drawable.btn2);
						}
					}
				}, 100L); 


				try
				{
					if(mMap[noOfquestion].isEmpty())
					{	     		
						Toast.makeText(DispalyQuestion.this, "please select any option", Toast.LENGTH_SHORT).show();
					}
					else
					{

						String mStringsetTextOfNoQuestion ="" +setTextOfNoQuestion;
						int temp =randomNumber[setTextOfNoQuestion-1];
						String mStringrandomNumber = "" +temp;

						TempDatabase mTempDatabase = new TempDatabase(DispalyQuestion.this);
						mTempDatabase.open();
						mTempDatabase.createtable();
						mTempDatabase.EntryInTempData(mStringsetTextOfNoQuestion,mStringrandomNumber ,answerOption);
						mTempDatabase.close();
						//	Toast.makeText(DispalyQuestion.this, ""+setTextOfNoQuestion, Toast.LENGTH_SHORT).show();

						mCheckBoxs[setTextOfNoQuestion-1].setChecked(true);
						noOfquestion++;
						setTextOfNoQuestion++;
						if(noOfquestion>maxQuestionNo)
						{
							buttonSubmit.setEnabled(true);
							noOfquestion=maxQuestionNo;
							setTextOfNoQuestion=noOfquestion;
							mCheckBoxs[44].setChecked(true);
							Toast.makeText(DispalyQuestion.this, "No more Question", Toast.LENGTH_SHORT).show();
						}
						else
						{

							//   Toast.makeText(DispalyQuestion.this, ""+noOfquestion, Toast.LENGTH_SHORT).show();
							try
							{
								Drawable d = getResources().getDrawable(mImageViews[randomNumber[noOfquestion-1]-1]); 
								imageViewQuestionAnswer.setBackgroundDrawable(d);
							}catch(Exception e)
							{}
							textViewQuestionNumberDisplay.setText("Que-"+setTextOfNoQuestion);


							if(mMap[noOfquestion]!=null)
							{
								try {
									isCheckedMaptrue(noOfquestion);
								} catch (Exception e) {
									radioGroupOption.clearCheck();
								}
							}else
							{
								radioGroupOption.clearCheck();
							}
						}	}
				}	
				catch (NullPointerException e) {
					// TODO: handle exception
					radioGroupOption.clearCheck();
				}
				attempted=0;
				for(int cc=0;cc<45;cc++)
				{
					if(mCheckBoxs[cc].isChecked()==true)
					{
						attempted++;
					}
				}
				displayAttempted.setText(" "+attempted);
			}

			break;
			case R.id.buttonNext:
			{

				if(mMap[noOfquestion]!=null)
				{
					radioGroupOption.clearCheck();
					mCheckBoxs[noOfquestion-1].setChecked(false);	
				}

				//Toast.makeText(this, "null 6", Toast.LENGTH_SHORT).show();
				noOfquestion++;
				//Toast.makeText(this, ""+noOfquestion, Toast.LENGTH_SHORT).show();
				setTextOfNoQuestion++;
				if(noOfquestion>maxQuestionNo)
				{	
					buttonSubmit.setEnabled(true);
					noOfquestion=maxQuestionNo;
					setTextOfNoQuestion=maxQuestionNo;
					Toast.makeText(this, "No more Question", Toast.LENGTH_SHORT).show();

				}
				else
				{
					try
					{
						Drawable d = getResources().getDrawable(mImageViews[randomNumber[noOfquestion-1]-1]);
						imageViewQuestionAnswer.setBackgroundDrawable(d);
					}catch(Exception e){
					}
					textViewQuestionNumberDisplay.setText("Que-"+setTextOfNoQuestion);
					if(mMap[noOfquestion]!=null)
					{
						try {
							isCheckedMaptrue(noOfquestion);
						} catch (Exception e) {
							radioGroupOption.clearCheck();
						}
					}else
					{
						radioGroupOption.clearCheck();
					}

				}
				attempted=0;
				for(int cc=0;cc<45;cc++)
				{
					if(mCheckBoxs[cc].isChecked()==true)
					{
						attempted++;
					}
				}
				displayAttempted.setText(" "+attempted);

			}	

			break;

			}
		}
private void buttonselected(int question) {
			// TODO Auto-generated method stub
		
		int tempOfnpquestion =question-1;
		
		//noOfquestion=tempOfnpquestion;
		try
		{
	 Drawable d = getResources().getDrawable(mImageViews[randomNumber[tempOfnpquestion]-1]);
	 imageViewQuestionAnswer.setBackgroundDrawable(d);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		
		textViewQuestionNumberDisplay.setText("Que- "+question);
		try
		{
		isCheckedMaptrue(noOfquestion);
		}catch(NullPointerException e)
		{
			radioGroupOption.clearCheck();
		}
		}



	private void isCheckedMMapIsEmpty() {
			// TODO Auto-generated method stub
			if(mMap[noOfquestion]==null)
			{	 
				
				radioGroupOption.clearCheck();
			}
			else
				{
				
				if(mMap[noOfquestion]!=null)
					{
						
							try {
							 
								isCheckedMaptrue(noOfquestion);
							 } catch (Exception e) {
								// TODO Auto-generated catch block  
								 }
					}
					else
					{
					  	 radioGroupOption.clearCheck();
					}
		
				}
		}
		private void isCheckedMaptrue(int noOfquestion2) {
			// TODO Auto-generated method stub
			if(mMap[noOfquestion]!=null)
			 {
				//Toast.makeText(DispalyQuestion.this, ""+noOfquestion2, Toast.LENGTH_SHORT).show();
							 int i=0;
				  i = mMap[noOfquestion].get("answer");
				  switch(i)
				  {
				  case 1:
					  radioButtonAnswerA.setChecked(true);
					  break;
				  case 2:
					  radioButtonAnswerB.setChecked(true);
					  break;
				  case 3:
					  radioButtonAnswerC.setChecked(true);
					  break;
				  case 4:
					  radioButtonAnswerD.setChecked(true);
				  break;
			 }
			 } 
			 else
			 {
				 radioGroupOption.clearCheck();
		     }
			
		}
		
		
		private void resultOfStudent() 
		{
			for(int noOfquestion=0;noOfquestion<45;noOfquestion++)
			{
					if(answerStore[noOfquestion] != null)
		 		{
						try {
				tempuserAnswer =answerStore[noOfquestion].toString();
				//Toast.makeText(DispalyQuestion.this, tempuserAnswer, Toast.LENGTH_SHORT).show();
				mQuestionDatabase = new QuestionDatabase(DispalyQuestion.this);
							mQuestionDatabase.open();
							int tempNoofrandom =randomNumber[noOfquestion];
					//		Toast.makeText(DispalyQuestion.this, ""+tempNoofrandom, Toast.LENGTH_SHORT).show();
				
					tempAnswerfromData =mQuestionDatabase.getAnswer(tempNoofrandom);
					

					mQuestionDatabase.close();
					if( tempuserAnswer.equals(tempAnswerfromData))
					{
						rightAnswer++;
					}
					else
					{
						wrongAnser++;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				
				//	Toast.makeText(DispalyQuestion.this, tempAnswerfromData, Toast.LENGTH_SHORT).show();
				
					
				}
			}
					
			mrightAnwer =""+rightAnswer;
			mwrongAnswer = "" +wrongAnser;
		//	Toast.makeText(DispalyQuestion.this, mrightAnwer, Toast.LENGTH_SHORT).show();
		//	Toast.makeText(DispalyQuestion.this,mwrongAnswer, Toast.LENGTH_SHORT).show();
			Intent mIntent = new Intent(DispalyQuestion.this,ResultActivity.class);
		       mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		       	mIntent.putExtra("nameOfSubject", nameOfSubject);
				mIntent.putExtra("correctAnswer",mrightAnwer);
				mIntent.putExtra("mwrongAnswer", mwrongAnswer);
				startActivity(mIntent);
				//finish();
			
				
		}





		@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
			objStatus.updateStatusList("DisplayQuestion", "Restarted");
		}





		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			objStatus.updateStatusList("DisplayQuestion", "Resumed");
		}





		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			objStatus.updateStatusList("DisplayQuestion", "paused");
		}
		
		 @Override
		    protected void onStop() {
		        super.onStop();
		        objStatus.updateStatusList("DisplayQuestion","Stoped");
		    }
		 
		   @Override
		    protected void onDestroy() {
		        super.onDestroy();
		        objStatus.updateStatusList("DisplayQuestion","Destroyed");
		    }
		   @Override
			public boolean onKeyDown(int keyCode, KeyEvent event)  {
			    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			        // do something on back.
			        return true;
			    }
			    if(keyCode==KeyEvent.KEYCODE_HOME)
			    {
			    	return false;
			    }
			    return super.onKeyDown(keyCode, event);
			}
			
			@Override
			public void onBackPressed() {
				//Toast.makeText(MainActivity.this, "Don't back here", Toast.LENGTH_SHORT).show();
			}
			
	
}
