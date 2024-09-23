package com.breezefieldflexibond.features.viewAllOrder.interf

import com.breezefieldflexibond.app.domain.NewOrderGenderEntity
import com.breezefieldflexibond.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}