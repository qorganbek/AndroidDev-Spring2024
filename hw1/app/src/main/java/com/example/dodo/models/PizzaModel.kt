package com.example.dodo.models

import java.io.Serializable
import java.util.UUID

data class PizzaModel(
    val id: String = UUID.randomUUID().toString(),
    override val title: String,
    override val image: Int,
    override val description: String,
    val price: Int,
) : SelectionItem,Serializable {
    override fun getListItem(): Int {
        return SelectionItem.Type.Pizza.ordinal
    }
}
