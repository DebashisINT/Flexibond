package com.flexibond.features.location.shopRevisitStatus

import com.flexibond.features.location.shopdurationapi.ShopDurationApi
import com.flexibond.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}