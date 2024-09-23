package com.breezefieldflexibond.features.newcollectionreport

import com.breezefieldflexibond.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}