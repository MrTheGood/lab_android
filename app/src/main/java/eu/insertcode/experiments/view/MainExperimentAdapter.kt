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

package eu.insertcode.experiments.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.insertcode.experiments.Experiments
import eu.insertcode.experiments.R
import eu.insertcode.experiments.databinding.ItemMainExperimentBinding
import eu.insertcode.experiments.viewmodel.ExperimentViewModel

/**
 * Created by maarten on 2018-03-30.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class MainExperimentAdapter : RecyclerView.Adapter<MainExperimentAdapter.ExperimentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ExperimentViewHolder(DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_main_experiment,
                    parent,
                    false
            ))


    override fun getItemCount() = Experiments.experiments.count()

    override fun onBindViewHolder(holder: ExperimentViewHolder, position: Int) {
        holder.binding.experimentViewModel = ExperimentViewModel(
                Experiments.experiments[position]
        )
    }

    class ExperimentViewHolder(val binding: ItemMainExperimentBinding) : RecyclerView.ViewHolder(binding.root)
}