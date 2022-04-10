package pl.umg.trains.database;

import android.provider.BaseColumns;

public final class PlayerReaderContract {
    private PlayerReaderContract(){}

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlayerEntry.TABLE_NAME + " (" +
                    PlayerEntry._ID + " INTEGER PRIMARY KEY," +
                    PlayerEntry.COLUMN_NAME_NICKNAME + " TEXT,"+
                    PlayerEntry.COLUMN_NAME_MONEY + " INTEGER)";

    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PlayerEntry.TABLE_NAME;
}
