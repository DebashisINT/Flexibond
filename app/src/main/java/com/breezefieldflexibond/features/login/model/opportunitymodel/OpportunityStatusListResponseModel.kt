package com.breezefieldflexibond.features.login.model.opportunitymodel

import com.breezefieldflexibond.app.domain.OpportunityStatusEntity
import com.breezefieldflexibond.app.domain.ProductListEntity
import com.breezefieldflexibond.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}