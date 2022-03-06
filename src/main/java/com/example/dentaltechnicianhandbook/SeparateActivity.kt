package com.example.dentaltechnicianhandbook

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dentaltechnicianhandbook.content.InfoContent
import com.example.dentaltechnicianhandbook.databinding.ActivitySeparateBinding

class SeparateActivity : AppCompatActivity() {

    private lateinit var b: ActivitySeparateBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySeparateBinding.inflate(layoutInflater)
        setContentView(b.root)

        when(intent.getStringExtra("content")) {
            getString(R.string.veneers_classic) -> setContent(
                R.drawable.ven,
                R.string.veneers_classic,
                R.string.veneers_plus,
                R.string.veneers_indication,
                R.string.veneers_materials)
            getString(R.string.acrylic_crown) -> setContent(
                R.drawable.acrylic_crown,
                R.string.acrylic_crown,
                R.string.acrylic_crown_plus,
                R.string.acrylic_crown_indication,
                R.string.acrylic_crown_materials)
            getString(R.string.stamped_crown) -> setContent(
                R.drawable.stamped_crown,
                R.string.stamped_crown,
                R.string.stamped_crown_plus,
                R.string.stamped_crown_indication,
                R.string.stamped_crown_materials)
            getString(R.string.met_cer_crown) -> setContent(
                R.drawable.met_cer_crown,
                R.string.met_cer_crown,
                R.string.met_cer_crown_plus,
                R.string.met_cer_crown_indication,
                R.string.met_cer_crown_materials)
            getString(R.string.zir_crown) -> setContent(
                R.drawable.zir_crown,
                R.string.zir_crown,
                R.string.zir_crown_plus,
                R.string.zir_crown_indication,
                R.string.zir_crown_materials)
            getString(R.string.cer_crown) -> setContent(
                R.drawable.cer_crown,
                R.string.cer_crown,
                R.string.cer_crown_plus,
                R.string.cer_crown_indication,
                R.string.cer_crown_materials)
            getString(R.string.met_acrylic_crown) -> setContent(
                R.drawable.met_acrylic_crown,
                R.string.met_acrylic_crown,
                R.string.met_acrylic_crown_plus,
                R.string.met_acrylic_crown_indication,
                R.string.met_acrylic_crown_materials)
            getString(R.string.cast_crown) -> setContent(
                R.drawable.cast_crown,
                R.string.cast_crown,
                R.string.cast_crown_plus,
                R.string.cast_crown_indication,
                R.string.cast_crown_materials)
            /*
            getString(R.string.acrylic_bridge) -> setContent(
                R.drawable.acrylic_bridge,
                R.string.content_logo_acrylic_bridge,
                R.string.acrylic_bridge_plus)
            getString(R.string.cast_bridge) -> setContent(R.drawable.cast_bridge, R.string.cast_bridge)
            getString(R.string.met_cer_bridge) -> setContent(R.drawable.met_cer_bridge, R.string.met_cer_bridge)
            getString(R.string.cer_bridge) -> setContent(R.drawable.cer_bridge, R.string.cer_bridge)
            getString(R.string.zir_bridge) -> setContent(R.drawable.zir_bridge, R.string.zir_bridge)*/
        }
    }

    fun additionalCont1(view: View) {checkGone(R.id.content_text_add_1)}
    fun additionalCont2(view: View) {checkGone(R.id.content_text_add_2)}
    fun additionalCont3(view: View) {checkGone(R.id.content_text_add_3)}
    fun additionalCont4(view: View) {checkGone(R.id.content_text_add_4)}

    private fun checkGone(layout: Int) {
        val contentTextAdd = findViewById<ConstraintLayout>(layout)
        if (contentTextAdd.visibility == GONE) contentTextAdd.visibility = VISIBLE
        else contentTextAdd.visibility = GONE
    }

    private fun setContent(imContent: Int, logo: Int, plus: Int, indications: Int, materials: Int) {
        b.faceContent.setImageResource(imContent)
        b.contentLogoText.text = getString(logo)
        b.plusMinus.text = getString(plus)
        b.indications.text = getString(indications)
        b.materials.text = getString(materials)
        dataModel.steps.value = imContent
        supportFragmentManager.beginTransaction().replace(R.id.steps, InfoContent.newInstance()).commit()
    }
}