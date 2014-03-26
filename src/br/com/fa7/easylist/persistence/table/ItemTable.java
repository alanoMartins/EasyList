package br.com.fa7.easylist.persistence.table;

public class ItemTable extends AppTable {

	public static final String NAME = "item";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_PRICE = "price";

	public static final String DATABASE_CREATE = "create table "
			+ NAME + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME
			+ " text not null, " + COLUMN_DESCRIPTION + " text, "
			+ COLUMN_PRICE + " decimal" + ");";
}
