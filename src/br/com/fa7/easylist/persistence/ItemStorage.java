package br.com.fa7.easylist.persistence;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

			database.update(ItemTable.NAME, values, ItemTable.COLUMN_ID
					+ " = ?",
					new String[] { String.valueOf(item.getId().toString()) });
		} finally {
			close();
		}
	}

	public void delete(Item item) {
		open();

		try {
			database.delete(ItemTable.NAME, ItemTable.COLUMN_ID + " = ?",
					new String[] { String.valueOf(item.getId().toString()) });
		} finally {
			close();
		}
	}

	public Item find(long id) {
		open();

		try {
			Cursor cursor = database.query(ItemTable.NAME, ItemTable.ALLCOLUMN,
					" id = ?", new String[] { String.valueOf(id) }, null, null,
					null, null);

			if (cursor != null)
				cursor.moveToFirst();

			return cursorToItem(cursor);

		} finally {
			close();
		}
	}

	public List<Item> list() {
		open();

		List<Item> itens = new LinkedList<Item>();

		String query = "SELECT  * FROM " + ItemTable.NAME;

		try {
			Cursor cursor = database.rawQuery(query, null);

			if (cursor.moveToFirst()) {
				do {
					itens.add(cursorToItem(cursor));
				} while (cursor.moveToNext());
			}

			return itens;

		} finally {
			close();
		}
	}

	private Item cursorToItem(Cursor cursor) {
		Item item = new Item(cursor.getString(1), cursor.getString(2),
				cursor.getDouble(3));
		item.setId(cursor.getLong(0));
		return item;
	}

}
