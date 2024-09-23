package com.breezefieldflexibond.features.viewAllOrder.orderOptimized

import com.breezefieldflexibond.app.domain.ProductOnlineRateTempEntity
import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}