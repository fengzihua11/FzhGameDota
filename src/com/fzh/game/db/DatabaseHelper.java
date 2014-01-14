package com.fzh.game.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper {

	public final static String SD_PATH = android.os.Environment
			.getExternalStorageDirectory().getAbsolutePath();

	private static final String FILE_PATH = SD_PATH + "/fzhdota";

	private static final String DB_PATH = FILE_PATH + "/dota.db";

	private SQLiteDatabase db = null;

	public DatabaseHelper(Context context, int resId) {
		checkAndMakeDir(context, resId);
	}

	/**
	 * make fileDir for data, like databases.
	 */
	public static void checkAndMakeDir(Context context, int resId) {
		File filePath = new File(FILE_PATH);
		if (!filePath.exists())
			filePath.mkdirs();
		File dbFile = new File(DB_PATH);
		if (!dbFile.exists())
			copyDatabase2File(context, resId);
	}

	private static final void copyDatabase2File(Context context, int resId) {
		File dbFile = new File(DB_PATH);
		try {
			if (!dbFile.exists()) {
				InputStream in = context.getResources().openRawResource(resId);
				FileOutputStream fos = new FileOutputStream(dbFile);
				byte[] buffer = new byte[8192];
				int count = 0; // copy english.db file to sdcard
				while ((count = in.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				in.close();
			}
		} catch (Exception e) {

		}
	}

	public void open() {
		if (db == null || !db.isOpen()) {
			db = SQLiteDatabase.openDatabase(DB_PATH, null,
					SQLiteDatabase.OPEN_READWRITE);
		}
	}

	public void close() {
		if (db != null && db.isOpen()) {
			db.close();
		}
	}

	/**
	 * destroy the object.
	 */
	public void destroyHelper() {
		if (db != null) {
			close();
			db = null;
		}
	}

	public Cursor queryHeros(int jiu_id) {
		open();
		String selection = "jiu_id = " + jiu_id;
		String orderBy = "_id asc";
		Cursor cursor = db.query(DatabaseConstant.HeroTBColumns.TB_NAME,
				new String[] { "_id", "name", "ename", "shortname", "charpter", "jiu_id",
				"pic", "description", "kaijie", "jineng", "qz", "zz", "hz", "sy" }, selection, null, null, null,
				orderBy);
		return cursor;
	}

	public Cursor queryHeroById(int pId) {
		open();
		String selection = "p_id = " + pId;
		String orderBy = "seq asc";

		Cursor cursor = db.query(DatabaseConstant.HeroTBColumns.TB_NAME,
				new String[] { "_id", "p_id", "level1", "level2", "level3",
						"level4", "q_style", "q_text", "q_img", "q_audio",
						"qselect", "difficulty", "r_num", "w_num", "paper_id",
						"seq", "score", "comment", "store_mark", "wrong_mark",
						"an_style", "an_sel", "an_text", "an_img",
						"an_analyze", "note" }, selection, null, null, null,
				orderBy);
		return cursor;
	}

	public Cursor queryJiuGuans() {
		open();
		String orderBy = "_id asc";
		Cursor cursor = db.query(DatabaseConstant.JiuGuanTBColumns.TB_NAME,
				new String[] { "_id", "name", "number", "location", "pic" },
				null, null, null, null, orderBy);
		return cursor;
	}

	public Cursor queryJiuGuanById() {
		open();
		String orderBy = "_id asc";
		Cursor cursor = db.query(DatabaseConstant.JiuGuanTBColumns.TB_NAME,
				new String[] { "_id", "name", "number", "location", "pic" },
				null, null, null, null, orderBy);
		return cursor;
	}
}