package com.whitewolf1911.githubusersapp.users.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.whitewolf1911.githubusersapp.users.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_entity")
    fun getUsers(): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT EXISTS(SELECT * FROM user_entity WHERE github_username= :userID)")
    suspend fun checkUserExists(userID: String): Boolean
}
