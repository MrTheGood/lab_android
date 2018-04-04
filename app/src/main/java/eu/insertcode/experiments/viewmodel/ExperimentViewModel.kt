/*
 *    Copyright 2018. Maarten de Goede
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

package eu.insertcode.experiments.viewmodel

import android.content.Intent
import android.support.annotation.DrawableRes
import android.view.View
import eu.insertcode.experiments.model.Experiment

/**
 * Created by maarten on 2018-03-30.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ExperimentViewModel(private val experiment: Experiment) {
    @DrawableRes
    fun getExperimentIcon() = experiment.icon

    fun getExperimentTitle() = experiment.title

    val onClickedItem = View.OnClickListener { v -> v.context.startActivity(Intent(v.context, experiment.clazz)) }
}