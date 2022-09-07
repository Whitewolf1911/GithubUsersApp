package com.whitewolf1911.githubusersapp.users.ui.usecase

import com.whitewolf1911.githubusersapp.users.domain.usecase.GetUsersUseCase
import com.whitewolf1911.githubusersapp.users.ui.mapper.UserListItemMapper
import com.whitewolf1911.githubusersapp.users.ui.mapper.UsersPreviewMapper
import com.whitewolf1911.githubusersapp.users.ui.model.UsersPreview
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
}
