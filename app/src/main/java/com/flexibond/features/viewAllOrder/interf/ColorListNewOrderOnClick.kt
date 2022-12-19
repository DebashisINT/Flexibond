package com.flexibond.features.viewAllOrder.interf

import com.flexibond.app.domain.NewOrderColorEntity
import com.flexibond.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}