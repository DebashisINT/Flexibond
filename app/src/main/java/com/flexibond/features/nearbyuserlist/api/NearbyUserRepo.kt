package com.flexibond.features.nearbyuserlist.api

import com.flexibond.app.Pref
import com.flexibond.features.nearbyuserlist.model.NearbyUserResponseModel
import com.flexibond.features.newcollection.model.NewCollectionListResponseModel
import com.flexibond.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}