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
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.insertcode.architectureexperiment.R
import eu.insertcode.architectureexperiment.view.activity.ArchitectureComponentsActivity
import eu.insertcode.architectureexperiment.view.adapter.ArticleAdapter
import eu.insertcode.architectureexperiment.viewmodel.ArticleListViewModel
import kotlinx.android.synthetic.main.article_list_fragment.*


class ArticleListFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleListFragment()
    }

    private lateinit var viewModel: ArticleListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.article_list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticleListViewModel::class.java)
        viewModel.init()

        viewModel.articles.observe(this, Observer { articles ->
            viewRoot.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            viewRoot.adapter = ArticleAdapter(activity as ArchitectureComponentsActivity, articles
                    ?: emptyList())
        })
    }

}
