package com.flexibond.features.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flexibond.app.AppConstant

@Entity(tableName = AppConstant.TBL_SHOP_FEEDBACK)
class ShopFeedbackEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "shop_id")
    var shop_id: String? = null

    @ColumnInfo(name = "feedback")
    var feedback: String? = null

    @ColumnInfo(name = "date_time")
    var date_time: String? = null

}