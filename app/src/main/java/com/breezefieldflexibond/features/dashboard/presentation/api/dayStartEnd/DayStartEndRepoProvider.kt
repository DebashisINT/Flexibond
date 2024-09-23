package com.breezefieldflexibond.features.dashboard.presentation.api.dayStartEnd

import com.breezefieldflexibond.features.stockCompetetorStock.api.AddCompStockApi
import com.breezefieldflexibond.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}