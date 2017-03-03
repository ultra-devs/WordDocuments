package com.dev.wsdl.parser.util.db;

import java.util.List;

public class DB_INSTANCE {
	
	private long db_instance_id;
	private String db_instance_name;
	private String listner_host;
	private String linster_port;
	
	List<DB_SCHEMA> schemaList;

	public long getDb_instance_id() {
		return db_instance_id;
	}

	public void setDb_instance_id(long db_instance_id) {
		this.db_instance_id = db_instance_id;
	}

	public String getDb_instance_name() {
		return db_instance_name;
	}

	public void setDb_instance_name(String db_instance_name) {
		this.db_instance_name = db_instance_name;
	}

	public String getListner_host() {
		return listner_host;
	}

	public void setListner_host(String listner_host) {
		this.listner_host = listner_host;
	}

	public String getLinster_port() {
		return linster_port;
	}

	public void setLinster_port(String linster_port) {
		this.linster_port = linster_port;
	}

	public List<DB_SCHEMA> getSchemaList() {
		return schemaList;
	}

	public void setSchemaList(List<DB_SCHEMA> schemaList) {
		this.schemaList = schemaList;
	}
	
	
}
