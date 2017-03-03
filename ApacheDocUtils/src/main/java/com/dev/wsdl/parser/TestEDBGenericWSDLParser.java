package com.dev.wsdl.parser;

import java.io.File;

import com.dev.wsdl.parser.util.EDBGenericWSDLParser;
import com.dev.wsdl.parser.util.WsdlParserUtils;

public class TestEDBGenericWSDLParser {
	
	public static String outputDir = "outputdata/"; // for demo 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EDBGenericWSDLParser wsdlParser = new EDBGenericWSDLParser();
		
		// check params we need wsdl file location and which api to call as params
		
		if (args.length < 2 ) {
			System.out.println("USAGE : TestEDBGenericWSDLParser <wsdl file location> <1 for csv , 2 for db objects>");
			return;
		}
		
		if (args[0] == null || "".equals(args[0])) {
			System.out.println("WSDL file location missing");
			return;
		}
		
		if (args[1] == null || "".equals(args[1])) {
			System.out.println("Options missing");
			return;
		}
		
		if ("1".equals(args[1])) {
			
			wsdlParser.processWSDLToCSV(args[0]);
			//System.out.println(wsdlParser.getCSVString());
			String fileName = outputDir+System.currentTimeMillis()+"wsdlInfo.csv";
			WsdlParserUtils.writeToFile(wsdlParser.getCSVString(),fileName );
			System.out.println("OUTPUT FILE : " + fileName);
			
			WsdlParserUtils.openFile(new File(fileName));
		} 
		
	}


}
