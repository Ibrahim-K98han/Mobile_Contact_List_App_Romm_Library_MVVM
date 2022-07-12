package com.ibrahim.contactapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactDB(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = "contact_name")
    val contactName:String,
    val phone:String,
    val email:String,
    val address:String
)

val contactList = mutableListOf<ContactDB>()
