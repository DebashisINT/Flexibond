package com.breezefieldflexibond.features.averageshop.model

import com.breezefieldflexibond.base.BaseResponse

/**
 * Created by Pratishruti on 07-12-2017.
 */
class ShopActivityResponse:BaseResponse(){
    var toal_shopvisit_count:String?=null
    var avg_shopvisit_count:String?=null
    var date_list:List<ShopActivityResponseDataList>?=null
}