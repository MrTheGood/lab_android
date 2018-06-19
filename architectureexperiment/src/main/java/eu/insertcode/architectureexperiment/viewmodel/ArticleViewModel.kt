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

package eu.insertcode.architectureexperiment.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import eu.insertcode.architectureexperiment.MockData
import eu.insertcode.architectureexperiment.data.Article

class ArticleViewModel : ViewModel() {
    lateinit var articles: LiveData<List<Article>>

    private var selectedPosition: Int? = null

    val selectedArticle: LiveData<Article>?
        get() =
            if (selectedPosition != null && selectedPosition!! in articles.value!!.indices)
                MutableLiveData<Article>().apply { value = articles.value!![selectedPosition!!] }
            else null


    fun init() {
        articles = MutableLiveData<List<Article>>().apply {
            value = MockData.articles
        }
        //todo: load from cache
    }

    @Suppress("LiftReturnOrAssignment")
    fun select(position: Int) {
        if (position in articles.value!!.indices)
            selectedPosition = position
        else
            selectedPosition = null
    }
}
