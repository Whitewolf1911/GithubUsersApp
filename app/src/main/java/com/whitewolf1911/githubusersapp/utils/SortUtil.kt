package com.whitewolf1911.githubusersapp.utils

class SortUtil {
    companion object {
        private var SORT_TYPE = true

        fun getAndSetSortType(): Boolean {
            return if (SORT_TYPE) {
                SORT_TYPE = false
                SORT_TYPE
            } else {
                SORT_TYPE = true
                SORT_TYPE
            }
        }
    }
}
