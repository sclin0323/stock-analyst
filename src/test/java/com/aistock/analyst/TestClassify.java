package com.aistock.analyst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestClassify {
	
	Logger log = LoggerFactory.getLogger(TestClassify.class);

	
	@Test
	public void classify() throws Exception {
		
		File folder = new File("/Users/a8303/Downloads/20170422/");
		
		for (final File file : folder.listFiles()) {
			
			log.info(file.getName());
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			 String line = null;
			 while ((line = br.readLine()) != null) {
			      
				 log.info(line);

			 }
			 
			 break;
			
		}
		
		log.info("done!!");
		
		
		
		
    }
	
	
}
