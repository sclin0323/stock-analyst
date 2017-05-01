package com.aistock.analyst.status;

import java.util.ArrayList;
import java.util.List;

public class StockStatus {

	public final static String DIF_STATUSA = "DIF持續走多";
	public final static String DIF_STATUSB = "DIF由多轉空";
	public final static String DIF_STATUSC = "DIF持續走空";
	public final static String DIF_STATUSD = "DIF由空轉多";

	public final static String MONTH_STATUSA = "月上季上";
	public final static String MONTH_STATUSB = "月下季上";
	public final static String MONTH_STATUSC = "月下季下";
	public final static String MONTH_STATUSD = "月上季下";
	
	// 台灣50權重股
	public final static ArrayList<String> WEIGHT_LIST = new ArrayList<String>() {
		{
			add("1101");
			add("1102");
			add("1216");
			add("1301");
			add("1303");
			add("1326");
			add("1402");
			add("1476");
			add("2002");
			add("2105");
			add("2207");
			add("2301");
			add("2303");
			add("2308");
			add("2311");
			add("2317");
			add("2324");
			add("2325");
			add("2330");
			add("2354");
			add("2357");
			add("2382");
			add("2395");
			add("2408");
			add("2409");
			add("2412");
			add("2454");
			add("2474");
			add("2801");
			add("2823");
			add("2880");
			add("2881");
			add("2882");
			add("2883");
			add("2884");
			add("2885");
			add("2886");
			add("2887");
			add("2890");
			add("2891");
			add("2892");
			add("2912");
			add("3008");
			add("3045");
			add("3481");
			add("4904");
			add("4938");
			add("5880");
			add("6505");
			add("9904");
		}
	};

}