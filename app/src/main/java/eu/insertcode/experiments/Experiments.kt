/*
 *    Copyright 2018 Maarten de Goede
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

package eu.insertcode.experiments

import eu.insertcode.experiment.multiplethemes.NightModeThemeActivity
import eu.insertcode.experiment.physicsbasedanimations.CombinedFlingSpringAnimActivity
import eu.insertcode.experiment.physicsbasedanimations.FlingAnimActivity
import eu.insertcode.experiment.physicsbasedanimations.SpringAnimActivity
import eu.insertcode.experiments.model.Experiment
import eu.insertcode.experiments.model.ExperimentCategory

/**
 * Created by maarten on 2018-04-03.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
object Experiments {
    @JvmStatic
    val experiments = listOf(
            ExperimentCategory("Physics Based Animations"),
            Experiment(R.drawable.ic_touch_app, "Spring Animation", SpringAnimActivity::class.java),
            Experiment(R.drawable.ic_toll, "Fling Animation", FlingAnimActivity::class.java),
            Experiment(R.drawable.ic_action_upload, "Combined Fling and Spring Animation", CombinedFlingSpringAnimActivity::class.java),

            ExperimentCategory("Themes"),
            Experiment(R.drawable.ic_brightness_4, "Night mode", NightModeThemeActivity::class.java),

            ExperimentCategory("Android P Developer Preview"),
            Experiment(R.drawable.ic_brightness_4, "Material 2.0", NightModeThemeActivity::class.java)
    )
}