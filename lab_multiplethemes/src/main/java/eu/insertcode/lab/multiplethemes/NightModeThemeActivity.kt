/*
 *    Copyright 2020 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.lab.multiplethemes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_night_mode_theme.*

class NightModeThemeActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("MultipleThemesExperiment", Context.MODE_PRIVATE)

        val theme = when (sharedPreferences.getString("theme", "")) {
            "Dark" -> R.style.AppTheme_Experiment_MultipleThemes_Dark
            "ExtraDark" -> R.style.AppTheme_Experiment_MultipleThemes_ExtraDark
            else -> R.style.AppTheme_Experiment_MultipleThemes_Light
        }
        setTheme(theme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_night_mode_theme)
        setSupportActionBar(multipleThemesExpermiment_toolbar)

        multipleThemesExpermiment_fab.setOnClickListener {
            sharedPreferences.edit().putString("theme", when (sharedPreferences.getString("theme", "")) {
                "Dark" -> "ExtraDark"
                "ExtraDark" -> "Light"
                else -> "Dark"
            }).apply()

            finish()
            startActivity(Intent(this, NightModeThemeActivity::class.java))
        }
    }


}
