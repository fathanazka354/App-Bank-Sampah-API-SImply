package com.fathan.appbanksampahapi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fathan.appbanksampahapi.utils.BankSampahDiffCallback
import com.fathan.appbanksampahapi.data.response.ListBankSampah
import com.fathan.appbanksampahapi.R

class ListBankSampahAdapter: RecyclerView.Adapter<ListBankSampahAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback
    private val list = ArrayList<ListBankSampah>()

    fun setList(users:ArrayList<ListBankSampah>){
        val diffCallback = BankSampahDiffCallback(this.list, users)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(users)
        diffResult.dispatchUpdatesTo(this)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLocation : TextView = itemView.findViewById(R.id.tv_item_description)

        fun bind(list: ListBankSampah){
            with(itemView){
                Log.d("ListBankSampahAdapter", "bind: ${list.name}")
                tvName.text = list.name
                tvLocation.text = list.street
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_bank_sampah,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: ListBankSampah)
    }
}