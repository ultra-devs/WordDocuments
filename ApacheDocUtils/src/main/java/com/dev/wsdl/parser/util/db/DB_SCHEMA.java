package com.dev.wsdl.parser.util.db;

import java.util.List;

public class DB_SCHEMA {
	
	private long schema_id;
	private String schema_name;
	private long db_instance_id;
	
	List<DB_TABLE> tableList;

	public long getSchema_id() {
		return schema_id;
	}

	public void setSchema_id(long schema_id) {
		this.schema_id = schema_id;
	}

	public String getSchema_name() {
		return schema_name;
	}

	public void setSchema_name(String schema_name) {
		this.schema_name = schema_name;
	}

	public long getDb_instance_id() {
		return db_instance_id;
	}

	public void setDb_instance_id(long db_instance_id) {
		this.db_instance_id = db_instance_id;
	}

	public List<DB_TABLE> getTableList() {
		return tableList;
	}

	public void setTableList(List<DB_TABLE> tableList) {
		this.tableList = tableList;
	}
	
	
	
}
