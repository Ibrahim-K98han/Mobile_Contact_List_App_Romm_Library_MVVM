package com.ibrahim.contactapp

data class ContactDB(
    val id:Long,
    val contactName:String,
    val phone:String,
    val email:String,
    val address:String
)

val contactList = mutableListOf<ContactDB>(
    ContactDB(1,"Ibrahim Khan","01751800957","aitvetibrahim@gmail.com","Jatrabari,Dhaka"),

)
