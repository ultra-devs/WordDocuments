package com.dev.wsdl.parser.util.db;

import java.util.List;

public class DB_TABLE {
	
	private long db_table_id;
	private String table_name;
	private long schema_id;
	
	List<DB_COLUMNS> colList;

	public long getDb_table_id() {
		return db_table_id;
	}

	public void setDb_table_id(long db_table_id) {
		this.db_table_id = db_table_id;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public long getSchema_id() {
		return schema_id;
	}

	public void setSchema_id(long schema_id) {
		this.schema_id = schema_id;
	}

	public List<DB_COLUMNS> getColList() {
		return colList;
	}

	public void setColList(List<DB_COLUMNS> colList) {
		this.colList = colList;
	}
	
	
}
