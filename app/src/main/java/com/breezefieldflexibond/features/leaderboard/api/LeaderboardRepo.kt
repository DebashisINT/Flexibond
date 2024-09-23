package com.breezefieldflexibond.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.breezefieldflexibond.app.FileUtils
import com.breezefieldflexibond.app.Pref
import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.addshop.model.AddLogReqData
import com.breezefieldflexibond.features.addshop.model.AddShopRequestData
import com.breezefieldflexibond.features.addshop.model.AddShopResponse
import com.breezefieldflexibond.features.addshop.model.LogFileResponse
import com.breezefieldflexibond.features.addshop.model.UpdateAddrReq
import com.breezefieldflexibond.features.contacts.CallHisDtls
import com.breezefieldflexibond.features.contacts.CompanyReqData
import com.breezefieldflexibond.features.contacts.ContactMasterRes
import com.breezefieldflexibond.features.contacts.SourceMasterRes
import com.breezefieldflexibond.features.contacts.StageMasterRes
import com.breezefieldflexibond.features.contacts.StatusMasterRes
import com.breezefieldflexibond.features.contacts.TypeMasterRes
import com.breezefieldflexibond.features.dashboard.presentation.DashboardActivity
import com.breezefieldflexibond.features.login.model.WhatsappApiData
import com.breezefieldflexibond.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}