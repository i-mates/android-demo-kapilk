package in.imates.databaseop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by root on 19/10/15.
 */
public class Operations {

    public static final String ROWID = "_id";
    public static final String NAME = "person_name";
    public static final String SNAME = "sur_name";

    private static final String DATABASE_NAME = "Firstdb";
    private static final String DATABASE_TABLE = "Firsttable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourdb;

    public String getData() {
        String [] columns = new String[]{ROWID,NAME,SNAME};
        Cursor c = ourdb.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";

        int iRow = c.getColumnIndex(ROWID);
        int iname = c.getColumnIndex(NAME);
        int isname = c.getColumnIndex(SNAME);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRow) + " " + c.getString(iname) + " " + c.getString(isname) + "\n";
        }
        return result;
    }


    private static class DbHelper extends SQLiteOpenHelper{

        public DbHelper(Context context){

            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+DATABASE_TABLE+" (" +
            ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME + " TEXT NOT NULL, " +
            SNAME + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public Operations(Context c){
        ourContext = c;
    }

    public Operations open() throws SQLException{
        ourHelper = new DbHelper(ourContext);
        ourdb = ourHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourHelper.close();
    }

    public long create(String fn, String sn) {
        ContentValues cv = new ContentValues();
        cv.put(NAME,fn);
        cv.put(SNAME, sn);
        return ourdb.insert(DATABASE_TABLE,null,cv);

    }
}
