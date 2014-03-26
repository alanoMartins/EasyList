package br.com.fa7.easylist.persistence;

import br.com.fa7.easylist.persistence.table.ClientTable;
import br.com.fa7.easylist.persistence.table.ItemTable;
import br.com.fa7.easylist.persistence.table.ItemWishlistTable;
import br.com.fa7.easylist.persistence.table.WishlistTable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MigrationHelper extends SQLiteOpenHelper {

	private static MigrationHelper sInstance;

	// Database
	private static final String DATABASE_NAME = "easylist.db";
	private static final int DATABASE_VERSION = 1;

	public static MigrationHelper getInstance(Context context) {
		if (sInstance == null) {
			sInstance = new MigrationHelper(context.getApplicationContext());
		}
		return sInstance;
	}

	private MigrationHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(WishlistTable.DATABASE_CREATE);
		database.execSQL(ItemTable.DATABASE_CREATE);
		database.execSQL(ItemWishlistTable.DATABASE_CREATE);
		database.execSQL(ClientTable.DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MigrationHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + WishlistTable.NAME);
		db.execSQL("DROP TABLE IF EXISTS " + ItemTable.NAME);
		db.execSQL("DROP TABLE IF EXISTS " + ItemWishlistTable.NAME);
		db.execSQL("DROP TABLE IF EXISTS " + ClientTable.NAME);
		onCreate(db);
	}

}
