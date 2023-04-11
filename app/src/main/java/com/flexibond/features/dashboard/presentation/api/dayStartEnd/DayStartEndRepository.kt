package com.flexibond.features.dashboard.presentation.api.dayStartEnd

import com.flexibond.app.Pref
import com.flexibond.base.BaseResponse
import com.flexibond.features.dashboard.presentation.model.DaystartDayendRequest
import com.flexibond.features.dashboard.presentation.model.StatusDayStartEnd
import com.flexibond.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.flexibond.features.stockCompetetorStock.api.AddCompStockApi
import io.reactivex.Observable

class DayStartEndRepository (val apiService: DayStartEndApi){
    fun dayStart(daystartDayendRequest: DaystartDayendRequest): Observable<BaseResponse> {
        return apiService.submitDayStartEnd(daystartDayendRequest)
    }

    fun dayStartEndStatus(date:String): Observable<StatusDayStartEnd> {
        return apiService.statusDayStartEnd(Pref.session_token!!, Pref.user_id!!,date)
    }

    fun daystartendDelete(sessionToken:String,usrID:String,date:String,dayStDel:String,dayEndDel:String): Observable<BaseResponse> {
        return apiService.submitDayStartEndDelApi(sessionToken,usrID,date,dayStDel,dayEndDel)
    }


}