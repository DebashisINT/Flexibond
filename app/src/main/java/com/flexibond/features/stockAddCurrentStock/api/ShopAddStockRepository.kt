package com.flexibond.features.stockAddCurrentStock.api

import com.flexibond.base.BaseResponse
import com.flexibond.features.location.model.ShopRevisitStatusRequest
import com.flexibond.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.flexibond.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.flexibond.features.stockAddCurrentStock.model.CurrentStockGetData
import com.flexibond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}