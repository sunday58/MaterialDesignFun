package com.sundaydavid.materialdesignfun

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_pop_up_menu.*
import java.lang.Exception

class PopUpMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_menu)

        imageView_options.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener {item ->
                when(item.itemId) {
                    R.id.menu_open_website -> {
                       val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://resocoder.com"))
                        startActivity(intent)
                        true
                    }
                    R.id.menu_show_fonts -> {
                        startActivity(Intent(this, FontsActivity::class.java))
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_main)

            try {
                val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java )
                    .invoke(mPopup, true)
            }catch (e: Exception) {
               Log.e("Menu", "Error showing menu icons.", e)
            } finally {
                popupMenu.show()
            }
        }
    }
}