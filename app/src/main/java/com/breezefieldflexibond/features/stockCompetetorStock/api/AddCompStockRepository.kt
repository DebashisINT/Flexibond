package com.breezefieldflexibond.features.stockCompetetorStock.api

import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.orderList.model.NewOrderListResponseModel
import com.breezefieldflexibond.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.breezefieldflexibond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}