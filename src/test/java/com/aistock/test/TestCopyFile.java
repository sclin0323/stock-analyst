package com.aistock.test;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestCopyFile {

	Logger log = LoggerFactory.getLogger(TestCopyFile.class);

	@Test
	public void test001() throws Exception {
		
		
		File f = new File("C:\\SysJust\\XQLite\\XS\\Print\\個股日線追蹤_1101.TW.log");
		
		log.info("======="+f.getName());
		
		File target = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由多轉空\\001.log");
		
		FileCopyUtils.copy(f, target);
		
	}



	
	
	@Test
	public void test002() throws Exception {

        
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由多轉空\\"));
	
		
	}
	
	



}
