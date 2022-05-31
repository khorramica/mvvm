package ir.finto.mvvmproject.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Information")
public class Information {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    public Information(@NonNull String id,@NonNull String username) {
        this.id = id;
        this.username = username;
    }

    public Information() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
