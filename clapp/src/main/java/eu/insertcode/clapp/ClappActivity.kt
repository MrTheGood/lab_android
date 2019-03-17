/*
 *    Copyright 2019 Maarten de Goede
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

package eu.insertcode.clapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_clapp.*

/**
 * Created by maartendegoede on 2019-03-17.
 * Copyright © 2019 insertCode.eu. All rights reserved.
 */
class ClappActivity : AppCompatActivity() {

    private val clapSounds by lazy {
        listOf(
                MediaPlayer.create(this, R.raw.clap1), MediaPlayer.create(this, R.raw.clap2),
                MediaPlayer.create(this, R.raw.clap3), MediaPlayer.create(this, R.raw.clap4),
                MediaPlayer.create(this, R.raw.clap5), MediaPlayer.create(this, R.raw.clap6),
                MediaPlayer.create(this, R.raw.clap7), MediaPlayer.create(this, R.raw.clap8),
                MediaPlayer.create(this, R.raw.clap9), MediaPlayer.create(this, R.raw.clap10),
                MediaPlayer.create(this, R.raw.clap11), MediaPlayer.create(this, R.raw.clap12),
                MediaPlayer.create(this, R.raw.clap13), MediaPlayer.create(this, R.raw.clap14),
                MediaPlayer.create(this, R.raw.clap15), MediaPlayer.create(this, R.raw.clap16),
                MediaPlayer.create(this, R.raw.clap17), MediaPlayer.create(this, R.raw.clap18),
                MediaPlayer.create(this, R.raw.clap19)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clapp)

        button_clap.setOnClickListener {
            clapSounds.random().start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        clapSounds.forEach { it.release() }
    }
}