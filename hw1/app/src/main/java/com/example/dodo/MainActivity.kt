package com.example.dodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.dodo.databinding.ActivityMainBinding
import com.example.dodo.models.SelectionDataSource
import com.example.dodo.adapter.SectionAdapter
import com.example.dodo.models.PizzaModel

class MainActivity : AppCompatActivity() {
    private val adapter = SectionAdapter()
    private lateinit var binding: ActivityMainBinding
    private val section = SelectionDataSource.sections
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        setupActionButton()
    }
    private fun setupAdapter() {
        adapter.didTapPizza = {
            handlePizzaDidTap(it)
        }

        binding.recyclerView.adapter = adapter
        adapter.setSections(section)
    }

    private fun setupActionButton() {
        binding.actionButton.setOnClickListener {
            handleActionButtonDidTap()
        }
    }

    private fun handlePizzaDidTap(pizza: PizzaModel) {
        val intent = Intent(this, PizzaDetailActivity::class.java)
        intent.putExtra("PIZZA", pizza)
        startActivity(intent)
    }

    private fun handleActionButtonDidTap() {
        val text = binding.editText.text.toString()
        if (text != "") {
            val newSections = section.filter { it.title.lowercase().contains(text.lowercase()) }
            adapter.setSections(ArrayList(newSections))
        } else {
            adapter.setSections(section)
        }
    }
}