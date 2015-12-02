package in.imates.authentication_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by root on 27/11/15.
 */
public class Operations {

    public static final String ROWID = "_id";
    public static final String NAME = "name";
    public static final String CONTACT = "contact";
    public static final String ENCR1 = "encr1";
    public static final String ENCR2 = "encr2";

    private static final String DATABASE_NAME = "auth_database";
    private static final String DATABASE_TABLE = "authan_table";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourdb;

    public String getencr2(int l) {
        String[] columns = new String[]{ROWID, NAME, CONTACT, ENCR1, ENCR2};
        Cursor c = ourdb.query(DATABASE_TABLE, columns, ROWID + "=" + l, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            String encr2 = c.getString(4);
            Log.e("Strint 2", encr2);
            return encr2;
        }

        return null;
    }


    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            NAME + " TEXT NOT NULL, " +
                            CONTACT + " TEXT NOT NULL, " +
                            ENCR1 + " TEXT NOT NULL, " +
                            ENCR2 + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public Operations(Context c) {
        ourContext = c;
    }

    public Operations open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourdb = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long create(String fn, String cn, String enc1, String enc2) {
        ourdb.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        ourHelper.onCreate(ourdb);
        ContentValues cv = new ContentValues();
        cv.put(NAME, fn);
        cv.put(CONTACT, cn);
        cv.put(ENCR1, enc1);
        cv.put(ENCR2, enc2);
        return ourdb.insert(DATABASE_TABLE, null, cv);

    }
}
