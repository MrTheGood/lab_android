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

package eu.insertcode.lab.architecture.databinding.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import eu.insertcode.lab.architecture.R
import eu.insertcode.lab.architecture.databinding.view.activity.ArchitectureComponentsDataBindingActivity
import eu.insertcode.lab.architecture.databinding.view.adapter.ArticleAdapter
import eu.insertcode.lab.architecture.databinding.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.article_list_fragment.view.*


class ArticleListFragment : Fragment() {
    private lateinit var viewModel: ArticleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.article_list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(ArticleViewModel::class.java)
        viewModel.init()

        view!!.arch_article_list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        view!!.arch_article_list.adapter = ArticleAdapter { position ->
            viewModel.select(position)
            (activity as ArchitectureComponentsDataBindingActivity).showFragment(ArticleFragment(), true)
        }

        viewModel.articles.observe(this, Observer { articles ->
            (view!!.arch_article_list.adapter as ArticleAdapter).articles = articles ?: emptyList()
        })
    }

}
