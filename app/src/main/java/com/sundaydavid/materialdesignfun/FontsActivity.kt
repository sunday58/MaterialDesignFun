package com.sundaydavid.materialdesignfun

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_fonts.*
import kotlinx.android.synthetic.main.activity_fonts.next

class FontsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fonts)

        button.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                textView2.typeface = ResourcesCompat.getFont(this, R.font.sanchez)
            else
                textView2.typeface = Typeface.DEFAULT
        }

        next.setOnClickListener {
            startActivity(Intent(this, TapPromptActivity::class.java))
        }
    }
}