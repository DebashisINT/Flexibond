package com.flexibond.features.attendance.api

import com.flexibond.features.attendance.model.AttendanceRequest
import com.flexibond.features.attendance.model.AttendanceResponse
import com.flexibond.features.attendance.model.DayStartEndListResponse
import io.reactivex.Observable

/**
 * Created by Pratishruti on 30-11-2017.
 */
class AttendanceListRepository(val apiService: AttendanceListApi) {
    fun getAttendanceList(attendanceRequest: AttendanceRequest?): Observable<AttendanceResponse> {
        return apiService.getAttendanceList(attendanceRequest)
    }

    fun getDayStartEndList(attendanceRequest: AttendanceRequest?): Observable<DayStartEndListResponse> {
        return apiService.getDayStartEndListAPI(attendanceRequest)
    }
}