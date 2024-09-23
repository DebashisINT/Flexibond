package com.breezefieldflexibond.features.nearbyuserlist.api

import com.breezefieldflexibond.app.Pref
import com.breezefieldflexibond.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezefieldflexibond.features.newcollection.model.NewCollectionListResponseModel
import com.breezefieldflexibond.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}