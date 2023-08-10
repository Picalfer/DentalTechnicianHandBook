package com.example.dentaltechnicianhandbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dentaltechnicianhandbook.model.ListItem

class MyAdapter(listArray: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val listArrayR = listArray
    private var contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private val tvContent = view.findViewById<TextView>(R.id.tv_content)
        private val tvImage = view.findViewById<ImageView>(R.id.tvImage)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            val textCon = listItem.contentText.substringBefore(".") + "..."
            tvContent.text = textCon
            tvImage.setImageResource(listItem.imageId)
            itemView.setOnClickListener {
                Toast.makeText(context, "Выбрано: ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra(Constants.TITLE, tvTitle.text.toString())
                    putExtra(Constants.CONTENT, listItem.contentText)
                    putExtra(Constants.IMAGE, listItem.imageId)
                }
                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = listArrayR.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR[position]
        holder.bind(listItem, contextR)
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}