package max.greg.com.gregsapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    //various constants to be used in creating and updating the database
    static final String KEY_ROWID = "_id";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "SwordOfOrion";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_GAME_MAPS =
            "create table game_maps ("
                    + "save_name text not null, "
                    + "num_stars int not null, num_planets int not null);";

    final Context context;


    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        dbHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        public DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        //onCreate implicitly used to create the database table "contacts"
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                //db.execSQL(CREATE_SAVES);
                db.execSQL(CREATE_GAME_MAPS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //onUpgrade called implicitly when the database "version" has changed
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            //db.execSQL("DROP TABLE IF EXISTS saves");
            db.execSQL("DROP TABLE IF EXISTS game_maps");
            onCreate(db);
        }
    }

    //---opens the database---
    //calls SQLiteOpenHelper.getWritableDatabase() when opening the DB.
    //If the DB does not yet exist it will be created here.
    public DBAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        dbHelper.close();
    }

    //---insert a contact into the database---
    //uses ContentValues class to store key/value pairs for field names and data
    //to be inserted into the DB table by SQLiteDatabase.insert()
    public void saveGame(String saveName, GameMap gameMap)
    {

        ContentValues gameMapValues = new ContentValues();
        gameMapValues.put("save_name", saveName);
        gameMapValues.put("num_stars", gameMap.numStars);
        gameMapValues.put("num_planets", gameMap.totalNumPlanets);
        db.insert("game_maps", null, gameMapValues);

        //ContentValues saveValues = new ContentValues();
        //saveValues.put("save_name", saveName);
        //db.insert("saves", null, saveValues);

        return;
    }

    //---deletes a particular contact---
    //removes from the DB the record specified using SQLiteDatabase.delete()
    public void deleteGame(String saveName)
    {
        db.delete("game_maps", "save_name" + "=" + "'"+saveName+"'", null);
        return;
    }

    //---retrieves all the games---
    //SQLiteDatabase.query builds a SELECT query and returns a "Cursor" over the result set
    public Cursor getAllSaves()
    {
        return db.query("game_maps", new String[] {"save_name", "num_stars", "num_planets"},
                null, null, null, null, null);
    }

    //---retrieves a particular map---
    public Cursor getMap(String saveName) throws SQLException
    {
        Cursor mCursor =
                db.query(true, "game_maps", new String[] {"save_name", "num_stars", "num_planets"},
                        "save_name" + "=" + "'"+saveName+"'", null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact---
    //Uses SQLiteDatabase.update() to change existing data by key/value pairs
    public boolean updateMap(String saveName, GameMap gameMap)
    {
        ContentValues args = new ContentValues();
        args.put("save_name", saveName);
        args.put("num_stars", gameMap.numStars);
        args.put("num_planets", gameMap.totalNumPlanets);
        return db.update("game_maps", args, "save_name" + "=" + "'"+saveName+"'", null) > 0;
    }
}
