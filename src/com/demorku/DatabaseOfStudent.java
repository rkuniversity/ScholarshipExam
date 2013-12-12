package com.demorku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseOfStudent
{
	
	public static int  KEY_ROWID;
    public static final String  KEY_NameOfCandidate       = "NameOfCandidate";
    public static final String  KEY_residentialaddress    = "student_residentialaddress";
    public static final String  KEY_City			        = "student_City";
    public static final String  KEY_District			       = "student_District";
    public static final String  KEY_pincode			        = "student_Pincode";
    public static final String  KEY_EmailId                = "student_EmailId";
    public static final String  KEY_studentMono            = "student_studentMono";
    public static final String  KEY_fathermobbileNo		   ="student_fathermobbileNo";
    public static final String  KEY_Schoolname              ="student_Schoolname";
    public static final String  KEY_groupofStudent         = "student_groupofStudent";
    public static final String  KEY_mediumOfStudent        = "student_mediumOfStudent";
    public static final String  KEY_Marks			        = "student_marks";
    int temp;
    
    public static final String DATABASE_NAME       = "StudentDatabase";
    public static final String DATABASE_TABLE      = "Student_Information";
    public static final int    DATABASE_VERSION    = 1;

    private DbHelper            ourHelper;
    private final Context       ourContext;
    private SQLiteDatabase      ourDatabase;

 
    public DatabaseOfStudent(Context c)
    {
        ourContext = c;
    }

    public DatabaseOfStudent open() throws SQLException
    {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        ourHelper.close();
        
    }

	public long createEntry(String nameOfCandidate, String residentialAddress,String City,String District,String pincode,
			String emailId, String studentMobileNo, String parentMobileNo,
			String nameOfSchool,String groupofStudent,String mediumOfStudent) {
		
		 ContentValues cv = new ContentValues();
	        
	        cv.put(KEY_NameOfCandidate,nameOfCandidate);
	        cv.put(KEY_residentialaddress,residentialAddress);
	        cv.put(KEY_City,City);
	        cv.put(KEY_District,District);
	        cv.put(KEY_pincode,pincode);
	        cv.put(KEY_EmailId,emailId);
	        cv.put(KEY_studentMono,studentMobileNo);
	        cv.put(KEY_fathermobbileNo,parentMobileNo);
	        cv.put(KEY_Schoolname,nameOfSchool);
	        cv.put(KEY_groupofStudent,groupofStudent);
	        cv.put(KEY_mediumOfStudent,mediumOfStudent);
	       
	   return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
	public String getlastId()
	{
		String lastId  ;
		String query = "SELECT id from Student_Information order by id DESC limit 1";
		Cursor c = ourDatabase.rawQuery(query, null);
		if (c != null && c.moveToFirst()) 
		{
		   lastId =  c.getString(0); 
		   //The 0 is the column index, we only have 1 column, so the index is 0
		   c.close();
		   return lastId;
		}
		return null;
	
	}
	public String getlastGroup()
	{
		String lastId;
		String query = "SELECT student_groupofStudent from Student_Information  ";
		Cursor c = ourDatabase.rawQuery(query, null);
		if (c != null && c.moveToLast()) 
		{
		   lastId =  c.getString(0); 
		   //The 0 is the column index, we only have 1 column, so the index is 0
		   c.close();
		   return lastId;
		}
		return null;
	
	}

	 public  long setMark(String totalAnsInString, String i)
     {
		  temp =Integer.parseInt(i);
		
     	ContentValues cv = new ContentValues();
     	cv.put(KEY_Marks, totalAnsInString);
     //	ourDatabase = ourHelper.getWritableDatabase();
     	// Toast.makeText(ourContext, ""+temp, Toast.LENGTH_SHORT).show();
     	return  ourDatabase.update(DATABASE_TABLE, cv, "id "+"="+temp,null);
    		
     	
     }
	 public void deleteTable()
	    {
	    	//ourDatabase.delete(DATABASE_TABLE, null, null);
	    	ourDatabase.execSQL("Drop table 'Student_Information'; ");
	    }
  }
class DbHelper extends SQLiteOpenHelper
{

    public DbHelper(Context context)
    {
        super(context, DatabaseOfStudent.DATABASE_NAME, null, DatabaseOfStudent.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
    	  db.execSQL("CREATE TABLE IF NOT EXISTS " +  TempDatabase.DATABASE_TABLE + " ("+TempDatabase.KEY_questionNo + " INTEGER, " +
          		TempDatabase.KEY_ImageNO + " TEXT , " + 
          		TempDatabase.KEY_ANSWER   + " TEXT );" );
        db.execSQL("CREATE TABLE IF NOT EXISTS " +   DatabaseOfStudent.DATABASE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		 DatabaseOfStudent.KEY_NameOfCandidate + " TEXT , " + 
        		 DatabaseOfStudent.KEY_residentialaddress	 + " TEXT , " + 
        		 DatabaseOfStudent.KEY_City	 + " TEXT , " + 
        		 DatabaseOfStudent.KEY_District	 + " TEXT , " + 
        		 DatabaseOfStudent.KEY_pincode	 + " TEXT , " + 
        		 DatabaseOfStudent.KEY_EmailId  + " TEXT , " + 
        		 DatabaseOfStudent.KEY_studentMono  + " TEXT, " + 
        		 DatabaseOfStudent.KEY_fathermobbileNo        + " TEXT , " +
        		 DatabaseOfStudent.KEY_Schoolname     + " TEXT ," +
        		 DatabaseOfStudent.KEY_groupofStudent         + " TEXT  ," +
        		 DatabaseOfStudent.KEY_mediumOfStudent         + " TEXT  ," +
        		 DatabaseOfStudent.KEY_Marks         + " FLOAT  );" );

      
        												
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    	
    	
        db.execSQL("DROP TABLE IF EXITS " +  DatabaseOfStudent.DATABASE_TABLE);
       
        onCreate(db);
    }
   
}

