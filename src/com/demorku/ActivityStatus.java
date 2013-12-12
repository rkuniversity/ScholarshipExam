package com.demorku;

import java.util.ArrayList;
import java.util.List;

public class ActivityStatus {
	  private static List<String> activityStatusAry = new ArrayList<String>();
	   
	  public void updateStatusList(String activityName, String activityStatus) {
	    for(int i=0;i<activityStatusAry.size();i++) {
	      if(activityStatusAry.get(i).indexOf(activityName)!=-1) {
	        activityStatusAry.remove(i);
	      }
	    }
	    activityStatusAry.add(activityName + " " + activityStatus);
	  }
	   
	  public String getStatusList() {
	    String statusOutput="";
	    for(int i=0;i<activityStatusAry.size();i++) {
	      statusOutput += activityStatusAry.get(i) +"\r\n";
	    }
	    return statusOutput;
	  }
	}