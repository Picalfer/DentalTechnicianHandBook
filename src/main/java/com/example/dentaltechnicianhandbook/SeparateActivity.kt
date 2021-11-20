package com.example.dentaltechnicianhandbook

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dentaltechnicianhandbook.databinding.ActivitySeparateBinding

class SeparateActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeparateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeparateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when(intent.getStringExtra("infoTest")) {
            getString(R.string.acrylic_bridge) -> {
                /*supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, AcrylicBridgeFragment()).commit()*/
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.acrylic_bridge)
                binding.contentLogoText.text = getString(R.string.content_logo_acrylic_bridge)
            }
            getString(R.string.cast_bridge) -> {
                /*supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, CastBridgeFragment()).commit()*/
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.cast_bridge)
                binding.contentLogoText.text = getString(R.string.cast_bridge)
            }
            getString(R.string.met_cer_bridge) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.met_cer_bridge)
                binding.contentLogoText.text = getString(R.string.met_cer_bridge)
            }
            getString(R.string.cer_bridge) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.cer_bridge)
                binding.contentLogoText.text = getString(R.string.cer_bridge)
            }
            getString(R.string.zir_bridge) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.zir_bridge)
                binding.contentLogoText.text = getString(R.string.zir_bridge)
            }
            getString(R.string.cast_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.cast_crown)
                binding.contentLogoText.text = getString(R.string.cast_crown)
            }
            getString(R.string.acrylic_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.acrylic_crown)
                binding.contentLogoText.text = getString(R.string.acrylic_crown)
            }
            getString(R.string.met_cer_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.met_cer_crown)
                binding.contentLogoText.text = getString(R.string.met_cer_crown)
            }
            getString(R.string.zir_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.zir_crown)
                binding.contentLogoText.text = getString(R.string.zir_crown)
            }
            getString(R.string.cer_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.cer_crown)
                binding.contentLogoText.text = getString(R.string.cer_crown)
            }
            getString(R.string.met_acrylic_crown) -> {
                binding.contentImageAcrylicBridge.setImageResource(R.drawable.met_acrylic_crown)
                binding.contentLogoText.text = getString(R.string.met_acrylic_crown)
            }
        }
    }

    fun additionalContOne(view: View) {
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