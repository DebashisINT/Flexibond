package com.flexibond.features.viewAllOrder.model

import com.flexibond.app.domain.NewOrderColorEntity
import com.flexibond.app.domain.NewOrderGenderEntity
import com.flexibond.app.domain.NewOrderProductEntity
import com.flexibond.app.domain.NewOrderSizeEntity
import com.flexibond.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

