package com.techmah.mapandretrofit.adapters

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.adapters.AdapterClickListener
import com.example.myapplication.model.ApiListResponse
import kotlinx.android.synthetic.main.list_item.view.*

class ListViewHolder(
    itemView: View,
    private val listener: AdapterClickListener,
    val context: Context
) : RecyclerView.ViewHolder(itemView) {

    fun bind(apiListResponse: ApiListResponse) {

        itemView.tv_name.text = "Name : " + apiListResponse.owner.login
        itemView.user_lay.setOnClickListener {
            listener.onItemClick(adapterPosition, "")
        }
        itemView.tv_node_id.text = "Node ID : " + apiListResponse.owner.node_id
        itemView.tv_type.text = "Type : " + apiListResponse.owner.type

        itemView.et_comments.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                apiListResponse.owner.comment = itemView.et_comments.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        Glide.with(context).load(apiListResponse.owner.avatar_url).into(itemView.img_avatar);
    }

}