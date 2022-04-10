package pl.umg.trains.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static pl.umg.trains.database.PlayerReaderContract.SQL_CREATE_ENTRIES;
import static pl.umg.trains.database.PlayerReaderContract.SQL_DELETE_ENTRIES;

public class PlayerReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PlayerReader.db";

    public PlayerReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
            onCreate(sqLiteDatabase);
        }
    }
}
