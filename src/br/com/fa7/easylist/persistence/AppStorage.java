package br.com.fa7.easylist.persistence;
 
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public abstract class AppStorage<T> {

	protected SQLiteDatabase database;
	private MigrationHelper dbHelper;

	public AppStorage(Context context) {
		dbHelper = MigrationHelper.getInstance(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
}
