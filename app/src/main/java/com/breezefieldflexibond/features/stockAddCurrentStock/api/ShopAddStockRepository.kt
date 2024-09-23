package com.breezefieldflexibond.features.stockAddCurrentStock.api

import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.location.model.ShopRevisitStatusRequest
import com.breezefieldflexibond.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezefieldflexibond.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.breezefieldflexibond.features.stockAddCurrentStock.model.CurrentStockGetData
import com.breezefieldflexibond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}