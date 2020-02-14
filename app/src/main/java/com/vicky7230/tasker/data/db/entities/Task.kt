package com.vicky7230.tasker.data.db.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long,

    @ColumnInfo(name = "task")
    var task: String
)