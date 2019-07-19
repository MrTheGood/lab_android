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

package eu.insertcode.experiments

import eu.insertcode.androidpexperiment.DesignLibraryV28Activity
import eu.insertcode.androidpexperiment.FingerprintDialogActivity
import eu.insertcode.architectureexperiment.databinding.view.activity.ArchitectureComponentsDataBindingActivity
import eu.insertcode.architectureexperiment.normal.view.activity.ArchitectureComponentsActivity
import eu.insertcode.clapp.ClappActivity
import eu.insertcode.clapp.CurvedTextActivity
import eu.insertcode.experiment.designcommentsexperiment.FlatCommentlistActivity
import eu.insertcode.experiment.multiplethemes.NightModeThemeActivity
import eu.insertcode.experiment.physicsbasedanimations.ChangingAnimActivity
import eu.insertcode.experiment.physicsbasedanimations.CombinedFlingSpringAnimActivity
import eu.insertcode.experiment.physicsbasedanimations.FlingAnimActivity
import eu.insertcode.experiment.physicsbasedanimations.SpringAnimActivity
import eu.insertcode.experiments.model.Experiment
import eu.insertcode.experiments.model.ExperimentCategory
import eu.insertcode.experiments.model.ExperimentState
import eu.insertcode.otherexperiments.SideSheetDrawerActivity

/**
 * Created by maarten on 2018-04-03.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
object Experiments {
    @JvmStatic
    val experiments = listOf(
            ExperimentCategory("Shitty Apps"),
            Experiment(R.drawable.ic_clap, "Clapp", "The revolutionary app for clapping with just one hand!", ExperimentState.COMPLETED, ClappActivity::class.java),
            Experiment(R.drawable.ic_looks, "CircularText", "Circular Text, required for Clapp.", ExperimentState.COMPLETED, CurvedTextActivity::class.java),

            ExperimentCategory("Comments"),
            Experiment(R.drawable.ic_vertical_align_center, "Flat Comment List", "A list of comments that's pretty conventional", ExperimentState.FAILED, FlatCommentlistActivity::class.java),

            ExperimentCategory("Physics Based Animations"),
            Experiment(R.drawable.ic_touch_app, "Spring Animation", "A circle that springs back to the original position", ExperimentState.COMPLETED, SpringAnimActivity::class.java),
            Experiment(R.drawable.ic_toll, "Fling Animation", "A circle which you can fling to any position", ExperimentState.COMPLETED, FlingAnimActivity::class.java),
            Experiment(R.drawable.ic_vertical_align_center, "Combined Fling and Spring Animation", "A swipe up sheet with a spring bar inside it", ExperimentState.COMPLETED, CombinedFlingSpringAnimActivity::class.java),
            Experiment(R.drawable.ic_touch_app, "Changing Animation", "Tap anywhere to animate an object to that location!", ExperimentState.FAILED, ChangingAnimActivity::class.java),

            ExperimentCategory("Themes"),
            Experiment(R.drawable.ic_brightness_4, "Night mode", "An app with multiple day and night themes", ExperimentState.COMPLETED, NightModeThemeActivity::class.java),

            ExperimentCategory("Android P Developer Preview"),
            Experiment(R.drawable.ic_action_android, "Design library v28", "Testing the new support library components", ExperimentState.COMPLETED, DesignLibraryV28Activity::class.java),
            Experiment(R.drawable.ic_fingerprint, "Biometric Prompt", "Testing the new Android P fingerprint dialog", ExperimentState.COMPLETED, FingerprintDialogActivity::class.java),

            ExperimentCategory("App Architecture"),
            Experiment(R.drawable.ic_build, "Architecture Components", "A simple app to test out Android Architecture Components", ExperimentState.COMPLETED, ArchitectureComponentsActivity::class.java),
            Experiment(R.drawable.ic_link, "Architecture Components Databinding", "A simple app to test out Android Architecture Components with databinding", ExperimentState.COMPLETED, ArchitectureComponentsDataBindingActivity::class.java),

            ExperimentCategory("Other Experiments"),
            Experiment(R.drawable.ic_swap_horiz, "Side Sheet Experiment", "This experiment has been cancelled for now. ", ExperimentState.FAILED, SideSheetDrawerActivity::class.java)
    )
}