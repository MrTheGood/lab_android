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

package eu.insertcode.lab.architecture.databinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.insertcode.lab.architecture.DemoContent
import eu.insertcode.lab.architecture.data.Article

class ArticleViewModel : ViewModel() {
    val articles = MutableLiveData<List<Article>>()
    val selectedArticle = MutableLiveData<Article>()


    fun init() {
        articles.value = DemoContent.articles
        //todo: load from cache
    }

    fun select(position: Int) {
        selectedArticle.value = articles.value?.getOrNull(position)
    }
}
