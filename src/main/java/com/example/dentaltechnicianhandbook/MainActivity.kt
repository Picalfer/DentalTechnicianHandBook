package com.example.dentaltechnicianhandbook

import android.content.Intent
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

    private lateinit var b: ActivityMainBinding
    private var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

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
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.smoothScrollToPosition(0)
        when (item.itemId) {
            R.id.id_fix -> {
                setContent(item.title,
                    R.drawable.header_button_fix,
                    R.array.fix_prosthesis,
                    R.array.fix_prosthesis_content,
                    R.array.fix_prosthesis_image_array)
            }
            R.id.id_main -> {
                setContent(item.title,
                    R.drawable.header_button_home,
                    R.array.prosthesis,
                    R.array.prosthesis_content,
                    R.array.prosthesis_image_array)
            }
            R.id.id_rem_full -> {
                setContent(item.title,
                    R.drawable.header_button_rem,
                    R.array.rem_prosthesis,
                    R.array.rem_prosthesis_content,
                    R.array.rem_prosthesis_image_array)
            }
            R.id.id_rem_part -> {
                setContent(item.title,
                    R.drawable.header_button_rem,
                    R.array.rem_prosthesis,
                    R.array.rem_prosthesis_content,
                    R.array.rem_prosthesis_image_array)
            }
            R.id.id_con -> {
                val i = Intent(this, ContactsActivity::class.java)
                startActivity(i)
            }
        }
        val drawerLayout: DrawerLayout? = findViewById(R.id.drawerLayout)
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setContent(
        title: CharSequence,
        headerButton: Int,
        prosthesis: Int,
        prosthesisContent: Int,
        prosthesisImageArray: Int
    ) {
        val headButton = findViewById<ImageView>(R.id.header_button)
        Toast.makeText(this, "$title", Toast.LENGTH_SHORT).show()
        headButton.setImageResource(headerButton)
        adapter?.updateAdapter(fillArrays(
            resources.getStringArray(prosthesis),
            resources.getStringArray(prosthesisContent),
            getImageId(prosthesisImageArray)))
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