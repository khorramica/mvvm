package ir.finto.mvvmproject.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InformationDao {

    @Query("SELECT * FROM Information")
    LiveData<List<Information>> getAll();

    @Query("SELECT * FROM information WHERE id =:info_id")
    LiveData<Information> GetByID(String info_id);

    @Insert
    void Insert(Information information);

    @Update
    void Update(Information information);

    @Delete
    int Delete(Information information);
}
