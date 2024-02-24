package com.example.dodo.models

interface SelectionItem {
    enum class Type(value: Int) {Pizza(0), Banner(0)}
    val title: String
    val description: String
    val image: Int
    fun getListItem(): Int
}