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

package eu.insertcode.architectureexperiment.normal.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import eu.insertcode.architectureexperiment.R
import eu.insertcode.architectureexperiment.data.Article
import eu.insertcode.architectureexperiment.normal.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_article.view.*

class ArticleFragment : Fragment() {
    private lateinit var viewModel: ArticleViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity())[ArticleViewModel::class.java]
        viewModel.selectedArticle.observe(this, Observer<Article> { article ->
            view!!.apply {
                Glide.with(arch_article_thumbnail).load(article?.thumbnailUrl).into(arch_article_thumbnail)
                arch_article_title.text = article?.title
                arch_article_text.text = article?.article
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_article, container, false)

}
