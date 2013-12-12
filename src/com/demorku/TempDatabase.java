package com.demorku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TempDatabase {

		public static final String  KEY_questionNo         = "questionNo";
	    public static final String  KEY_ImageNO         = "ImageNO";
	    public static final String  KEY_ANSWER          = "Answer";
	    
	    public static final String DATABASE_TABLE      = "Temp_question";
	    public static final int    DATABASE_VERSION    = 1;
	    String quetionNo;
		String question;
		String optionD;

	    private DbHelper            ourHelper;
	    private final Context       ourContext;
	    private SQLiteDatabase      ourDatabase;

	    

	    public TempDatabase(Context c)
	    {
	        ourContext = c;
	    }

	    public TempDatabase open() throws SQLException
	    {
	        ourHelper = new DbHelper(ourContext);
	        ourDatabase = ourHelper.getWritableDatabase();
	        return this;
	    }

	    public void close()
	    {
	    	ourDatabase.close();
	        ourHelper.close();
	    }

	    public void deleteTable()
	    {
	    	//ourDatabase.delete(DATABASE_TABLE, null, null);
	    	ourDatabase.execSQL("Drop table 'Temp_question'; ");
	    }


		public String getquestionNo(long l) throws Exception
	    {
			String column [] = new String[]{KEY_questionNo,KEY_ImageNO,KEY_ANSWER};
	 	   
	 	   Cursor mCursor = ourDatabase.query( DATABASE_TABLE,column, KEY_questionNo + "=" + l, null, null, null, null);
	 	   if(mCursor!=null)
	 	   {
	 		   mCursor.moveToNext();
	 		   String temquetionNo =mCursor.getString(0);
	 		  mCursor.close();
	 		   return temquetionNo;
	 	   }
	     
	 	return null;
	    }
	    
	    
		public String getImageNO(long l) throws Exception
	    {
			String column [] = new String[]{KEY_questionNo,KEY_ImageNO,KEY_ANSWER};
	 	   
	 	   Cursor mCursor = ourDatabase.query( DATABASE_TABLE,column, KEY_questionNo + "=" + l, null, null, null, null);
	 	   if(mCursor!=null)
	 	   {
	 		   mCursor.moveToNext();
	 		   String temquetionNo =mCursor.getString(1);
	 		  mCursor.close();
	 		   return temquetionNo;
	 	   }
	     
	 	return null;
	    }
	  
		public String getAnswer(long l) throws Exception
	    {
			String column [] = new String[]{KEY_questionNo,KEY_ImageNO,KEY_ANSWER};
	 	   
	 	   Cursor mCursor = ourDatabase.query( DATABASE_TABLE,column, KEY_questionNo + "=" + l, null, null, null, null);
	 	   if(mCursor!=null)
	 	   {
	 		   mCursor.moveToNext();
	 		   String temquetionNo =mCursor.getString(2);
	 		  mCursor.close();
	 		   return temquetionNo;
	 	   }
	     
	 	return null;
	    }

		public long EntryInTempData(String setTextOfNoQuestion, String mStringrandomNumber,
				String answerOption) {
			
			ContentValues mContentValues = new ContentValues();
			mContentValues.put(KEY_questionNo, setTextOfNoQuestion);
			mContentValues.put(KEY_ImageNO, mStringrandomNumber);
			mContentValues.put(KEY_ANSWER, answerOption);
			
			return ourDatabase.insert(DATABASE_TABLE, null, mContentValues);
			// TODO Auto-generated method stub
			
		}

		void createtable()
		{
			
			 ourDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " ("+KEY_questionNo + " INTEGER, " +
		          		KEY_ImageNO + " TEXT , " + 
		          		KEY_ANSWER   + " TEXT );" );
		}
}