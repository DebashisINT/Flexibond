package com.breezefieldflexibond.features.login.model.productlistmodel

import com.breezefieldflexibond.app.domain.ModelEntity
import com.breezefieldflexibond.app.domain.ProductListEntity
import com.breezefieldflexibond.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}