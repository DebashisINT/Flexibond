package com.flexibond.features.newcollection.model

import com.flexibond.app.domain.CollectionDetailsEntity
import com.flexibond.base.BaseResponse
import com.flexibond.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}