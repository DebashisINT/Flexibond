package com.breezefieldflexibond.features.mylearning.apiCall

import com.breezefieldflexibond.features.login.api.opportunity.OpportunityListApi
import com.breezefieldflexibond.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}