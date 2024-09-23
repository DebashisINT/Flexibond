package com.breezefieldflexibond.features.document.api

import com.breezefieldflexibond.features.dymanicSection.api.DynamicApi
import com.breezefieldflexibond.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}