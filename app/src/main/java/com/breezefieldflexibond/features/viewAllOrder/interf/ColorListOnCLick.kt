package com.breezefieldflexibond.features.viewAllOrder.interf

import com.breezefieldflexibond.app.domain.NewOrderGenderEntity
import com.breezefieldflexibond.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}