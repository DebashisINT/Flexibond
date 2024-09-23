package com.breezefieldflexibond.features.nearbyshops.presentation

import android.app.Dialog
import com.breezefieldflexibond.app.domain.AddShopDBModelEntity

/**
 * Created by Kinsuk on 16-11-2017.
 */
interface ShopAddressUpdateListener {
     fun onUpdateClick(address: AddShopDBModelEntity?)
     fun getDialogInstance(mdialog: Dialog?)
     fun onAddedDataSuccess()
}