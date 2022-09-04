package com.whitewolf1911.githubusersapp.users.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.ENTITY_NAME)
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "github_username")
    val githubUsername: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "position")
    val position: String,

    @ColumnInfo(name = "age")
    val age: Int
) {

    companion object {
        const val ENTITY_NAME = "user_entity"
    }
}
