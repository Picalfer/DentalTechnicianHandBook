package com.example.dentaltechnicianhandbook

import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dentaltechnicianhandbook.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = findViewById<NavigationView>(R.id.nav_view)

        val header: View = navView.getHeaderView(0)
        header.setBackgroundColor(Color.parseColor("#6F279C"))

        navView.setBackgroundResource(R.drawable.item_gradient_animation)
        val frameAnimation = navView.background as AnimationDrawable
        frameAnimation.setEnterFadeDuration(10)
        frameAnimation.setExitFadeDuration(5000)
        frameAnimation.start()

        navView.setNavigationItemSelectedListener(this)

        val rcView = findViewById<RecyclerView>(R.id.rcView)

        val headButton = findViewById<ImageView>(R.id.header_button)
        headButton.setImageResource(R.drawable.header_button_home)

        val list = ArrayList<ListItem>()
        list.addAll(fillArrays(resources.getStringArray(R.array.prosthesis),
            resources.getStringArray(R.array.prosthesis_content),
            getImageId(R.array.prosthesis_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val headButton = findViewById<ImageView>(R.id.header_button)
        val rcView = findViewById<RecyclerView>(R.id.rcView)

        when (item.itemId) {
            R.id.id_main -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                headButton.setImageResource(R.drawable.header_button_home)
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.prosthesis),
                    resources.getStringArray(R.array.prosthesis_content),
                    getImageId(R.array.prosthesis_image_array)))
            }
            R.id.id_rem_full -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                headButton.setImageResource(R.drawable.header_button_rem)
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.rem_prosthesis),
                    resources.getStringArray(R.array.rem_prosthesis_content),
                    getImageId(R.array.rem_prosthesis_image_array)))
            }
                R.id.id_rem_part -> {
                    Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                    headButton.setImageResource(R.drawable.header_button_rem)
                    adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.rem_prosthesis),
                        resources.getStringArray(R.array.rem_prosthesis_content),
                        getImageId(R.array.rem_prosthesis_image_array)))
            }
            R.id.id_fix -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                headButton.setImageResource(R.drawable.header_button_fix)
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fix_prosthesis),
                    resources.getStringArray(R.array.fix_prosthesis_content),
                    getImageId(R.array.fix_prosthesis_image_array)))
            }
            /*
            R.id.id_con -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
            }
            R.id.id_th -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
            }*/
        }
        rcView.smoothScrollToPosition(0)
        val drawerLayout: DrawerLayout? = findViewById(R.id.drawerLayout)
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    private fun getImageId(imageArrayId: Int): IntArray {   // function for decode images id
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

    private fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray,
    ): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            val listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
}