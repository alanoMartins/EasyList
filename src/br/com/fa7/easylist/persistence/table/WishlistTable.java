package br.com.fa7.easylist.persistence.table;

public class WishlistTable extends AppTable {

	public static final String NAME = "wishlist";
	
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_TOTAL = "total";
	
	public static final String DATABASE_CREATE = "create table "
			+ NAME + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME
			+ " text not null, " + COLUMN_DESCRIPTION + " text, "
			+ COLUMN_TOTAL + " decimal" + ");";
	
	public static final String[] ALLCOLUMN ={ COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_TOTAL };
	
}
