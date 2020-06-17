/*
 *    Copyright 2020 Maarten de Goede
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

package eu.insertcode.lab.designcomments.data

import androidx.annotation.DrawableRes

/**
 * Created by maartendegoede on 2019-01-29.
 * Copyright © 2019 insertCode.eu. All rights reserved.
 */
data class Comment(
        val id: Int,
        val name: String,
        val text: String,
        val date: String,
        @DrawableRes val image: Int
)