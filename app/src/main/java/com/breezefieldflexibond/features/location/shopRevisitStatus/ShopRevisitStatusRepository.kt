package com.breezefieldflexibond.features.location.shopRevisitStatus

import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.location.model.ShopDurationRequest
import com.breezefieldflexibond.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}