package com.breezefieldflexibond.features.location.api

import com.breezefieldflexibond.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldflexibond.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}