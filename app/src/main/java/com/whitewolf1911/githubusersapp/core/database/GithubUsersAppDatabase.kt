package com.whitewolf1911.githubusersapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.whitewolf1911.githubusersapp.core.database.GithubUsersAppDatabase.Companion.LATEST_DB_VERSION
import com.whitewolf1911.githubusersapp.users.data.dao.UserDao
import com.whitewolf1911.githubusersapp.users.data.model.entity.UserEntity


@Database(
    entities = [UserEntity::class],
    version = LATEST_DB_VERSION,
    exportSchema = false
)
abstract class GithubUsersAppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val LATEST_DB_VERSION = 1

        const val DATABASE_NAME = "GithubUsersAppDatabase"
    }
}
