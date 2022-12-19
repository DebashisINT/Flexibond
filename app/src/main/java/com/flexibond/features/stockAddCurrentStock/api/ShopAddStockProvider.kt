package com.flexibond.features.stockAddCurrentStock.api

import com.flexibond.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.flexibond.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}