package com.example.dentaltechnicianhandbook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dentaltechnicianhandbook.content.InfoContent
import com.example.dentaltechnicianhandbook.databinding.ContentItemBinding

class ContentActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var b: ContentItemBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ContentItemBinding.inflate(layoutInflater)
        setContentView(b.root)

        with(b) {
            tvTitleContent2.text = intent.getStringExtra("title")
            tvContent.text = intent.getStringExtra("content")
            imageContent2.setImageResource(intent.getIntExtra("image", R.drawable.rem))
        }

        /*with(b) { // узнать как отметить класс ContentActivity вместо слова this и с коратить тем самым код и не писать б
            tvContent1.setOnClickListener()
            tvContent2.setOnClickListener(this)
        }*/

        with(b) {
            tvContent1.setOnClickListener(this@ContentActivity)
            tvContent2.setOnClickListener(this@ContentActivity)
            tvContent3.setOnClickListener(this@ContentActivity)
            tvContent4.setOnClickListener(this@ContentActivity)
            tvContent5.setOnClickListener(this@ContentActivity)
            tvContent6.setOnClickListener(this@ContentActivity)
            tvContent6.setOnClickListener(this@ContentActivity)
            tvContent7.setOnClickListener(this@ContentActivity)
        }

            /* Главная */
        when (intent.getStringExtra("title")) {
            getString(R.string.imp) -> setContentOn(R.id.information, R.string.imp)
            getString(R.string.cad_cam) -> setContentOn(R.id.information, R.string.cad_cam)
            getString(R.string.cer_main) -> setContentOn(R.id.information, R.string.cer_main)
            getString(R.string.rem_full) -> setContentOn(R.id.information, R.string.rem_full)
            getString(R.string.rem_part) -> setContentOn(R.id.information, R.string.rem_part)
            getString(R.string.fix) -> setContentOn(R.id.information, R.string.fix)
            getString(R.string.cast_main) -> setContentOn(R.id.information, R.string.cast_main)
            getString(R.string.material) -> setContentOn(R.id.information, R.string.material)
            /* Несъёмные */
            getString(R.string.veneers_lumineers) -> {
                b.tvContent1.text = getString(R.string.veneers_classic)
                hide(6)
            }
            getString(R.string.crowns) -> {
                with(b) {
                    tvContent1.text = getString(R.string.acrylic_crown)
                    tvContent2.text = getString(R.string.stamped_crown)
                    tvContent3.text = getString(R.string.met_cer_crown)
                    tvContent4.text = getString(R.string.zir_crown)
                    tvContent6.text = getString(R.string.met_acrylic_crown)
                    tvContent5.text = getString(R.string.cer_crown)
                    tvContent7.text = getString(R.string.cast_crown)
                }
            }
            getString(R.string.bridges) -> {
                with(b) {
                    tvContent1.text = getString(R.string.acrylic_bridge) // можно сократить код с помощью команда with
                    tvContent2.text = getString(R.string.stamp_met_bridge)
                    tvContent3.text = getString(R.string.cast_bridge)
                    tvContent4.text = getString(R.string.met_acrylic_bridge)
                    tvContent5.text = getString(R.string.cer_bridge)
                    tvContent6.text = getString(R.string.met_cer_bridge)
                    tvContent7.text = getString(R.string.zir_bridge)
                }
            }
            getString(R.string.incl) -> {
                with(b) {
                    tvContent1.text = getString(R.string.tabs)
                }
                hide(6)
            }

            /*b.tvContent1.text = getString(R.string.inlay)
                b.tvContent2.text = getString(R.string.onlay)
                b.tvContent3.text = getString(R.string.overlay)
                b.tvContent4.text = getString(R.string.pinlay)
                */

            /*getString(R.string.incl_e_max) -> { -или новый способ чтобы отдельный фрагмент запкскался при таких одиночных карточках либо
            по тупому сделат чтобы был единичный выбор
                b.tvContent1.text = getString(R.string.e_max)
                hide(6)
            }
            getString(R.string.cad_cam_title) -> {
                b.tvContent1.text =  getString(R.string.use_cad_cam)
                hide(6)
            }*/
            getString(R.string.incl_e_max),
            getString(R.string.cad_cam_title),
            getString(R.string.about_imp),
            getString(R.string.pr_imp),
            getString(R.string.about_cast_on_main),
            getString(R.string.quat),
            getString(R.string.neylon),
            getString(R.string.acry), -> {
                hide(7)
            }
            getString(R.string.cla) -> {
                with(b) {
                    tvContent1.text = getString(R.string.clam)
                    tvContent2.text = getString(R.string.attach)
                    tvContent3.text = getString(R.string.teles)
                }
                hide(4)
            }
            getString(R.string.plast) -> {
                b.tvContent1.text = getString(R.string.part)
                b.tvContent2.text = getString(R.string.whole)
                hide(5)
            }
        }
    }

    /*private fun setItems(cont1: String, cont2: String) {  -- написать функцию которая сокращает дей-я заполнения итемов контентом
    // использовать сокращение чтобы не писать миллион раз b. и тд ( with  и что-то там вроде.. )
        b.tvContent1.text = cont1
        b.tvContent2.text = cont2
        var i = 1
        for i in 7
    }*/

    private fun setContentOn(id: Int, message: Int) {
        supportFragmentManager.beginTransaction().replace(id, InfoContent.newInstance()).commit()
        dataModel.kind.value = getString(message)
        hide(7)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvContent1 -> when (intent.getStringExtra("title")) {
                getString(R.string.veneers_lumineers) -> launchSeparate(R.string.veneers_classic)
                getString(R.string.bridges) -> launchSeparate(R.string.acrylic_bridge)
                getString(R.string.crowns) -> launchSeparate(R.string.acrylic_crown)
                getString(R.string.incl) -> launchSeparate(R.string.tabs)
                getString(R.string.incl_e_max) -> launchSeparate(R.string.e_max)
                getString(R.string.cad_cam_title) -> launchSeparate(R.string.use_cad_cam)
                getString(R.string.cla) -> launchSeparate(R.string.clam)
                getString(R.string.plast) -> launchSeparate(R.string.part)
            }
            R.id.tvContent2 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> launchSeparate(R.string.stamp_met_bridge)
                getString(R.string.crowns) -> launchSeparate(R.string.stamped_crown)
                getString(R.string.cla) -> launchSeparate(R.string.attach)
                getString(R.string.plast) -> launchSeparate(R.string.whole)
            }
            R.id.tvContent3 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> launchSeparate(R.string.cast_bridge)
                getString(R.string.crowns) -> launchSeparate(R.string.met_cer_crown)
                getString(R.string.cla) -> launchSeparate(R.string.teles)
            }
            R.id.tvContent4 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> launchSeparate(R.string.met_acrylic_bridge)
                getString(R.string.crowns) -> launchSeparate(R.string.zir_crown)
            }
            R.id.tvContent5 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> launchSeparate(R.string.cer_bridge)
                getString(R.string.crowns) -> launchSeparate(R.string.cer_crown)
            }
            R.id.tvContent6 -> when (intent.getStringExtra("title")) {
                getString(R.string.crowns) -> launchSeparate(R.string.met_acrylic_crown)
                getString(R.string.bridges) -> launchSeparate(R.string.met_cer_bridge)
            }
            R.id.tvContent7 -> when (intent.getStringExtra("title")) {
                getString(R.string.crowns) -> launchSeparate(R.string.cast_crown)
                getString(R.string.bridges) ->launchSeparate(R.string.zir_bridge)
            }
        }
    }

    private fun hide(number: Int) = with(b) {
        val content = arrayListOf(
            tvContent1,
            tvContent2,
            tvContent3,
            tvContent4,
            tvContent5,
            tvContent6,
            tvContent7
        )
        val border = content.size - number
        for (i in (content.size - 1) downTo border) content[i].visibility = GONE
    }

    private fun launchSeparate(message: Int) {
        val i = Intent(this, SeparateActivity::class.java)
        Toast.makeText(this, getString(message), Toast.LENGTH_SHORT).show()
        i.putExtra("content", getString(message))
        startActivity(i)
    }
}