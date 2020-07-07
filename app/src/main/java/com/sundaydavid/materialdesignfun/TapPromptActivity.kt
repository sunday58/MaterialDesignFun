package com.sundaydavid.materialdesignfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_material_tap_target_prompt.*
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class TapPromptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_tap_target_prompt)


        showFabPrompt()

        button.setOnClickListener {
            startActivity(Intent(this, AnkoActivity::class.java))
        }
        fab.setOnClickListener {
            startActivity(Intent(this, MaterialIconsActivity::class.java))
        }
    }

    private fun showFabPrompt(){
        val prefManager = PreferenceManager.getDefaultSharedPreferences(this)

        if (!prefManager.getBoolean("didShowPrompt", false)){
            MaterialTapTargetPrompt.Builder(this)
                .setTarget(fab)
                .setPrimaryText("Click me!")
                .setSecondaryText("I am a floating action button")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                        || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                        val prefEditor = prefManager.edit()
                        prefEditor.putBoolean("didShowPrompt", true)
                        prefEditor.apply()

                        showButtonPrompt()
                    }
                }
                .show()
        }
    }
    private fun showButtonPrompt(){
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(button)
            .setPrimaryText("Press me!")
            .setSecondaryText(" I'm a nice and simple button.")
            .setBackButtonDismissEnabled(true)
            .setPromptBackground(RectanglePromptBackground())
            .setPromptFocal(RectanglePromptFocal())
            .show()
    }
}