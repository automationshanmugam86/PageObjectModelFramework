package com.crms.testScripts;


import org.apache.log4j.Logger;


public class loggerExample {
	
	  static Logger logger = Logger.getLogger(loggerExample.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Message from Info");
		logger.warn("Message from Warn");
		logger.error("Message from error");
		logger.fatal("Message from fatal");
		logger.debug("Message from debug");
		

	}

}
