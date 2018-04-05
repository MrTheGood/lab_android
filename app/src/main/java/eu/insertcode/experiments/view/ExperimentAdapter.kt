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
import eu.insertcode.experiments.databinding.ItemCategoryBinding
import eu.insertcode.experiments.databinding.ItemExperimentBinding
import eu.insertcode.experiments.model.Experiment
import eu.insertcode.experiments.model.ExperimentCategory
import eu.insertcode.experiments.viewmodel.ExperimentCategoryViewModel
import eu.insertcode.experiments.viewmodel.ExperimentViewModel

/**
 * Created by maarten on 2018-03-30.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ExperimentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val VIEW_TYPE_CATEGORY = 0
        private const val VIEW_TYPE_EXPERIMENT = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            when (viewType) {
                VIEW_TYPE_CATEGORY ->
                    CategoryViewHolder(DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.item_category,
                            parent,
                            false
                    ))
                else ->
                    ExperimentViewHolder(DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.item_experiment,
                            parent,
                            false
                    ))
            }

    override fun getItemViewType(position: Int) =
            when (Experiments.experiments[position]) {
                is ExperimentCategory -> VIEW_TYPE_CATEGORY
                is Experiment -> VIEW_TYPE_EXPERIMENT
                else -> throw IllegalArgumentException("Invalid experiment item")
            }


    override fun getItemCount() = Experiments.experiments.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = Experiments.experiments[position]
        if (item is Experiment && holder is ExperimentViewHolder) {
            holder.binding.experimentViewModel = ExperimentViewModel(item)
        } else if (item is ExperimentCategory && holder is CategoryViewHolder) {
            holder.binding.categoryViewModel = ExperimentCategoryViewModel(item)
        } else {
            throw IllegalStateException("Experiment Item and ViewHolder don't match!")
        }
    }

    class ExperimentViewHolder(val binding: ItemExperimentBinding) : RecyclerView.ViewHolder(binding.root)
    class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)
}