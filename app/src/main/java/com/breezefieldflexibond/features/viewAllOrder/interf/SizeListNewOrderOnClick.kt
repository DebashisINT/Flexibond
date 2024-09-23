package com.breezefieldflexibond.features.viewAllOrder.interf

import com.breezefieldflexibond.app.domain.NewOrderProductEntity
import com.breezefieldflexibond.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}