package com.breezefieldflexibond.features.addshop.api.assignToPPList

import com.breezefieldflexibond.app.Pref
import com.breezefieldflexibond.features.addshop.model.assigntopplist.AssignToPPListResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 03-10-2018.
 */
class AssignToPPListRepo(val apiService: AssignToPPListApi) {
    fun assignToPPList(state_id: String): Observable<AssignToPPListResponseModel> {
        return apiService.getAssignedToPPList(Pref.session_token!!, Pref.user_id!!, state_id)
    }
}