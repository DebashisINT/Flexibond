package com.flexibond.features.viewAllOrder.orderOptimized

import com.flexibond.app.domain.ProductOnlineRateTempEntity
import com.flexibond.base.BaseResponse
import com.flexibond.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}