package com.fathan.appbanksampahapi.utils

import androidx.recyclerview.widget.DiffUtil
import com.fathan.appbanksampahapi.data.response.ListBankSampah

class BankSampahDiffCallback(private val mOldUserList: ArrayList<ListBankSampah>, private val mNewUserList: ArrayList<ListBankSampah>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldUserList.size
    }
    override fun getNewListSize(): Int {
        return mNewUserList.size
    }
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldUserList[oldItemPosition].id == mNewUserList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldUserList[oldItemPosition]
        val newEmployee = mNewUserList[newItemPosition]
        return oldEmployee.id == newEmployee.id
    }
}