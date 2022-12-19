package com.flexibond.features.stockCompetetorStock.api

import com.flexibond.base.BaseResponse
import com.flexibond.features.orderList.model.NewOrderListResponseModel
import com.flexibond.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.flexibond.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}