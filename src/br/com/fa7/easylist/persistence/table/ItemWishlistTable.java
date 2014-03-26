package br.com.fa7.easylist.persistence.table;


public class ItemWishlistTable extends AppTable {

	public static final String NAME = "item_wishlist";

	public static final String COLUMN_ITEMWISHLIST_ID = NAME + COLUMN_ID;
	public static final String COLUMN_WISHLIST = WishlistTable.NAME + COLUMN_ID;
	public static final String COLUMN_ITEM = ItemTable.NAME + COLUMN_ID;

	public static final String DATABASE_CREATE = "create table "
			+ NAME + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_WISHLIST
			+ " integer, " + COLUMN_ITEM + " integer" + ");";

}
