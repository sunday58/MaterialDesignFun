package com.sundaydavid.materialdesignfun

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class AnkoActivityUi : AnkoComponent<AnkoActivity> {
    override fun createView(ui: AnkoContext<AnkoActivity>): View = with(ui) {
        frameLayout {
            val textField = editText {
                hint = "Text for toasts and snackbars"
            }.lparams(width = matchParent) {
                margin = dip(12)
                topMargin = dip(30)
            }
            imageView(R.drawable.ic_android_24) {
                onClick {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        this@imageView.imageTintList =
                            ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                    }
                }
            }.lparams(dip(72), dip(72)) {
                gravity = Gravity.CENTER
            }
            linearLayout {
                button("Show toast") {
                   onClick {
                       toast(textField.text)
                   }
                }
                button("Show Snackbar") {
                    onClick {
                        longToast(textField.text)
                    }
                }
            }.lparams{
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }
        }
    }
}