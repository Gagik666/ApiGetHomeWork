package com.example.apigethomework.SecondTask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.R
import com.squareup.picasso.Picasso

class MonyAdapter(
    private val context: SecondTaskFragment,
    private val userList: MutableList<MyDataItem>
    ): RecyclerView.Adapter<MonyAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvId = itemView.findViewById<TextView>(R.id.tvId)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
        fun bind(myDataItem: MyDataItem) {
            tvId.text = myDataItem.ccy
            tvName.text = myDataItem.buy
            tvEmail.text = myDataItem.sale

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_mony, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size

}