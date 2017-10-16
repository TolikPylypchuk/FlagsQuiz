package ua.edu.lnu.ami.flagsquiz.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.apache.commons.io.IOUtils;

import ua.edu.lnu.ami.flagsquiz.R;

/**
 * @author Tolik Pylypchuk
 * <p>Overrides the {@link SQLiteOpenHelper} methods.</p>
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "quiz.db";
	private static final int SCHEMA_VERSION = 1;
	
	private Context context;
	
	/**
	 * <p>Initializes a new instance of the {@link DatabaseHelper}.</p>
	 * @param context The context of the database helper
	 */
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
		this.context = context;
	}
	
	/**
	 * <p>Called when the database is created.</p>
	 * @param sqLiteDatabase The database to create
	 */
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		
		try (InputStream inputStream = context.getResources().openRawResource(R.raw.schema)) {
			String queries = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			
			for (String query : queries.split(";")) {
				sqLiteDatabase.execSQL(query);
			}
		} catch (IOException e) {
			// Do nothing
		}
	}
	
	/**
	 * <p>Called when the database is updated.</p>
	 * <p>Not supported.</p>
	 * @param sqLiteDatabase The database to create
	 * @exception RuntimeException thrown unconditionally
	 */
	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
		throw new RuntimeException("Schema upgrading is not supported.");
	}
}
