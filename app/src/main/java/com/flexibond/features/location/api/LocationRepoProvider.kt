package com.flexibond.features.location.api

import com.flexibond.features.location.shopdurationapi.ShopDurationApi
import com.flexibond.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}