package com.whitewolf1911.githubusersapp.users.ui.usecase

import com.whitewolf1911.githubusersapp.users.domain.usecase.GetUsersUseCase
import com.whitewolf1911.githubusersapp.users.ui.mapper.UserListItemMapper
import com.whitewolf1911.githubusersapp.users.ui.mapper.UsersPreviewMapper
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import com.whitewolf1911.githubusersapp.users.ui.model.UsersPreview
import com.whitewolf1911.githubusersapp.utils.SortUtil
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsersPreviewUseCase @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val userListItemMapper: UserListItemMapper,
    private val usersPreviewMapper: UsersPreviewMapper
) {

    fun getInitialPreview(): UsersPreview = usersPreviewMapper.createInitialPreview()

    suspend fun getUserListItems(): Flow<UsersPreview> {
        return getUsersUseCase.getUsers().map { userDTOList ->
            userDTOList.map {
                userListItemMapper.mapToUserListItem(it)
            }
        }.map { userListItem ->
            usersPreviewMapper.mapToUsersPreview(userListItem)
        }
    }

    suspend fun getUserListItemsSorted(): Flow<UsersPreview> {
        return getUsersUseCase.getUsers().map { userDTOList ->
            userDTOList.map {
                userListItemMapper.mapToUserListItem(it)
            }.sortByName(SortUtil.getAndSetSortType())
        }.map { userListItem ->
            usersPreviewMapper.mapToUsersPreview(userListItem)
        }
    }

    private fun List<UserListItem>.sortByName(ascending: Boolean): List<UserListItem> {
        return if (ascending) {
            sortedBy { it.name.lowercase(Locale.ROOT) }
        } else {
            sortedBy { it.name.lowercase(Locale.ROOT) }.reversed()
        }
    }
}
