package vincent.ultimategymapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vincent on 2016-09-05.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bduga";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase database;
    private static DatabaseHelper helper;


    public DatabaseHelper(Context context) {
        super(
                context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION
        );

        database = getWritableDatabase();
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (helper == null) {
            helper = new DatabaseHelper(context);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (database == null)
            database = db;

        db.execSQL(DatabaseModel.Program.CREATE_TABLE);
        db.execSQL(DatabaseModel.Jour.CREATE_TABLE);
        db.execSQL(DatabaseModel.Jour_Program.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseModel.Program.DROP_TABLE);
        db.execSQL(DatabaseModel.Jour.DROP_TABLE);
        db.execSQL(DatabaseModel.Jour_Program.DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseModel.Program.DROP_TABLE);
        db.execSQL(DatabaseModel.Jour.DROP_TABLE);
        db.execSQL(DatabaseModel.Jour_Program.DROP_TABLE);
        onCreate(db);
    }
}
