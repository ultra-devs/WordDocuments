package com.dev.wsdl.parser.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import com.dev.wsdl.parser.util.db.WS_DETAIL;
import com.dev.wsdl.parser.util.db.WS_ELEMENT;
import com.dev.wsdl.parser.util.db.WS_MSG;

public class WsdlParserUtils {
	
	public static void openFile(File file) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	
public static String printAPIList(List apiList){
		
		if (apiList == null ) {
			 return "";
		}
		StringBuffer sb = new StringBuffer("");
		System.out.println("-------------------------");
		sb.append("API_ID,API_NAME,API_APP_NAME,API_TYPE,MSG_ID,MSG_NAME,MSG_TYPE,WS_ELEMENT_ID,ELEMENT_NAME,ELEMENT_TYPE,ELEMET_DATA_TYPE,PARET_ELEM_ID,CARDINALITY").append("\n");
		for (int i = 0; i < apiList.size(); i++) {
			
			WS_DETAIL wsDetail = (WS_DETAIL)apiList.get(i);
			
			if (wsDetail != null) {
				
				LinkedList<WS_MSG> msgList = wsDetail.getMsgList();
				
				if (msgList != null) {
					
					for (int j = 0; j < msgList.size(); j++) {
						WS_MSG wsMsg = (WS_MSG)msgList.get(j);
						
						if (wsMsg != null) {
							
							LinkedList<WS_ELEMENT> elemList = wsMsg.getElemList();
							
							if (elemList != null) {
								
								for (int k = 0; k < elemList.size(); k++) {
									WS_ELEMENT elem = elemList.get(k);
									
									sb.append(wsDetail.toCSV()+","+wsMsg.toCSV()+","+elem.toCSV()).append("\n");
								}
								
							}
						}
					}
				}
			}
			
		}
		
		System.out.println("-------------------------");
		
		return sb.toString();
	}


public static void writeToFile(String str, String file) {
	PrintStream out;
	try {
		try {
			out = new PrintStream(new FileOutputStream(file, true));
			out.print(str);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println(file + " Not Found");
			e.printStackTrace();
		}
	} catch (Exception e) {
		System.out.println("Exception Occured...");
		e.printStackTrace();
	}

}


}
