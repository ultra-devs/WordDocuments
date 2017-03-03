package com.dev.wsdl.parser.util.db;

import java.util.LinkedList;

public class WS_MSG {
	
	private long msg_id;
	private String msg_name;
	private String msg_type;
	private long api_id;
	private LinkedList<WS_ELEMENT> elemList;
	
	public long getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}
	public String getMsg_name() {
		return msg_name;
	}
	public void setMsg_name(String msg_name) {
		this.msg_name = msg_name;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public long getApi_id() {
		return api_id;
	}
	public void setApi_id(long api_id) {
		this.api_id = api_id;
	}
	public LinkedList<WS_ELEMENT> getElemList() {
		return elemList;
	}
	public void setElemList(LinkedList<WS_ELEMENT> elemList) {
		this.elemList = elemList;
	}
	
	public String toCSV() {
		return msg_id + "," + msg_name + "," + msg_type;
	}
	
	
}
