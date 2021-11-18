package com.example.dentaltechnicianhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dentaltechnicianhandbook.databinding.ActivitySeparateBinding
import com.example.dentaltechnicianhandbook.fragments.AcrylicBridgeFragment
import com.example.dentaltechnicianhandbook.fragments.CastBridgeFragment

class SeparateActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeparateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeparateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when(intent.getStringExtra("infoTest")) {
            "Пластмассовый мост" -> {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, AcrylicBridgeFragment()).commit()
            }
            "Литой мост" -> {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, CastBridgeFragment()).commit()
            }
        }
    }

    fun additionalContOne(view: View) {
        // сделать тут вэн чтобы эта функция  работала в люой страничке при вызове
        val contentTextAdd1 = findViewById<ConstraintLayout>(R.id.content_text_add_1)
        if (contentTextAdd1.visibility == GONE) contentTextAdd1.visibility = VISIBLE
        else contentTextAdd1.visibility = GONE
    }

    fun additionalContTwo(view: View) {
        val contentTextAdd2 = findViewById<ConstraintLayout>(R.id.content_text_add_2)
        if (contentTextAdd2.visibility == GONE) contentTextAdd2.visibility = VISIBLE
        else contentTextAdd2.visibility = GONE
    }

    fun additionalContThree(view: View) {
        val contentTextAdd3 = findViewById<ConstraintLayout>(R.id.content_text_add_3)
        if (contentTextAdd3.visibility == GONE) contentTextAdd3.visibility = VISIBLE
        else contentTextAdd3.visibility = GONE
    }

    fun additionalContFour(view: View) {
        val contentTextAdd4 = findViewById<ConstraintLayout>(R.id.content_text_add_4)
        if (contentTextAdd4.visibility == GONE) contentTextAdd4.visibility = VISIBLE
        else contentTextAdd4.visibility = GONE
    }
}