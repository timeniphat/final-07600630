package com.example.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public final int id;

    @ColumnInfo(name = "dis")
    public final double distance;

    @ColumnInfo(name = "time")
    public final double time;

    @ColumnInfo(name = "count")
    public final double count;

    @ColumnInfo(name = "sumcount")
    public final int resultcount;

    public User(int id, double distance, double time, double count, int resultcount) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.count = count;
        this.resultcount = resultcount;
    }
}
