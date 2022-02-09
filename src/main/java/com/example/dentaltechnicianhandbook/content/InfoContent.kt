package com.example.dentaltechnicianhandbook.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dentaltechnicianhandbook.DataModel
import com.example.dentaltechnicianhandbook.R
import com.example.dentaltechnicianhandbook.R.drawable.*
import com.example.dentaltechnicianhandbook.R.string
import com.example.dentaltechnicianhandbook.databinding.FragmentInfoContentBinding

class InfoContent : Fragment() {

    private lateinit var b: FragmentInfoContentBinding
    private val dataModel:DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentInfoContentBinding.inflate(inflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.kind.observe(activity as LifecycleOwner) {
            when(it) {
                getString(string.imp) -> setContent(
                    string.imp1,
                    string.imp2,
                    string.imp3,
                    imp1,
                    imp2,
                    imp3)
                getString(string.cad_cam) -> setContent(
                    string.cad_cam1,
                    string.cad_cam2,
                    string.cad_cam3,
                    cad_cam1,
                    cad_cam2,
                    cad_cam3)
                getString(string.cer_main) ->  setContent(
                    string.cer_main1,
                    string.cer_main2,
                    string.cer_main3,
                    cer_main1,
                    cer_main2,
                    cer_main3)
                getString(string.rem_full) -> setContent(
                    string.rem_full1,
                    string.rem_full2,
                    string.rem_full3,
                    rem_full1,
                    rem_full2,
                    rem_full3)
                getString(string.rem_part) -> setContent(
                    string.rem_part1,
                    string.rem_part2,
                    string.rem_part3,
                    rem_part1,
                    rem_part2,
                    rem_part3)
                getString(string.fix) -> setContent(
                    string.fix1,
                    string.fix2,
                    string.fix3,
                    fix1,
                    fix2,
                    fix3)
                getString(string.cast_main) -> setContent(
                    string.cast_main1,
                    string.cast_main2,
                    string.cast_main3,
                    cast_main1,
                    cast_main2,
                    cast_main3)
                getString(string.material) -> setContent(
                    string.material1,
                    string.material2,
                    string.material3,
                    material1,
                    material2,
                    material3)
            }
        }
        dataModel.steps.observe(activity as LifecycleOwner) {
            when (it) {
                ven -> setContent(
                    string.veneers_steps1,
                    string.veneers_steps2,
                    string.veneers_steps3,
                    ven1,
                    ven2,
                    ven3,
                    ven4,
                    string.veneers_steps4
                )
                acrylic_crown -> setContent(
                    string.acrylic_crown_steps1,
                    string.acrylic_crown_steps2,
                    string.acrylic_crown_steps3,
                    acrylic_crown1,
                    acrylic_crown2,
                    acrylic_crown3,
                    acrylic_crown4,
                    string.acrylic_crown_steps4
                )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InfoContent()
    }

    private fun setContent(str1: Int, str2: Int, str3: Int, im1: Int, im2: Int, im3: Int, im4: Int = 0, str4: Int = 0) = with(b) {
        tv1.text = getString(str1)
        tv2.text = getString(str2)
        tv3.text = getString(str3)
        if (str4 != 0) {
            tv4.visibility = VISIBLE
            tv4.text = getString(str4)
        }
        b.im1.setImageResource(im1)
        b.im2.setImageResource(im2)
        b.im3.setImageResource(im3)
        if (im4 != 0) {
            b.im4.visibility = VISIBLE
            b.im4.setImageResource(im4)
        }
    }
}