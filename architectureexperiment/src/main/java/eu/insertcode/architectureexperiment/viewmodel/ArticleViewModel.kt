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
import eu.insertcode.architectureexperiment.data.Article

/**
 * Created by maartendegoede on 12/06/2018.
 * Copyright © 2018 insertcode.eu. All rights reserved.
 */
class ArticleViewModel : ViewModel() {
    var articleId: Int = -1
    lateinit var article: LiveData<Article>

    fun init(id: Int) {
        articleId = id
        article = MutableLiveData<Article>().apply {
            value = Article(0, "https://d1hw6n3yxknhky.cloudfront.net/007730263_prevstill.jpeg", "Lorem", "Lorem ipsum dolor sit amet")
        }
        //todo: set article
    }
}