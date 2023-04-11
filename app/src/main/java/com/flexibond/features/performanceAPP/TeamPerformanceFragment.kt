package com.flexibond.features.performanceAPP

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.flexibond.R
import com.flexibond.app.AppDatabase
import com.flexibond.app.NetworkConstant
import com.flexibond.app.Pref
import com.flexibond.app.utils.AppUtils
import com.flexibond.app.utils.ToasterMiddle
import com.flexibond.base.presentation.BaseActivity
import com.flexibond.base.presentation.BaseFragment
import com.flexibond.features.NewQuotation.dialog.MemberSalesmanListDialog
import com.flexibond.features.attendance.api.AttendanceRepositoryProvider
import com.flexibond.features.attendance.model.AttendanceRequest
import com.flexibond.features.attendance.model.AttendanceResponse
import com.flexibond.features.dashboard.presentation.DashboardActivity
import com.flexibond.features.member.api.TeamRepoProvider
import com.flexibond.features.member.model.TeamListDataModel
import com.flexibond.features.member.model.TeamListResponseModel
import com.flexibond.features.performanceAPP.model.ChartDataModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Saheli on 26-03-2023.
 */
class TeamPerformanceFragment: BaseFragment(), View.OnClickListener {
    private lateinit var aaChart : AAChartView
    private lateinit var tv_present_atten: TextView
    private lateinit var tv_absent_atten: TextView
    private lateinit var tv_AttendHeader: TextView
    private lateinit var mContext: Context

    var calendar: Calendar = Calendar.getInstance()
    var inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    var outputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)

    private var member_list: ArrayList<TeamListDataModel>? = null
    private lateinit var tv_sel_team_member:TextView
    private var sel_team_userID: String =""
    private lateinit var atten_ll_frag_team_per:LinearLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_team_performance, container, false)
       /* if(AppUtils.isOnline(this)){
            getTeamList()
        }else{
            ToasterMiddle.msgShort(mContext,"Internet not connected.")
        }*/
        getTeamList()
        initView(view)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initView(view: View) {
        /*  tv_AttendHeader = view.findViewById(R.id.tv_frag_own_perf_attend_heading)

          val text = "<font color=" + context?.resources?.getColor(R.color.black) + ">Attendance Report</font> <font color="+
                  context?.resources?.getColor(R.color.gray_50) + ">" + "(Last Month)" + "</font>"
          tv_AttendHeader.text = Html.fromHtml(text)*/


        aaChart = view.findViewById<AAChartView>(R.id.aa_chart_view)
        tv_present_atten = view.findViewById(R.id.tv_frag_own_performance_present_atten)
        tv_absent_atten = view.findViewById(R.id.tv_frag_own_performance_absent_atten)
        tv_sel_team_member = view.findViewById(R.id.tv_frag_team_performnace_sel_team_member)
        atten_ll_frag_team_per =  view.findViewById(R.id.atten_ll_frag_team_per)
        tv_sel_team_member.setOnClickListener(this)



    }

    private fun callAttendanceListApi(attendanceReq: AttendanceRequest, firstDate:String, lastDate:String, daysInMonth:Int) {
        /* val outFirstDate = inputFormat.parse(firstDate)
         val formattedFirstDate = outputFormat.format(outFirstDate)
         val outEndDate = inputFormat.parse(lastDate)
         val formattedLastDate = outputFormat.format(outEndDate)*/
        val repository = AttendanceRepositoryProvider.provideAttendanceRepository()
        BaseActivity.compositeDisposable.add(
            repository.getAttendanceList(attendanceReq)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    val attendanceList = result as AttendanceResponse
                    if (attendanceList.status == NetworkConstant.SUCCESS) {
//                        val filteredAttendanceRecords = attendanceList.shop_list!!.filter { it.login_date!! in formattedFirstDate..formattedLastDate && it.Isonleave!!.equals("false")  }
                        val filteredAttendanceRecords = attendanceList.shop_list!!.filter { it.Isonleave!!.equals("false")  }
                        val numPresentAttendances = filteredAttendanceRecords.count()
                        val numAbsentAttendances = daysInMonth-filteredAttendanceRecords.count()
                        println("Present & Absent attendance " + numPresentAttendances + numAbsentAttendances)
                        tv_present_atten.setText(numPresentAttendances.toString())
                        tv_absent_atten.setText(numAbsentAttendances.toString())
                        viewAttendanceReport(numPresentAttendances,numAbsentAttendances)

                    } else if (attendanceList.status == NetworkConstant.SESSION_MISMATCH) {

                    } else if (attendanceList.status == NetworkConstant.NO_DATA) {

                    } else {

                    }
                }, { error ->
                })
        )

    }

    fun viewAttendanceReport(attend:Int,absent:Int){
        aaChart.aa_drawChartWithChartModel(ChartDataModel.configurePieChart(attend,absent))
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.tv_frag_team_performnace_sel_team_member->{
                loadTeamMember()
            }
        }
    }

    private fun getTeamList() {
      if (!AppUtils.isOnline(mContext)) {
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_internet))
            return
        }
        val repository = TeamRepoProvider.teamRepoProvider()
        BaseActivity.compositeDisposable.add(
            repository.teamList(Pref.user_id!!, true, false)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    val response = result as TeamListResponseModel
                    if (response.status == NetworkConstant.SUCCESS) {
                        if (response.member_list != null && response.member_list!!.size > 0) {
                            member_list = response.member_list!!
                            println("member_list"+member_list!!)
                        } else {
                            (mContext as DashboardActivity).showSnackMessage(response.message!!)
                        }

                    }
                         else {
                        }
                }, { error ->
                    Timber.d("GET TEAM DATA PERFORMANCE: " + "ERROR : " + "\n" + "Time : " + AppUtils.getCurrentDateTime() + ", USER :" + Pref.user_name + ",MESSAGE : " + error.localizedMessage)
                    error.printStackTrace()


                })
        )
    }

    private fun loadTeamMember() {
        MemberSalesmanListDialog.newInstance("Select Team Member",member_list!!){
            tv_sel_team_member.text=it.user_name
            sel_team_userID=it.user_id
            atten_ll_frag_team_per.visibility = View.VISIBLE
            loadAttendanceData()
        }.show((mContext as DashboardActivity).supportFragmentManager, "")

    }

    private fun loadAttendanceData() {
        calendar.add(Calendar.MONTH, -1)
        val sdf = SimpleDateFormat("MMM")
        val lastMonthDate: String = sdf.format(calendar.time)
        val daysInMonth: Int = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.setTime(sdf.parse(lastMonthDate))
        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR))
        val sdf1 = SimpleDateFormat("yyyy-MM-dd")
        val firstDate = sdf1.format(calendar.time)
        calendar[Calendar.DAY_OF_MONTH] = daysInMonth
        val lastDate = sdf1.format(calendar.time)
        println("Month " + lastMonthDate)
        println("month in days " + daysInMonth)
        println("1st Date $lastMonthDate month " + firstDate)
        println("End Date $lastMonthDate month " + lastDate)
        val attendanceReq = AttendanceRequest()
        attendanceReq.user_id = sel_team_userID
        attendanceReq.session_token = Pref.session_token
        attendanceReq.start_date = firstDate
        attendanceReq.end_date = lastDate
        callAttendanceListApi(attendanceReq,firstDate,lastDate,daysInMonth)
    }
}