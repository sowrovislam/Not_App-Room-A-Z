package com.example.not_app

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Note)

    @Delete
    suspend fun delete(note: Note)

    //Reading _mathod
    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>


    @Update
    suspend fun update(note: Note)
}