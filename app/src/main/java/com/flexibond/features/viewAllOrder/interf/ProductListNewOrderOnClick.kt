package com.flexibond.features.viewAllOrder.interf

import com.flexibond.app.domain.NewOrderGenderEntity
import com.flexibond.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}