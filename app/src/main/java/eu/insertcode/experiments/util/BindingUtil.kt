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

package eu.insertcode.experiments.util

import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

/**
 * Created by maarten on 2018-04-03.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
@BindingAdapter("srcRes")
fun setImageSrc(imageView: ImageView, @DrawableRes res: Int?) {
    if (res == null) return
    imageView.setImageDrawable(imageView.context.resources.getDrawable(res, null))
}


@BindingAdapter("bindingMarginTop")
fun setBindingTop(view: ViewGroup, px: Int?) {
    if (px == null) return
    val params = view.layoutParams as ViewGroup.MarginLayoutParams
    params.topMargin = px
    view.requestLayout()
}

