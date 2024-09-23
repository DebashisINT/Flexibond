package com.breezefieldflexibond.features.newcollection.model

import com.breezefieldflexibond.app.domain.CollectionDetailsEntity
import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}