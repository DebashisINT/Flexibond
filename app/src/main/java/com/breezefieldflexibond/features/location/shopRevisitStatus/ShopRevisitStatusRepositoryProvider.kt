package com.breezefieldflexibond.features.location.shopRevisitStatus

import com.breezefieldflexibond.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldflexibond.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}