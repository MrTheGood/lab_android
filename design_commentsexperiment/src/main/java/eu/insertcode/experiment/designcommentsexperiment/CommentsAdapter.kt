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

package eu.insertcode.experiment.designcommentsexperiment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.insertcode.experiment.designcommentsexperiment.CommentsAdapter.ViewHolder
import eu.insertcode.experiment.designcommentsexperiment.data.Comment
import eu.insertcode.multiplethemes.databinding.ItemCommentBinding

/**
 * Created by maartendegoede on 2019-01-29.
 * Copyright © 2019 insertCode.eu. All rights reserved.
 */
class CommentsAdapter : ListAdapter<Comment, ViewHolder>(CommentCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
            private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Comment) = binding.apply {
            comment = item
            executePendingBindings()
        }
    }

    class CommentCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem == newItem
    }
}



