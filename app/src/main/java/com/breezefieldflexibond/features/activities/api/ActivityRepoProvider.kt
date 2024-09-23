package com.breezefieldflexibond.features.activities.api

import com.breezefieldflexibond.features.member.api.TeamApi
import com.breezefieldflexibond.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}