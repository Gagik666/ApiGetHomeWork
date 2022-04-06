package com.example.apigethomework.FirstTask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.R

class UserAdapter(
    private val context: FirstTaskFragment,
    private val userList: MutableList<UserData>
    ): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvId = itemView.findViewById<TextView>(R.id.tvId)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
        fun bind(myDataItem: UserData) {
            tvId.text = myDataItem.id.toString()
            tvName.text = myDataItem.name
            tvEmail.text = myDataItem.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size

}