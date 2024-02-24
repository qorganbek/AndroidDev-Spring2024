package com.example.dodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.models.PizzaModel
import com.example.dodo.models.BannerModel
import com.example.dodo.models.SelectionItem
import com.example.dodo.databinding.ItemPizzaLayoutBinding
import com.example.dodo.databinding.ItemBannerLayoutBinding

class SelectionAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var didTapPizza: (PizzaModel) -> Unit

    private val selection: ArrayList<SelectionItem> = ArrayList()

    fun setSelections(newList: ArrayList<SelectionItem>){
        selection.clear()
        selection.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            SelectionItem.Type.Pizza.ordinal -> {
                return PizzaViewHolder(
                    ItemPizzaLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            SelectionItem.Type.Banner.ordinal -> {
                return BannerViewHolder(
                    ItemBannerLayoutBinding.inflate(
                        android.view.LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return PizzaViewHolder(
                    ItemPizzaLayoutBinding.inflate(
                        android.view.LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return selection[position].getListItem()
    }

    override fun getItemCount(): Int {
        return selection.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemPizzaLayoutBinding -> holder.bind(selection[position] as PizzaModel)
            is ItemBannerLayoutBinding -> holder.bind(selection[position] as BannerModel)
        }
    }

    inner class BannerViewHolder(
        private val binding: ItemBannerLayoutBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(banner: BannerModel){
            with(binding){
                bannerImage.setImageResource(banner.image)
                bannerDescription.text = banner.description
                bannerTitle.text =  banner.title
            }
        }
    }

    inner class PizzaViewHolder(
        private val binding: ItemPizzaLayoutBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(pizza: PizzaModel){
            with(binding){
                pizzaImage.setImageResource(pizza.image)
                pizzaTitle.text = pizza.title
                pizzaDescription.text = pizza.description
                pizzaPrice.text = pizza.price

                root.setOnClickListener(
                    didTapPizza(pizza)
                )
            }
        }
    }

}