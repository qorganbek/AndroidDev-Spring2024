package com.example.dodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.models.PizzaModel
import com.example.dodo.models.BannerModel
import com.example.dodo.models.SelectionItem
import com.example.dodo.databinding.ItemPizzaLayoutBinding
import com.example.dodo.databinding.ItemBannerLayoutBinding

class SectionAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var didTapPizza: (PizzaModel) -> Unit

    private val section: ArrayList<SelectionItem> = ArrayList()

    fun setSections(newList: ArrayList<SelectionItem>){
        section.clear()
        section.addAll(newList)
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
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return PizzaViewHolder(
                    ItemPizzaLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return section[position].getListItem()
    }

    override fun getItemCount(): Int {
        return section.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PizzaViewHolder -> holder.bind(section[position] as PizzaModel)
            is BannerViewHolder -> holder.bind(section[position] as BannerModel)
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
                pizzaPrice.text = "${pizza.price} T"

                root.setOnClickListener {
                    didTapPizza(pizza)
                }
            }
        }
    }

}