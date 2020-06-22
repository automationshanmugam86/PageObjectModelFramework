package com.crms.testScripts;

import org.apache.log4j.Logger;

public class logExample {
	
	private static Logger log = Logger.getLogger(logExample.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.info("Message from info");
		log.warn("Message from warn");
		log.error("Message from error");
		log.fatal("Message from fatal");

	}

}
