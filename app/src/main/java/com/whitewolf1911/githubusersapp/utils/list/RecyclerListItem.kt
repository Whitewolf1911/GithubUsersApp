package com.whitewolf1911.githubusersapp.utils.list

interface RecyclerListItem {
    infix fun areItemsTheSame(other: RecyclerListItem): Boolean
    infix fun areContentsTheSame(other: RecyclerListItem): Boolean
}
