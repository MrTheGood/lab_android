package eu.insertcode.experiments.viewmodel

import eu.insertcode.experiments.model.ExperimentCategory

/**
 * Created by maarten on 2018-04-05.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class ExperimentCategoryViewModel(private val category: ExperimentCategory) {
    fun getCategoryTitle() = category.title
}