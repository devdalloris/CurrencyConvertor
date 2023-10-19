package com.example.currencyconvertor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconvertor.Currency
import com.example.currencyconvertor.databinding.RowItemBinding

class RvCurrencyListAdapter(private val list: List<Currency>) :
    RecyclerView.Adapter<RvCurrencyListAdapter.ViewHolder>() {

    private var listener: OnCurrencyClickedListener? = null

    inner class ViewHolder(private val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(currency: Currency) {
            binding.txtCurrency.text = currency.Ccy
            binding.txtCountryCurrency.text = currency.CcyNm_EN

            binding.root.setOnClickListener {
                listener?.onCurrencyClicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setOnCurrencyClickedListener(listener: OnCurrencyClickedListener) {
        this.listener = listener
    }

    fun interface OnCurrencyClickedListener {
        fun onCurrencyClicked(position: Int)
    }
}