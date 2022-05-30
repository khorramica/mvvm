package ir.finto.mvvmproject.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Information.class, version = 1)
public abstract class InformationDB extends RoomDatabase {

    public static InformationDao informationDao;
    public static InformationDB informationDB;

    public static InformationDB GetInstance(Context context) {
        if (informationDB == null)
            informationDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    InformationDB.class,
                    "Information_DB"
            ).build();

        return informationDB;
    }
}
