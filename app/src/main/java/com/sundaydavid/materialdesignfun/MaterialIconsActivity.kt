package com.sundaydavid.materialdesignfun

import android.graphics.Color
import android.graphics.Color.GREEN
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_icons.*
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class MaterialIconsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_icons)

        imageView.setOnClickListener {
            val materialIconDrawable =MaterialDrawableBuilder.with(this)
                .setIcon(MaterialDrawableBuilder.IconValue.ANDROID)
                .setColor(Color.GREEN)
                .setSizeDp(48)
                .build()
            newView.setImageDrawable(materialIconDrawable)
        }
    }
}