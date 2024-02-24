package com.example.dodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dodo.databinding.ActivityPizzaDetailBinding
import com.example.dodo.models.PizzaModel

class PizzaDetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPizzaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPizzaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = intent.getSerializableExtra("PIZZA") as PizzaModel
        binding.imageView.setImageResource(pizza.image)
        binding.description.text = pizza.description
        binding.title.text = pizza.title
    }

}