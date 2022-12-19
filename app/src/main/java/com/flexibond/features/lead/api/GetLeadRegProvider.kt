package com.flexibond.features.lead.api

import com.flexibond.features.NewQuotation.api.GetQuotListRegRepository
import com.flexibond.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}