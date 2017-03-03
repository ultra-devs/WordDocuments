package com.dev.wsdl.parser.util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ow2.easywsdl.schema.api.Element;
import org.ow2.easywsdl.wsdl.WSDLFactory;
import org.ow2.easywsdl.wsdl.api.BindingOperation;
import org.ow2.easywsdl.wsdl.api.Description;
import org.ow2.easywsdl.wsdl.api.Endpoint;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.ow2.easywsdl.wsdl.api.Part;
import org.ow2.easywsdl.wsdl.api.Service;
import org.ow2.easywsdl.wsdl.api.WSDLReader;



public class EDBGenericWSDLParser {
	
	// TODO : remove the sops and unwanted code , this code requires refactoring
	public static final String WS_REQ_COMMON_HEADER_ELEM_NAME = "WSHeader";
	public static final String WS_RES_COMMON_HEADER_ELEM_NAME = "WSResponseHeader";
	
	// list for db object for prased wsdl
	private ArrayList apiList = new ArrayList(); // do we need to initialize it as of now ?
	int apiSeq = 1000;
	int msgSeq = 2000;
	int elemSeq = 3000;
	
	
	// for wsdl metadata to csv
	private StringBuffer csvSB = new StringBuffer("");
	
	public String getCSVString(){
		return this.csvSB.toString();
	}
	
	
	public List getDBObjectsList() {
		return this.apiList;
	}
	
	
	public void processWSDLToCSV(String wsdlFileLocation){
		try {
			
			WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
			Description desc = reader.read(new File(wsdlFileLocation).toURL());
			System.out.println(desc.getTargetNamespace());
			// get service
			Service service = desc.getServices().get(0);
			csvSB.append("Operation Name,Message Name, Element Name,DIR,Element DataType, Occurances").append("\n");
			// List endpoints
			List<Endpoint> endpoints = service.getEndpoints(); 

			for (Iterator iterator = endpoints.iterator(); iterator.hasNext();) {
				Endpoint endpoint = (Endpoint) iterator.next();
				
				System.out.println("Endpoint Name : " +endpoint.getName() );
				System.out.println("Service Name : " + service.getQName().getLocalPart());
				
				List<BindingOperation> opList = endpoint.getBinding().getBindingOperations();
				
				
				
				for (Iterator iterator2 = opList.iterator(); iterator2
						.hasNext();) {
					
					BindingOperation bindingOperation = (BindingOperation) iterator2
							.next();
					System.out.println("===============================");
					Operation operation = bindingOperation.getOperation();
					System.out.println("	Operation Name : "+ operation.getQName().getLocalPart());
					System.out.println("           Input Msg :" + operation.getInput().getMessageName().getLocalPart());
					System.out.println("           Output Msg :" + operation.getOutput().getMessageName().getLocalPart());
					csvSB.append(operation.getQName().getLocalPart()+",,,,").append("\n");
					List<Part> parts = operation.getInput().getParts();
					csvSB.append(","+operation.getInput().getMessageName().getLocalPart()+",IN,,").append("\n");
					
					for (Iterator iteratorInParts = parts.iterator(); iteratorInParts.hasNext();) {
						Part part = (Part) iteratorInParts.next();
						//System.out.println(part.getElement().getType().getClass());
						if (part.getElement().getType() instanceof org.ow2.easywsdl.schema.impl.ComplexTypeImpl) {
							//traverseComplexType(part.getElement(), "IN");
							traverseComplexTypeSkipCommonHeaderForCSV(part.getElement(), "IN" );
							} 
					}
					
					List<Part> partsOut = operation.getOutput().getParts();
					csvSB.append(","+operation.getOutput().getMessageName().getLocalPart()+",OUT,,").append("\n");
					for (Iterator iteratorOutParts = partsOut.iterator(); iteratorOutParts.hasNext();) {
						Part part = (Part) iteratorOutParts.next();
						//System.out.println(part.getElement().getType().getClass());
						if (part.getElement().getType() instanceof org.ow2.easywsdl.schema.impl.ComplexTypeImpl) {
							traverseComplexTypeSkipCommonHeaderForCSV(part.getElement(), "OUT");
						} 
					}
					
					
				}
				
			}
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public void traverseComplexTypeSkipCommonHeaderForCSV( org.ow2.easywsdl.schema.api.Element elem , String dir){
		//System.out.println(dir+" complex element Name : " +elem.getQName().getLocalPart());
		if (WS_REQ_COMMON_HEADER_ELEM_NAME.equalsIgnoreCase(elem.getQName().getLocalPart()) ||
				WS_RES_COMMON_HEADER_ELEM_NAME.equalsIgnoreCase(elem.getQName().getLocalPart())) {
			System.out.println("Skipping " + elem.getQName().getLocalPart());
			return;
		}
		org.ow2.easywsdl.schema.impl.ComplexTypeImpl ct_inner = (org.ow2.easywsdl.schema.impl.ComplexTypeImpl)elem.getType();
		//System.out.println(ct_inner);
		List<Element> elem_inner = ct_inner.getSequence().getElements();
		
		
		
		for (Iterator iterator4 = elem_inner
				.iterator(); iterator4.hasNext();) {
			Element element2 = (Element) iterator4.next();
			//System.out.println( element2.getQName().getLocalPart() + " == "+element2.getType().getClass());
			
			// occurance 
			String occurances = element2.getMinOccurs() +":"+element2.getMaxOccurs();
			
			if (element2.getType() instanceof org.ow2.easywsdl.schema.impl.SimpleTypeImpl) {
				org.ow2.easywsdl.schema.impl.SimpleTypeImpl simpleT = (org.ow2.easywsdl.schema.impl.SimpleTypeImpl) element2.getType();
				
				//csvSB.append(",,"+cleanParentElementQName(elem.getQName().toString())+"."+ element2.getQName().getLocalPart()+","+dir+","+simpleT.getRestriction().getBase().getLocalPart()+","+occurances).append("\n");
				if (simpleT.getQName() != null && simpleT.getQName().getLocalPart() != null) {
					csvSB.append(",,"+cleanParentElementQName(elem.getQName().toString())+"."+ element2.getQName().getLocalPart()+","+dir+","+simpleT.getQName().getLocalPart()+","+occurances).append("\n");
				} else {
					csvSB.append(",,"+cleanParentElementQName(elem.getQName().toString())+"."+ element2.getQName().getLocalPart()+","+dir+","+simpleT.getRestriction().getBase().getLocalPart()+","+occurances).append("\n");
				}
				
			} else {
				csvSB.append(",,"+cleanParentElementQName(elem.getQName().toString())+"."+ element2.getQName().getLocalPart()+","+dir+",ComplexType"+","+occurances).append("\n");
			}
			
			
			if (element2.getType() instanceof org.ow2.easywsdl.schema.impl.ComplexTypeImpl) {
				traverseComplexTypeSkipCommonHeaderForCSV(element2 , dir );
			} else if( element2.getType() instanceof org.ow2.easywsdl.schema.impl.SimpleTypeImpl ) {
				//System.out.println(traverseSimpleType( element2 , dir  ));;
				
			}
		}
	}
	
	
	
	
	
	
	public String cleanParentElementQName(String parentElemQNameString){
		
		if (parentElemQNameString == null || "".equals(parentElemQNameString)) {
			return "";
		}

		int lastIndex =  parentElemQNameString.lastIndexOf("}");
		
		if (lastIndex > 0) {
			return parentElemQNameString.substring(lastIndex+1, parentElemQNameString.length());
		}
		
		return parentElemQNameString;
	}
	
	
	
	
}