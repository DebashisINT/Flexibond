package com.flexibond.features.newcollectionreport

import com.flexibond.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}