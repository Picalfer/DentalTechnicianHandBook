package com.example.dentaltechnicianhandbook

import android.annotation.SuppressLint
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

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ContentItemBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.tvTitleContent2.text = intent.getStringExtra("title")
        b.tvContent.text = intent.getStringExtra("content")
        b.imageContent2.setImageResource(intent.getIntExtra("image", R.drawable.rem))

        b.tvContent1.setOnClickListener(this)
        b.tvContent2.setOnClickListener(this)
        b.tvContent3.setOnClickListener(this)
        b.tvContent4.setOnClickListener(this)
        b.tvContent5.setOnClickListener(this)
        b.tvContent6.setOnClickListener(this)
        b.tvContent6.setOnClickListener(this)

        when (intent.getStringExtra("title")) {
            /* Главная */
            getString(R.string.imp) -> {
                hide(6)
                setContentOn(R.id.information)
                dataModel.kind.value = getString(R.string.imp)
            }
            getString(R.string.cad_cam) -> {
                hide(6)
                setContentOn(R.id.information)
                dataModel.kind.value = getString(R.string.cad_cam)
            }
            getString(R.string.cer_main) -> {
            }
            getString(R.string.rem_full) -> {
            }
            getString(R.string.rem_part) -> {
            }
            getString(R.string.fix) -> {
            }
            getString(R.string.cast_main) -> {
            }
            getString(R.string.material) -> {
            }
            /* Полные съёмные */
            getString(R.string.bridges) -> {
                b.tvContent1.text = getString(R.string.acrylic_bridge)
                b.tvContent2.text = getString(R.string.cast_bridge)
                b.tvContent3.text = getString(R.string.met_cer_bridge)
                b.tvContent4.text = getString(R.string.zir_bridge)
                b.tvContent5.text = getString(R.string.cer_bridge)
                hide(1)
            }
            getString(R.string.crowns) -> {
                b.tvContent1.text = getString(R.string.acrylic_crown)
                b.tvContent2.text = getString(R.string.cast_crown)
                b.tvContent3.text = getString(R.string.met_cer_crown)
                b.tvContent4.text = getString(R.string.zir_crown)
                b.tvContent5.text = getString(R.string.cer_crown)
                b.tvContent6.text = getString(R.string.met_acrylic_crown)
            }
            getString(R.string.incl) -> {
                b.tvContent1.text = getString(R.string.inlay)
                b.tvContent2.text = getString(R.string.onlay)
                b.tvContent3.text = getString(R.string.overlay)
                b.tvContent4.text = getString(R.string.pinlay)
                hide(2)
            }
            getString(R.string.veneers_lumineers),
            getString(R.string.about_imp),
            getString(R.string.pr_imp),
            getString(R.string.about_cast_on_main),
            getString(R.string.quat),
            getString(R.string.neylon),
            getString(R.string.acry), -> {
                //тут не будет перехода на другой layout, так как нет выбора
                //сразу будет здесь контент показываться
                //или все-таки будет переход на layout, если будет реализован общий layout
                //для любого контента
                hide(6)
            }
            getString(R.string.cla) -> {
                b.tvContent1.text = getString(R.string.clam)
                b.tvContent2.text = getString(R.string.attach)
                b.tvContent3.text = getString(R.string.teles)
                hide(3)
            }
            getString(R.string.plast) -> {
                b.tvContent1.text = getString(R.string.part)
                b.tvContent2.text = getString(R.string.whole)
                hide(4)
            }
        }
    }

    private fun setContentOn(id: Int) {
        supportFragmentManager.beginTransaction().replace(id, InfoContent.newInstance()).commit()
    }

    override fun onClick(v: View?) {
        val i = Intent(this, SeparateActivity::class.java)
        when (v?.id) {
            R.id.tvContent1 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.acrylic_bridge), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.acrylic_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.acrylic_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.acrylic_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.inlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.inlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.clam), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.clam))
                    startActivity(i)
                }
                getString(R.string.plast) -> {
                    Toast.makeText(this, getString(R.string.part), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.part))
                    startActivity(i)
                }
            }
            R.id.tvContent2 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.cast_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cast_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.cast_crown), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cast_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.onlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.onlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.attach), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.attach))
                    startActivity(i)
                }
                getString(R.string.plast) -> {
                    Toast.makeText(this, getString(R.string.whole), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.whole))
                    startActivity(i)
                }
            }
            R.id.tvContent3 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.met_cer_bridge), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.met_cer_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.met_cer_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.met_cer_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.overlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest",getString(R.string.overlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.teles), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.teles))
                    startActivity(i)
                }
            }
            R.id.tvContent4 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.zir_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.zir_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.zir_crown), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.zir_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.pinlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.pinlayShort))
                    startActivity(i)
                }
            }
            R.id.tvContent5 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.cer_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cer_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.cer_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cer_crown))
                    startActivity(i)
                }
            }
            R.id.tvContent6 -> {
                        Toast
                            .makeText(this, getString(R.string.met_cer_bridge),
                                Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest", getString(R.string.met_acrylic_crown))
                        startActivity(i)
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
            tvContent6
        )
        val border = content.size - number
        for (i in (content.size - 1) downTo border) content[i].visibility = GONE
    }
}