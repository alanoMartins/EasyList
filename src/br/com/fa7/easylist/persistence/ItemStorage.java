package br.com.fa7.easylist.persistence;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import br.com.fa7.easylist.models.Item;
import br.com.fa7.easylist.persistence.table.ItemTable;

public class ItemStorage extends AppStorage<Item> {

	public ItemStorage(Context context) {
		super(context);
	}

	public Long save(Item item) {

		open();

		try {
			ContentValues values = new ContentValues();
			values.put(ItemTable.COLUMN_NAME, item.getName());
			values.put(ItemTable.COLUMN_DESCRIPTION, item.getDescription());
			values.put(ItemTable.COLUMN_PRICE, item.getPrice());

			return database.insert(ItemTable.NAME, null, values);
		} finally {
			close();
		}
	}

	public void update(Item item) {
		open();

		try {
			ContentValues values = new ContentValues();
			values.put(ItemTable.COLUMN_NAME, item.getName());
			values.put(ItemTable.COLUMN_DESCRIPTION, item.getDescription());
			values.put(ItemTable.COLUMN_PRICE, item.getPrice());

			database.update(ItemTable.NAME, values, ItemTable.COLUMN_ID	+ " = ?",
					new String[] { String.valueOf(item.getId().toString()) });
		} finally {
			close();
		}
	}
	

	public List<Item> list() {
		return null;
	}

}
