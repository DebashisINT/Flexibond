package com.breezefieldflexibond.features.survey.api

import com.breezefieldflexibond.features.photoReg.api.GetUserListPhotoRegApi
import com.breezefieldflexibond.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}