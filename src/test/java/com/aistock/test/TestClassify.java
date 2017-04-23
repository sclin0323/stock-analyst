package com.aistock.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestClassify {

	Logger log = LoggerFactory.getLogger(TestClassify.class);

	@Test
	public void test001() throws Exception{
		
		classify("20170421");
		
	}
	
	public void classify(String date) throws Exception {
		
		// 刪除相關目錄
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF持續走多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由多轉空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由空轉多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF持續走空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_不知\\"));
		
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF持續走多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF由多轉空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF由空轉多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF持續走空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_不知\\"));
		
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF持續走多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF由多轉空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF由空轉多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF持續走空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_不知\\"));
		
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF持續走多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF由多轉空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF由空轉多\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF持續走空\\"));
		FileUtils.deleteDirectory(new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_不知\\"));

		// 1. 月上季上
		// 2. 月上季下
		// 3. 月下季上
		// 4. 月下季下

		// 1. DIF持續走多
		// 2. DIF由多轉空
		// 3. DIF持續走空
		// 4. DIF由空轉多
		// 5. 不知

		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");

		ArrayList<File> A = new ArrayList<File>();
		ArrayList<File> B = new ArrayList<File>();
		ArrayList<File> C = new ArrayList<File>();
		ArrayList<File> D = new ArrayList<File>();
		ArrayList<File> E = new ArrayList<File>();

		ArrayList<File> F = new ArrayList<File>();
		ArrayList<File> G = new ArrayList<File>();
		ArrayList<File> H = new ArrayList<File>();
		ArrayList<File> I = new ArrayList<File>();
		ArrayList<File> J = new ArrayList<File>();

		ArrayList<File> K = new ArrayList<File>();
		ArrayList<File> L = new ArrayList<File>();
		ArrayList<File> M = new ArrayList<File>();
		ArrayList<File> N = new ArrayList<File>();
		ArrayList<File> O = new ArrayList<File>();

		ArrayList<File> P = new ArrayList<File>();
		ArrayList<File> Q = new ArrayList<File>();
		ArrayList<File> R = new ArrayList<File>();
		ArrayList<File> S = new ArrayList<File>();
		ArrayList<File> T = new ArrayList<File>();

		for (final File file : folder.listFiles()) {

			log.info(file.getName());

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));

			String lastline = null;

			String line;
			while ((line = br.readLine()) != null) {
				lastline = line;
				if(lastline.contains(date)) break;
			}

			lastline = lastline.replaceAll("\\s+", "");
			String[] strArray = lastline.split(":");
			
			// 過濾量能 < 500
			int volume = (int)(Float.parseFloat(strArray[4]));
			if(volume < 500) continue;
			

			if ("月上季上(多)_DIF持續走多".equals(strArray[2])) {
				A.add(file);
			} else if ("月上季上(多)_DIF由多轉空".equals(strArray[2])) {
				B.add(file);
			} else if ("月上季上(多)_DIF由空轉多".equals(strArray[2])) {
				C.add(file);
			} else if ("月上季上(多)_DIF持續走空".equals(strArray[2])) {
				D.add(file);
			} else if ("月上季上(多)_不知".equals(strArray[2])) {
				E.add(file);
			}

			if ("月上季下(長空短多)_DIF持續走多".equals(strArray[2])) {
				F.add(file);
			} else if ("月上季下(長空短多)_DIF由多轉空".equals(strArray[2])) {
				G.add(file);
			} else if ("月上季下(長空短多)_DIF由空轉多".equals(strArray[2])) {
				H.add(file);
			} else if ("月上季下(長空短多)_DIF持續走空".equals(strArray[2])) {
				I.add(file);
			} else if ("月上季下(長空短多)_不知".equals(strArray[2])) {
				J.add(file);
			}

			if ("月下季上(長多短空)_DIF持續走多".equals(strArray[2])) {
				K.add(file);
			} else if ("月下季上(長多短空)_DIF由多轉空".equals(strArray[2])) {
				L.add(file);
			} else if ("月下季上(長多短空)_DIF由空轉多".equals(strArray[2])) {
				M.add(file);
			} else if ("月下季上(長多短空)_DIF持續走空".equals(strArray[2])) {
				N.add(file);
			} else if ("月下季上(長多短空)_不知".equals(strArray[2])) {
				O.add(file);
			}

			if ("月下季下(空)_DIF持續走多".equals(strArray[2])) {
				P.add(file);
			} else if ("月下季下(空)_DIF由多轉空".equals(strArray[2])) {
				Q.add(file);
			} else if ("月下季下(空)_DIF由空轉多".equals(strArray[2])) {
				R.add(file);
			} else if ("月下季下(空)_DIF持續走空".equals(strArray[2])) {
				S.add(file);
			} else if ("月下季下(空)_不知".equals(strArray[2])) {
				T.add(file);
			}
		}
		

		
		log.info("月上季上(多)_DIF持續走多: "+A.size());
		log.info("月上季上(多)_DIF由多轉空: "+B.size());
		log.info("月上季上(多)_DIF由空轉多: "+C.size());
		log.info("月上季上(多)_DIF持續走空: "+D.size());
		log.info("月上季上(多)_不知: "+E.size());
		
		log.info("月上季下(長空短多)_DIF持續走多: "+F.size());
		log.info("月上季下(長空短多)_DIF由多轉空: "+G.size());
		log.info("月上季下(長空短多)_DIF由空轉多: "+H.size());
		log.info("月上季下(長空短多)_DIF持續走空: "+I.size());
		log.info("月上季下(長空短多)_不知: "+J.size());
		
		log.info("月下季上(長多短空)_DIF持續走多: "+K.size());
		log.info("月下季上(長多短空)_DIF由多轉空: "+L.size());
		log.info("月下季上(長多短空)_DIF由空轉多: "+M.size());
		log.info("月下季上(長多短空)_DIF持續走空: "+N.size());
		log.info("月下季上(長多短空)_不知: "+O.size());
		
		log.info("月下季下(空)_DIF持續走多: "+P.size());
		log.info("月下季下(空)_DIF由多轉空: "+Q.size());
		log.info("月下季下(空)_DIF由空轉多: "+R.size());
		log.info("月下季下(空)_DIF持續走空: "+S.size());
		log.info("月下季下(空)_不知: "+T.size());
		
		
		// 建立相關目錄
		
		File f1 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF持續走多\\");
		File f2 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由多轉空");
		File f3 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF由空轉多");
		File f4 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_DIF持續走空");
		File f5 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季上(多)_不知");
		
		f1.mkdir();
		f2.mkdir();
		f3.mkdir();
		f4.mkdir();
		f5.mkdir();
		
		importFiles(f1,A);
		importFiles(f2,B);
		importFiles(f3,C);
		importFiles(f4,D);
		importFiles(f5,E);
	
		File f6 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF持續走多");
		File f7 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF由多轉空");
		File f8 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF由空轉多");
		File f9 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_DIF持續走空");
		File f10 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月上季下(長空短多)_不知");
		
		f6.mkdir();
		f7.mkdir();
		f8.mkdir();
		f9.mkdir();
		f10.mkdir();
		
		importFiles(f6,F);
		importFiles(f7,G);
		importFiles(f8,H);
		importFiles(f9,I);
		importFiles(f10,J);
	
		File f11 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF持續走多");
		File f12 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF由多轉空");
		File f13 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF由空轉多");
		File f14 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_DIF持續走空");
		File f15 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季上(長多短空)_不知");
		
		f11.mkdir();
		f12.mkdir();
		f13.mkdir();
		f14.mkdir();
		f15.mkdir();
		
		importFiles(f11,K);
		importFiles(f12,K);
		importFiles(f13,M);
		importFiles(f14,N);
		importFiles(f15,O);
		
		File f16 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF持續走多");
		File f17 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF由多轉空");
		File f18 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF由空轉多");
		File f19 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_DIF持續走空");
		File f20 = new File("C:\\SysJust\\XQLite\\XS\\Print\\月下季下(空)_不知");
		
		f16.mkdir();
		f17.mkdir();
		f18.mkdir();
		f19.mkdir();
		f20.mkdir();
		
		importFiles(f16,P);
		importFiles(f17,Q);
		importFiles(f18,R);
		importFiles(f19,S);
		importFiles(f20,T);
		

		log.info("done!!");

	}

	private void importFiles(File folder, ArrayList<File> files) {
		
		for(File f : files) {
			try {
				FileUtils.copyFileToDirectory(f, folder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	



}
