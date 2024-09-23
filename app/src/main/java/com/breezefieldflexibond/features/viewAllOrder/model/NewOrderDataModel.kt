package com.breezefieldflexibond.features.viewAllOrder.model

import com.breezefieldflexibond.app.domain.NewOrderColorEntity
import com.breezefieldflexibond.app.domain.NewOrderGenderEntity
import com.breezefieldflexibond.app.domain.NewOrderProductEntity
import com.breezefieldflexibond.app.domain.NewOrderSizeEntity
import com.breezefieldflexibond.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

