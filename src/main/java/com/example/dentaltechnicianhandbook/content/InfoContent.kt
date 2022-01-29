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
                getString(R.string.imp) -> { setContent(
                    R.string.imp1,
                    R.string.imp2,
                    R.string.imp3,
                    R.drawable.imp1,
                    R.drawable.imp2,
                    R.drawable.imp3)
                }
                getString(R.string.cad_cam) -> { setContent(
                    R.string.cad_cam1,
                    R.string.cad_cam2,
                    R.string.cad_cam3,
                    R.drawable.cad_cam1,
                    R.drawable.cad_cam2,
                    R.drawable.cad_cam3)
                }
                getString(R.string.cer_main) -> { setContent(
                    R.string.cer_main1,
                    R.string.cer_main2,
                    R.string.cer_main3,
                    R.drawable.cer_main1,
                    R.drawable.cer_main2,
                    R.drawable.cer_main3)
                }
                getString(R.string.rem_full) -> { setContent(
                    R.string.rem_full1,
                    R.string.rem_full2,
                    R.string.rem_full3,
                    R.drawable.rem_full1,
                    R.drawable.rem_full2,
                    R.drawable.rem_full3)
                }
                getString(R.string.rem_part) -> {setContent(
                    R.string.rem_part1,
                    R.string.rem_part2,
                    R.string.rem_part3,
                    R.drawable.rem_part1,
                    R.drawable.rem_part2,
                    R.drawable.rem_part3)
                }
                getString(R.string.fix) -> { setContent(
                    R.string.fix1,
                    R.string.fix2,
                    R.string.fix3,
                    R.drawable.fix1,
                    R.drawable.fix2,
                    R.drawable.fix3)
                }
                getString(R.string.cast_main) -> { setContent(
                    R.string.cast_main1,
                    R.string.cast_main2,
                    R.string.cast_main3,
                    R.drawable.cast_main1,
                    R.drawable.cast_main2,
                    R.drawable.cast_main3)
                }
                getString(R.string.material) -> { setContent(
                    R.string.material1,
                    R.string.material2,
                    R.string.material3,
                    R.drawable.material1,
                    R.drawable.material2,
                    R.drawable.material3)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InfoContent()
    }

    private fun setContent(string1: Int, string2: Int, string3: Int, image1: Int, image2: Int, image3: Int,) {
        b.tv1.text = getString(string1)
        b.tv2.text = getString(string2)
        b.tv3.text = getString(string3)
        b.im1.setImageResource(image1)
        b.im2.setImageResource(image2)
        b.im3.setImageResource(image3)
    }
}