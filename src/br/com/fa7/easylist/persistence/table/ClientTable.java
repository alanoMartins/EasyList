package br.com.fa7.easylist.persistence.table;

public class ClientTable extends AppTable {
	public static final String NAME = "client";

	public static final String COLUMN_NAME = "name";
	
	public static final String[] ALLCOLUMN = { COLUMN_ID, COLUMN_NAME };

	public static final String DATABASE_CREATE = "create table "
			+ NAME + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME
			+ " text not null" + ");";
	
	
	
}
