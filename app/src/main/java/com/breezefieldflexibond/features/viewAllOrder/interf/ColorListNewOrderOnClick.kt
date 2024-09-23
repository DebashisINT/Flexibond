package com.breezefieldflexibond.features.viewAllOrder.interf

import com.breezefieldflexibond.app.domain.NewOrderColorEntity
import com.breezefieldflexibond.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}