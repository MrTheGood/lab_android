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

package eu.insertcode.architectureexperiment.databinding.view.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.insertcode.architectureexperiment.R
import eu.insertcode.architectureexperiment.databinding.FragmentArticleDatabindingBinding
import eu.insertcode.architectureexperiment.databinding.viewmodel.ArticleViewModel

class ArticleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentArticleDatabindingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_databinding, container, false)
        binding.setLifecycleOwner(this)
        binding.articleViewModel = ViewModelProviders.of(requireActivity()).get(ArticleViewModel::class.java)
        return binding.root
    }

}
