package com.breezefieldflexibond.features.viewAllOrder.interf

import com.breezefieldflexibond.app.domain.NewOrderGenderEntity
import com.breezefieldflexibond.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}