package com.ibrahim.contactapp.daos

import androidx.room.*
import com.ibrahim.contactapp.ContactDB

@Dao
interface ContactDao {

    @Insert
    fun addSchedule(contactDB: ContactDB)

    @Update
    fun updateSchedule(contactDB: ContactDB)

    @Delete
    fun deleteSchedule(contactDB: ContactDB)

    @Query("select * from contact")
    fun getAllSchedules():List<ContactDB>

}