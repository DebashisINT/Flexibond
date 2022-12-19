package com.flexibond.features.dashboard.presentation.api.dayStartEnd

import com.flexibond.features.stockCompetetorStock.api.AddCompStockApi
import com.flexibond.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}