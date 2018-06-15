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

package eu.insertcode.architectureexperiment.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import eu.insertcode.architectureexperiment.R
import eu.insertcode.architectureexperiment.data.Article
import eu.insertcode.architectureexperiment.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_article.*

const val ARGUMENT_ARTICLE_ID = "eu.insertcode.architectureexperiment.view.fragment.ArticleFragment.ARGUMENT_ARTICLE_ID"

class ArticleFragment : Fragment() {
    companion object {
        fun newInstance(articleId: Int) = ArticleFragment().apply {
            arguments = Bundle().apply { putInt(ARGUMENT_ARTICLE_ID, articleId) }
        }
    }

    private lateinit var viewModel: ArticleViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val articleId = arguments?.getInt(ARGUMENT_ARTICLE_ID) ?: -1
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        viewModel.init(articleId)

        viewModel.article.observe(this, Observer<Article> { article ->
            Glide.with(arch_article_thumbnail).load(article?.thumbnailUrl).into(arch_article_thumbnail)
            arch_article_title.text = article?.title
            arch_article_text.text = article?.article
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_article, container, false)

}
