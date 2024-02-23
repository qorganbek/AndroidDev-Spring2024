package com.example.dodo.models

import java.util.UUID

data class PizzaModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val image: String,
    val description: String,
    val price: Int,
)
