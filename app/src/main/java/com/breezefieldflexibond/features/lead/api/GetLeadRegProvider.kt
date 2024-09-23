package com.breezefieldflexibond.features.lead.api

import com.breezefieldflexibond.features.NewQuotation.api.GetQuotListRegRepository
import com.breezefieldflexibond.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}