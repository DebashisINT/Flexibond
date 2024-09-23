package com.breezefieldflexibond.features.photoReg.present

import com.breezefieldflexibond.app.domain.ProspectEntity
import com.breezefieldflexibond.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}