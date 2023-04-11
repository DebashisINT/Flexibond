package com.flexibond.features.photoReg.present

import com.flexibond.app.domain.ProspectEntity
import com.flexibond.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}