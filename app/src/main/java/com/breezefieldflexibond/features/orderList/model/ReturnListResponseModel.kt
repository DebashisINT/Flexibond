package com.breezefieldflexibond.features.orderList.model

import com.breezefieldflexibond.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}