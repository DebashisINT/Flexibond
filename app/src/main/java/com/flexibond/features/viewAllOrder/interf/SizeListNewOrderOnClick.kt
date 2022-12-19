package com.flexibond.features.viewAllOrder.interf

import com.flexibond.app.domain.NewOrderProductEntity
import com.flexibond.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}