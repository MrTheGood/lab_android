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

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import eu.insertcode.experiments.R
import eu.insertcode.experiments.model.Experiment
import eu.insertcode.experiments.model.ExperimentState

/**
 * Created by maarten on 2018-03-30.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ExperimentViewModel(
        private val context: Context,
        private val experiment: Experiment,
        private val position: Int
) {
    companion object {
        @JvmStatic
        val colors = arrayListOf(
                R.color.experimentBackground1,
                R.color.experimentBackground2,
                R.color.experimentBackground3,
                R.color.experimentBackground4,
                R.color.experimentBackground5,
                R.color.experimentBackground6,
                R.color.experimentBackground7,
                R.color.experimentBackground8,
                R.color.experimentBackground9
        )
    }

    @DrawableRes
    fun getExperimentIcon() = experiment.icon

    fun getExperimentTitle() = experiment.title

    fun getExperimentSubtitle() = experiment.subtitle

    fun getExperimentIconBackgroundColor() = ContextCompat.getColor(context, colors[position % colors.size])

    @DrawableRes
    fun getExperimentStateIcon() = when (experiment.state) {
        ExperimentState.DEVELOPMENT -> R.drawable.ic_error_outline
        ExperimentState.FAILED -> R.drawable.ic_error
        ExperimentState.COMPLETED -> null
    }

    val onClickedItem = View.OnClickListener { v ->
        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (experiment.state) {
            ExperimentState.DEVELOPMENT -> Toast.makeText(context, R.string.str_devExperiment, Toast.LENGTH_LONG).show()
            ExperimentState.FAILED -> {
                AlertDialog.Builder(context)
                        .setMessage(R.string.str_failedExperiment)
                        .setPositiveButton(android.R.string.ok, null)
                        .show()
                return@OnClickListener
            }
        }

        v.context.startActivity(Intent(v.context, experiment.clazz))
    }
}