package com.flexibond.features.viewAllOrder.interf

import com.flexibond.app.domain.NewOrderGenderEntity
import com.flexibond.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}