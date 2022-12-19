package com.flexibond.features.login.model.productlistmodel

import com.flexibond.app.domain.ModelEntity
import com.flexibond.app.domain.ProductListEntity
import com.flexibond.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}