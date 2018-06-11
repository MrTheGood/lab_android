package eu.insertcode.experiments.viewmodel

import android.content.Context
import android.util.TypedValue
import eu.insertcode.experiments.model.ExperimentCategory

/**
 * Created by maarten on 2018-04-05.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ExperimentCategoryViewModel(
        private val context: Context,
        private val category: ExperimentCategory,
        private val position: Int
) {
    fun getCategoryTitle() = category.title

    fun getCategoryMarginTop(): Int =
            if (position == 0) 0
            else TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, context.resources.displayMetrics).toInt()
}