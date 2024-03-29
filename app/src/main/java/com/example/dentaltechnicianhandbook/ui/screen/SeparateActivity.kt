package com.example.dentaltechnicianhandbook.ui.screen

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dentaltechnicianhandbook.Constants
import com.example.dentaltechnicianhandbook.R
import com.example.dentaltechnicianhandbook.data.DataModel
import com.example.dentaltechnicianhandbook.databinding.ActivitySeparateBinding

class SeparateActivity : AppCompatActivity() {

    private lateinit var b: ActivitySeparateBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySeparateBinding.inflate(layoutInflater).also { setContentView(it.root) }

        when (intent.getStringExtra(Constants.CONTENT)) {
            getString(R.string.veneers_classic) -> setContent(
                R.drawable.ven,
                R.string.veneers_classic,
                R.string.veneers_plus,
                R.string.veneers_indication,
                R.string.veneers_materials
            )

            getString(R.string.acrylic_crown) -> setContent(
                R.drawable.acrylic_crown,
                R.string.acrylic_crown,
                R.string.acrylic_crown_plus,
                R.string.acrylic_crown_indication,
                R.string.acrylic_crown_materials
            )

            getString(R.string.stamped_crown) -> setContent(
                R.drawable.stamped_crown,
                R.string.stamped_crown,
                R.string.stamped_crown_plus,
                R.string.stamped_crown_indication,
                R.string.stamped_crown_materials
            )

            getString(R.string.met_cer_crown) -> setContent(
                R.drawable.met_cer_crown,
                R.string.met_cer_crown,
                R.string.met_cer_crown_plus,
                R.string.met_cer_crown_indication,
                R.string.met_cer_crown_materials
            )

            getString(R.string.zir_crown) -> setContent(
                R.drawable.zir_crown,
                R.string.zir_crown,
                R.string.zir_crown_plus,
                R.string.zir_crown_indication,
                R.string.zir_crown_materials
            )

            getString(R.string.cer_crown) -> setContent(
                R.drawable.cer_crown,
                R.string.cer_crown,
                R.string.cer_crown_plus,
                R.string.cer_crown_indication,
                R.string.cer_crown_materials
            )

            getString(R.string.met_acrylic_crown) -> setContent(
                R.drawable.met_acrylic_crown,
                R.string.met_acrylic_crown,
                R.string.met_acrylic_crown_plus,
                R.string.met_acrylic_crown_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.cast_crown) -> setContent(
                R.drawable.cast_crown,
                R.string.cast_crown,
                R.string.cast_crown_plus,
                R.string.cast_crown_indication,
                R.string.cast_crown_materials
            )

            getString(R.string.acrylic_bridge) -> setContent(
                R.drawable.acrylic_bridge,
                R.string.content_logo_acrylic_bridge,
                R.string.acrylic_crown_plus,
                R.string.acrylic_crown_indication,
                R.string.acrylic_crown_materials
            )

            getString(R.string.stamp_met_bridge) -> setContent(
                R.drawable.stamp_met_bridge,
                R.string.stamp_met_bridge,
                R.string.stamp_met_bridge_plus,
                R.string.stamp_met_bridge_indication,
                R.string.stamp_met_bridge_materials
            )

            getString(R.string.cast_bridge) -> setContent(
                R.drawable.cast_bridge,
                R.string.cast_bridge,
                R.string.cast_crown_plus,
                R.string.cast_bridge_indication,
                R.string.cast_crown_materials
            )

            getString(R.string.met_acrylic_bridge) -> setContent(
                R.drawable.met_acrylic_bridge,
                R.string.met_acrylic_bridge,
                R.string.met_acrylic_crown_plus,
                R.string.met_acrylic_bridge_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.cer_bridge) -> setContent(
                R.drawable.cer_bridge,
                R.string.cer_bridge,
                R.string.cer_crown_plus,
                R.string.cast_bridge_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.met_cer_bridge) -> setContent(
                R.drawable.met_cer_bridge,
                R.string.met_cer_bridge,
                R.string.met_cer_crown_plus,
                R.string.met_cer_crown_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.zir_bridge) -> setContent(
                R.drawable.zir_bridge,
                R.string.zir_bridge,
                R.string.zir_crown_plus,
                R.string.zir_crown_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.tabs) -> setContent(
                R.drawable.tab,
                R.string.incl,
                R.string.tab_plus,
                R.string.tab_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.e_max_man) -> setContent(
                R.drawable.inl,
                R.string.e_max_man,
                R.string.e_max_plus,
                R.string.e_max_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.whole) -> setContent(
                R.drawable.rem_full1,
                R.string.whole,
                R.string.rem_full_plus,
                R.string.rem_full_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.rem_on_imp) -> setContent(
                R.drawable.rem_on_imp,
                R.string.rem_on_imp,
                R.string.rem_on_imp_plus,
                R.string.rem_on_imp_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.rem_on_imp_stick) -> setContent(
                R.drawable.rem_on_stick,
                R.string.rem_on_imp_stick,
                R.string.rem_on_stick_plus,
                R.string.rem_on_imp_indication,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.clam) -> setContent(
                R.drawable.cla,
                R.string.clam,
                R.string.cla_general_plus,
                R.string.clam_indications,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.attach) -> setContent(
                R.drawable.attach,
                R.string.attach,
                R.string.cla_general_plus,
                R.string.attach_indications,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.teles) -> setContent(
                R.drawable.teles,
                R.string.teles,
                R.string.cla_general_plus,
                R.string.teles_indications,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.quat) -> setContent(
                R.drawable.qua,
                R.string.quat,
                R.string.quad_plus,
                R.string.quad_indications,
                R.string.met_acrylic_crown_materials
            )

            getString(R.string.part_rem_cla) -> setContent(
                R.drawable.ic_part_rem,
                R.string.part_rem_cla,
                R.string.rem_part2,
                R.string.part_rem_cla_indications,
                R.string.met_acrylic_crown_materials
            )
        }
    }

    fun additionalCont1(view: View) {
        checkGone(R.id.content_text_add_1)
    }

    fun additionalCont2(view: View) {
        checkGone(R.id.content_text_add_2)
    }

    fun additionalCont3(view: View) {
        checkGone(R.id.content_text_add_3)
    }

    fun additionalCont4(view: View) {
        checkGone(R.id.content_text_add_4)
    }

    private fun checkGone(layout: Int) {
        val contentTextAdd = findViewById<ConstraintLayout>(layout)
        if (contentTextAdd.visibility == GONE) contentTextAdd.visibility = VISIBLE
        else contentTextAdd.visibility = GONE
    }

    private fun setContent(imContent: Int, logo: Int, plus: Int, ind: Int, mat: Int) {
        with(b) {
            faceContent.setImageResource(imContent)
            contentLogoText.text = getString(logo)
            plusMinus.text = getString(plus)
            indications.text = getString(ind)
            materials.text = getString(mat)
        }
        dataModel.steps.value = imContent
        supportFragmentManager.beginTransaction().replace(R.id.steps, InfoFragment.newInstance())
            .commit()
    }
}