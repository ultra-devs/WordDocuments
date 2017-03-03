package com.dev.wsdl.parser.util.db;

public class WS_ELEMENT {
	
	private long ws_element_id;
	private String element_name;
	private String element_type;
	private String element_data_type;
	private Long parent_element_id = 0L;
	private String cardinality;
	private long ws_msg_id;
	
	
	public long getWs_element_id() {
		return ws_element_id;
	}
	public void setWs_element_id(long ws_element_id) {
		this.ws_element_id = ws_element_id;
	}
	public String getElement_name() {
		return element_name;
	}
	public void setElement_name(String element_name) {
		this.element_name = element_name;
	}
	public String getElement_type() {
		return element_type;
	}
	public void setElement_type(String element_type) {
		this.element_type = element_type;
	}
	public String getElement_data_type() {
		return element_data_type;
	}
	public void setElement_data_type(String element_data_type) {
		this.element_data_type = element_data_type;
	}
	public Long getParent_element_id() {
		return parent_element_id;
	}
	public void setParent_element_id(Long parent_element_id) {
		this.parent_element_id = parent_element_id;
	}
	public String getCardinality() {
		return cardinality;
	}
	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}
	public long getWs_msg_id() {
		return ws_msg_id;
	}
	public void setWs_msg_id(long ws_msg_id) {
		this.ws_msg_id = ws_msg_id;
	}
	
	public String toCSV() {
		return ws_element_id + ","
				+ element_name + "," + element_type
				+ "," + element_data_type
				+ "," + parent_element_id + ","
				+ cardinality ;
	}
	
	
	
	
}
