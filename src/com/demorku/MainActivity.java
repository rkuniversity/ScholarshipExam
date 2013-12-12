package com.demorku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;



import readQuestion.GetData;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;



public class MainActivity extends Activity {
 
 private String LOG_TAG = "ReadExcelFromUrl";
 ArrayList<GetData> QuestionList;    

 String questionNo,Answer;
 
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.xcelsheet);
  
 
  //URL path for the Excel file
  
  SharedPreferences setting = getSharedPreferences("Pref", 0);
  String imported= setting.getString("imported", "");
 if(!imported.equals("Yes"))
 {
 InputStream file;
try {
	
	AssetManager assetManager = getAssets();
	file= assetManager.open("question_sheet.xls");
	
	/*File sdcard = Environment.getExternalStorageDirectory();

	//Get the text file
	File file1 = new File(sdcard,"question_sheet.xls");
	file = new FileInputStream (file1);*/
	parseExcel(file);
	displayCart();
	Toast.makeText(this, "Imported", Toast.LENGTH_SHORT).show();
	SharedPreferences writer = getSharedPreferences("Pref", 0);
	SharedPreferences.Editor editor = writer.edit();
	editor.putString("imported", "Yes");
	editor.commit();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 } 
else
{
	  Toast.makeText(this, "Already Imported", Toast.LENGTH_SHORT).show(); 
}
 
 }
  
 private void displayCart() {
 
  //Array list of countries
//  List<String> myList = new ArrayList<String>();
  for(int i = 0;  i <QuestionList.size(); i++){
   GetData getDatafromXcel = QuestionList.get(i);
   questionNo = getDatafromXcel.getquestion_number(); 
   Answer= getDatafromXcel.getanswer();
     QuestionDatabase  mQuestionDatabase = new QuestionDatabase(MainActivity.this);
     mQuestionDatabase.open();
     mQuestionDatabase.createEntry(questionNo,Answer);
     mQuestionDatabase.close(); 

   // myList.add(myData);
  }
   
  //Display the Excel data in a ListView
//  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//    R.layout.data_list, myList);
//  ListView listView = (ListView) findViewById(R.id.listView1);
//  listView.setAdapter(dataAdapter);
   
   
 }
 

 
   
   
 
  private void parseExcel(InputStream fis){
 
   QuestionList = new ArrayList<GetData>();    
 
   try{
 
    // Create a workbook using the Input Stream 
    HSSFWorkbook myWorkBook = new HSSFWorkbook(fis);
  
    // Get the first sheet from workbook 
    HSSFSheet mySheet = myWorkBook.getSheetAt(0);
 
    // We now need something to iterate through the cells
    Iterator<org.apache.poi.ss.usermodel.Row> rowIter = mySheet.rowIterator();
    while(rowIter.hasNext()){
 
     HSSFRow myRow = (HSSFRow) rowIter.next();
     // Skip the first 1 rows
     if(myRow.getRowNum() < 1) {
      continue;
     }
      
     GetData getData = new GetData();
 
     Iterator<Cell> cellIter = myRow.cellIterator();
     while(cellIter.hasNext()){
 
      HSSFCell myCell = (HSSFCell) cellIter.next();
      String cellValue = "";
       
      // Check for cell Type
      if(myCell.getCellType() == HSSFCell.CELL_TYPE_STRING){
       cellValue = myCell.getStringCellValue();
      }
      else {
       cellValue = String.valueOf(myCell.getNumericCellValue());
      }
       
      // Just some log information
      Log.v(LOG_TAG, cellValue);
       
      // Push the parsed data in the Java Object
      // Check for cell index
      switch (myCell.getColumnIndex()) {
      case 0: 
       getData.setquestion_number(cellValue);
       break;
     case 1: 
       getData.setanswer(cellValue);
       break;
      default: 
       break;
      }
       
     }
 
     // Add object to list
     QuestionList.add(getData);
   }
   }
   catch (Exception e){
    e.printStackTrace(); 
   }
 
  }
 
 }
