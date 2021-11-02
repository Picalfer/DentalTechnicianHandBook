package com.example.dentaltechnicianhandbook

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (listArray: ArrayList<ListItem>, context: Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val listArrayR = listArray
    private var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private val tvContent = view.findViewById<TextView>(R.id.tv_content)
        private val tvImage = view.findViewById<ImageView>(R.id.tvImage)
        // private val consLayout = view.findViewById<ConstraintLayout>(R.id.itemLayout)


        fun bind(listItem: ListItem, context: Context) {

            tvTitle.text = listItem.titleText
            val textCon = listItem.contentText.substringBefore(".") + "..."
            tvContent.text = textCon
            tvImage.setImageResource(listItem.imageId)


            itemView.setOnClickListener() {
                Toast.makeText(context,"Pressed: ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                Log.i("MyLog","Pressed: ${tvTitle.text}")

                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())
                    putExtra("content", listItem.contentText)
                    putExtra("image", listItem.imageId)
                }
                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }



    override fun getItemCount(): Int { //получаем количество элементов в нашем списке itemов
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR[position]

        holder.bind(listItem, contextR)
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged() // обновляем адатер
    }
}