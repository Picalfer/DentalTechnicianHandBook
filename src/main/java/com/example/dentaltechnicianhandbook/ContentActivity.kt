package com.example.dentaltechnicianhandbook

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dentaltechnicianhandbook.databinding.ContentItemBinding

class ContentActivity: AppCompatActivity(), View.OnClickListener {

private lateinit var binding: ContentItemBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitleContent2.text = intent.getStringExtra("title")
        binding.tvContent.text = intent.getStringExtra("content")
        binding.imageContent2.setImageResource(intent.getIntExtra("image", R.drawable.rem))

        binding.tvContent1.setOnClickListener(this)
        binding.tvContent2.setOnClickListener(this)
        binding.tvContent3.setOnClickListener(this)
        binding.tvContent4.setOnClickListener(this)
        binding.tvContent5.setOnClickListener(this)
        binding.tvContent6.setOnClickListener(this)

        when (intent.getStringExtra("title")) {
            getString(R.string.bridges) -> {
                binding.tvContent1.text = getString(R.string.acrylic_bridge)
                binding.tvContent2.text = getString(R.string.cast_bridge)
                binding.tvContent3.text = getString(R.string.met_cer_bridge)
                binding.tvContent4.text = getString(R.string.zir_bridge)
                binding.tvContent5.text = getString(R.string.cer_bridge)
                hide(1)
                /*binding.tvContent6.visibility = GONE*/
            }
            getString(R.string.crowns) -> {
                binding.tvContent1.text = getString(R.string.acrylic_crown)
                binding.tvContent2.text = getString(R.string.cast_crown)
                binding.tvContent3.text = getString(R.string.met_cer_crown)
                binding.tvContent4.text = getString(R.string.zir_crown)
                binding.tvContent5.text = getString(R.string.cer_crown)
                binding.tvContent6.text = getString(R.string.met_acrylic_crown)
            }
            getString(R.string.incl) -> {
                binding.tvContent1.text = getString(R.string.inlay)
                binding.tvContent2.text = getString(R.string.onlay)
                binding.tvContent3.text = getString(R.string.overlay)
                binding.tvContent4.text = getString(R.string.pinlay)
                hide(2)
                /*binding.tvContent5.visibility = GONE
                binding.tvContent6.visibility = GONE*/
            }
            getString(R.string.veneers_lumineers) -> {
                binding.tvContent1.text = getString(R.string.veneers)
                binding.tvContent2.text = getString(R.string.lumineers)
                hide(4)
                // binding.tvContent4.visibility = GONE
                // binding.tvContent5.visibility = GONE
                // binding.tvContent6.visibility = GONE
            }
            getString(R.string.about_imp),
            getString(R.string.about_cla),
            getString(R.string.about_fix),
            getString(R.string.about_rem),
            getString(R.string.pr_imp),
            getString(R.string.imp),
            getString(R.string.quat),
            getString(R.string.neylon),
            getString(R.string.acry)
            -> {
                //тут не будет перехода на другой layout, так как нет выбора
                //сразу будет здесь контент показываться
                //или все-таки будет переход на layout, если будет реализован общий layout
                //для любого контента
                hide(6)
                /*binding.tvContent1.visibility = GONE
                binding.tvContent2.visibility = GONE
                binding.tvContent3.visibility = GONE
                binding.tvContent4.visibility = GONE
                binding.tvContent5.visibility = GONE
                binding.tvContent6.visibility = GONE*/
            }
            getString(R.string.cla) -> {
                binding.tvContent1.text = getString(R.string.clam)
                binding.tvContent2.text = getString(R.string.attach)
                binding.tvContent3.text = getString(R.string.teles)
                hide(3)
                /*binding.tvContent4.visibility = GONE
                binding.tvContent5.visibility = GONE
                binding.tvContent6.visibility = GONE*/
            }
            getString(R.string.plast) -> {
                binding.tvContent1.text = getString(R.string.part)
                binding.tvContent2.text = getString(R.string.whole)
                hide(4)
            }
            // getString(R.string.)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvContent1 -> {
                Toast.makeText( this,"test1", Toast.LENGTH_SHORT).show()
            }
            R.id.tvContent2 -> {
                Toast.makeText( this,"test2", Toast.LENGTH_SHORT).show()
            }
            R.id.tvContent3 -> {
                Toast.makeText( this,"test3", Toast.LENGTH_SHORT).show()
            }
            R.id.tvContent4 -> {
                Toast.makeText(this, "test4", Toast.LENGTH_SHORT).show()
            }
            R.id.tvContent5 -> {
                Toast.makeText(this, "test5", Toast.LENGTH_SHORT).show()
            }
            R.id.tvContent6 -> {
                Toast.makeText(this, "test6", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hide(number: Int) {
        val content = arrayListOf(
            binding.tvContent1,
            binding.tvContent2,
            binding.tvContent3,
            binding.tvContent4,
            binding.tvContent5,
            binding.tvContent6
        )
        val border = content.size - number
        for (i in (content.size - 1) downTo border) {
            content[i].visibility = GONE
        }
    }
}