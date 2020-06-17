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

package eu.insertcode.lab.architecture.databinding.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import eu.insertcode.lab.architecture.R
import eu.insertcode.lab.architecture.data.Article
import eu.insertcode.lab.architecture.databinding.ItemArticleDatabindingBinding

/**
 * Created by maartendegoede on 18/06/2018.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ArticleAdapter(
        private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles = emptyList<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val holder = ArticleViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_article_databinding, parent, false))
        holder.binding.root.setOnClickListener { v -> if (v.tag is Int) onItemClick(v.tag as Int) }
        return holder
    }

    override fun getItemCount() = articles.count() * 3

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.binding.root.tag = position % articles.count()
        holder.binding.article = articles[position % articles.count()]
    }

    class ArticleViewHolder(val binding: ItemArticleDatabindingBinding) : RecyclerView.ViewHolder(binding.root)
}