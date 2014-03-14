package com.brp.utility;

import java.io.File;


public enum Constants {
	SUCCESS,FAILURE,SERVER_PATH,IMAGE_DISP_PATH;
	
	
  public String toString(){
	  switch (this) {
		case SUCCESS:
			return "success";
		case FAILURE:
			return "failure";
		case SERVER_PATH:	
			return System.getProperty("catalina.base") + File.separator+"spimages"+File.separator;
		case IMAGE_DISP_PATH:
			return "http://127.0.0.1:8080/spimages"+File.separator;
		default:
			break;
	  }
	  return "nothing";
  }
  
}
