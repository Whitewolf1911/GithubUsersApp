package com.whitewolf1911.githubusersapp.users.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.whitewolf1911.githubusersapp.users.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_entity")
    fun getUsers(): Flow<List<UserEntity>>

}
