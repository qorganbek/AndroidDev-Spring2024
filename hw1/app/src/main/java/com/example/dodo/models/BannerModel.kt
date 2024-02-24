package com.example.dodo.models

import java.util.UUID

data class BannerModel(
    val id: String = UUID.randomUUID().toString(),
    override val title: String,
    override val description: String,
    override val image: Int, ): SelectionItem {
    override fun getListItem(): Int {
        return SelectionItem.Type.Banner.ordinal
    }
}
