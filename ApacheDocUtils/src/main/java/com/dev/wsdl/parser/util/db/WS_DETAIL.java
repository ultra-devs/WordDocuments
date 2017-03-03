package com.dev.wsdl.parser.util.db;

import java.util.LinkedList;
import java.util.List;

public class WS_DETAIL {
	
	private long api_id;
	private String api_name;
	private String api_app_name;
	private String wsdl_name;
	private String api_type;
	
	LinkedList<WS_MSG> msgList = null;

	public long getApi_id() {
		return api_id;
	}

	public void setApi_id(long api_id) {
		this.api_id = api_id;
	}

	public String getApi_name() {
		return api_name;
	}

	public void setApi_name(String api_name) {
		this.api_name = api_name;
	}

	public String getApi_app_name() {
		return api_app_name;
	}

	public void setApi_app_name(String api_app_name) {
		this.api_app_name = api_app_name;
	}

	public String getWsdl_name() {
		return wsdl_name;
	}

	public void setWsdl_name(String wsdl_name) {
		this.wsdl_name = wsdl_name;
	}

	public String getApi_type() {
		return api_type;
	}

	public void setApi_type(String api_type) {
		this.api_type = api_type;
	}

	public LinkedList<WS_MSG> getMsgList() {
		return msgList;
	}

	public void setMsgList(LinkedList<WS_MSG> msgList) {
		this.msgList = msgList;
	}

	
	public String toCSV() {
		return api_id + "," + api_name + "," + api_app_name + "," + api_type;
	}
	
		
}
