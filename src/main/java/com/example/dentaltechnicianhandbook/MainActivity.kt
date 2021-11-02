package com.example.dentaltechnicianhandbook

import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private var adapter: MyAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView = findViewById<NavigationView>(R.id.nav_view)

        val header: View = navView.getHeaderView(0)
        header.setBackgroundColor(Color.parseColor("#6F279C"))

        navView.setBackgroundResource(R.drawable.item_gradient_animation)
        val frameAnimation = navView.background as AnimationDrawable
        frameAnimation.setEnterFadeDuration(10)
        frameAnimation.setExitFadeDuration(5000)
        frameAnimation.start()

        navView.setNavigationItemSelectedListener (this)

        val rcView = findViewById<RecyclerView>(R.id.rcView)

        val list = ArrayList<ListItem>()


        list.addAll(fillArrays(resources.getStringArray(R.array.prosthesis),
                               resources.getStringArray(R.array.prosthesis_content),
                               getImageId(R.array.prosthesis_image_array)))

        /*list.add(ListItem(R.drawable.imp, "Всё о имплантах", "Зубной имплантат — искусственно изготовленная, чаще всего многокомпонентная конструкция, используемая для внедрения в костную ткань челюсти с последующим сращением с целью протезирования."))
        list.add(ListItem(R.drawable.rem, "Всё о съёмных протезах", "Съемное протезирование – консервативный метод восстановления утраченных зубов. Съемный – означает, что пациент может самостоятельно снять конструкцию."))
        list.add(ListItem(R.drawable.cla, "Всё о бюгельных протезах", "Бюгельный протез — условно-съёмный протез, который восстанавливает жевательную функцию, при этом давление распределяется между оставшимися зубами и слизистой оболочкой с подлежащей костной тканью беззубых участков альвеолярного отростка."))
        list.add(ListItem(R.drawable.fix, "Всё о несъемных протезах", "Это понятие подразумевает восстановление дефектов зубного ряда (отсутствующих или сломанных зубов) конструкциями, которые крепятся на естественные зубы или имплантанты."))*/

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list,this)
        rcView.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when(item.itemId) {
            R.id.id_cer -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.prosthesis),
                    resources.getStringArray(R.array.prosthesis_content),
                    getImageId(R.array.prosthesis_image_array)))
            }
            R.id.id_rem -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.rem_prosthesis),
                    resources.getStringArray(R.array.rem_prosthesis_content),
                    getImageId(R.array.rem_prosthesis_image_array)))
            }
            R.id.id_fix -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fix_prosthesis),
                    resources.getStringArray(R.array.fix_prosthesis_content),
                    getImageId(R.array.fix_prosthesis_image_array)))
            }
            R.id.id_cla -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")

            }
            R.id.id_con -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")

            }
            R.id.id_th -> {
                Toast.makeText(this,"${item.title}",Toast.LENGTH_SHORT).show()
                Log.i("MyLog","${item.title}")

            }

        }
        val drawerLayout: DrawerLayout? = findViewById(R.id.drawerLayout)
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    private fun getImageId(imageArrayId: Int): IntArray {   // function for decode images id
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

    private fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            val listItem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }


}