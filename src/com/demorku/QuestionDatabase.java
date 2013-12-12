package com.demorku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class QuestionDatabase 
{
	
	public static final String  KEY_questionNo                 = "questionNo";
   
    public static final String  KEY_Answer				        ="Answer";
    
    public static final String DATABASE_NAME          = "QuestionDatbase";
    private static final String DATABASE_TABLE        = "Question_paper";
    private static final int    DATABASE_VERSION    = 1;

    private DbHelper            ourHelper;
    private final Context       ourContext;
    private SQLiteDatabase      ourDatabase;

    private static class DbHelper extends SQLiteOpenHelper
    {

        public DbHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE IF NOT EXISTS " +  DATABASE_TABLE + " ("+KEY_questionNo + " INTEGER, " +
            																  KEY_Answer   + " TEXT );" );
            				                                     
            												
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXITS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public QuestionDatabase(Context c)
    {
        ourContext = c;
    }

    public QuestionDatabase open() throws SQLException
    {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        ourHelper.close();
        
    }

	public long createEntry(String questionNo,String Answer) {
		
		 ContentValues cv = new ContentValues();
		 	cv.put(KEY_questionNo,questionNo);
	        cv.put(KEY_Answer,Answer);
	     
	        
	       
	   return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}

    

	public String getquestionNo(long l) throws Exception
    {
		String column [] = new String[]{KEY_questionNo,KEY_Answer};
 	   
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
	
	
public String getAnswer(long l) throws Exception
    {
		String column [] = new String[]{KEY_questionNo,KEY_Answer};
 	   
 	   Cursor mCursor = ourDatabase.query( DATABASE_TABLE,column, KEY_questionNo + "=" + l, null, null, null, null);
 	   if(mCursor!=null)
 	   {
 		   mCursor.moveToNext();
 		   String temAnswer =mCursor.getString(1);
 		  mCursor.close();
 		   return temAnswer;
 	   }
    
 	return null;
    }

    
}
