package com.example.dentaltechnicianhandbook.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dentaltechnicianhandbook.DataModel
import com.example.dentaltechnicianhandbook.R
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
                getString(R.string.imp) -> {
                    b.tv1.text = getString(R.string.imp1)
                    b.tv2.text = getString(R.string.imp2)
                    b.tv3.text = getString(R.string.imp3)
                    b.im1.setImageResource(R.drawable.imp1)
                    b.im2.setImageResource(R.drawable.imp2)
                    b.im3.setImageResource(R.drawable.imp3)
                }
                getString(R.string.cad_cam) -> {
                    b.tv1.text = getString(R.string.cad_cam1)
                    b.tv2.text = getString(R.string.cad_cam2)
                    b.tv3.text = getString(R.string.cad_cam3)
                    b.im1.setImageResource(R.drawable.cad_cam1)
                    b.im2.setImageResource(R.drawable.cad_cam2)
                    b.im3.setImageResource(R.drawable.cad_cam3)
                }
                getString(R.string.cer_main) -> {
                    b.tv1.text = getString(R.string.cer_main1)
                    b.tv2.text = getString(R.string.cer_main2)
                    b.tv3.text = getString(R.string.cer_main3)
                    b.im1.setImageResource(R.drawable.cer_main1)
                    b.im2.setImageResource(R.drawable.cer_main2)
                    b.im3.setImageResource(R.drawable.cer_main3)
                }
                getString(R.string.rem_full) -> {
                    b.tv1.text = getString(R.string.rem_full1)
                    b.tv2.text = getString(R.string.rem_full2)
                    b.tv3.text = getString(R.string.rem_full3)
                    b.im1.setImageResource(R.drawable.rem_full1)
                    b.im2.setImageResource(R.drawable.rem_full2)
                    b.im3.setImageResource(R.drawable.rem_full3)
                }
                getString(R.string.rem_part) -> {
                    b.tv1.text = getString(R.string.rem_part1)
                    b.tv2.text = getString(R.string.rem_part2)
                    b.tv3.text = getString(R.string.rem_part3)
                    b.im1.setImageResource(R.drawable.rem_part1)
                    b.im2.setImageResource(R.drawable.rem_part2)
                    b.im3.setImageResource(R.drawable.rem_part3)
                }
                getString(R.string.fix) -> {
                    b.tv1.text = getString(R.string.fix1)
                    b.tv2.text = getString(R.string.fix2)
                    b.tv3.text = getString(R.string.fix3)
                    b.im1.setImageResource(R.drawable.fix1)
                    b.im2.setImageResource(R.drawable.fix2)
                    b.im3.setImageResource(R.drawable.fix3)
                }
                getString(R.string.cast_main) -> {
                    b.tv1.text = getString(R.string.cast_main1)
                    b.tv2.text = getString(R.string.cast_main2)
                    b.tv3.text = getString(R.string.cast_main3)
                    b.im1.setImageResource(R.drawable.cast_main1)
                    b.im2.setImageResource(R.drawable.cast_main2)
                    b.im3.setImageResource(R.drawable.cast_main3)
                }
                getString(R.string.material) -> {
                    b.tv1.text = getString(R.string.material1)
                    b.tv2.text = getString(R.string.material2)
                    b.tv3.text = getString(R.string.material3)
                    b.im1.setImageResource(R.drawable.material1)
                    b.im2.setImageResource(R.drawable.material2)
                    b.im3.setImageResource(R.drawable.material3)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InfoContent()
    }
}