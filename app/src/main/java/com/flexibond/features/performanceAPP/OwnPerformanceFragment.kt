package com.flexibond.features.performanceAPP

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.FileProvider
import com.flexibond.R
import com.flexibond.app.AppDatabase
import com.flexibond.app.NetworkConstant
import com.flexibond.app.Pref
import com.flexibond.app.utils.Toaster
import com.flexibond.base.presentation.BaseActivity
import com.flexibond.base.presentation.BaseFragment
import com.flexibond.features.attendance.api.AttendanceRepositoryProvider
import com.flexibond.features.attendance.model.AttendanceRequest
import com.flexibond.features.attendance.model.AttendanceResponse
import com.flexibond.features.dashboard.presentation.DashboardActivity
import com.flexibond.features.performanceAPP.model.ChartDataModel
import com.flexibond.features.performanceAPP.model.ChartDataModelNew
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfContentByte
import com.itextpdf.text.pdf.PdfWriter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.inflate_member_pjp.view.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Saheli on 26-03-2023.
 */

class OwnPerformanceFragment: BaseFragment(), View.OnClickListener {

    private lateinit var mContext: Context

    private lateinit var aaChart : AAChartView
    private lateinit var aaChart1 : AAChartView
    private lateinit var aaChart2 : AAChartView
    private lateinit var tv_present_atten:TextView
    private lateinit var tv_absent_atten:TextView

    private lateinit var tv_AttendHeader:TextView
    private lateinit var iv_frag_performance_attenshare:ImageView

    private lateinit var ll_attend_view:LinearLayout

    var calendar: Calendar = Calendar.getInstance()
    var inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    var outputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_own_performance, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {

        ll_attend_view = view.findViewById(R.id.ll_attend_view)

        tv_AttendHeader = view.findViewById(R.id.tv_frag_own_perf_attend_heading)
        iv_frag_performance_attenshare = view.findViewById(R.id.iv_frag_performance_attenshare)
        iv_frag_performance_attenshare.setOnClickListener(this)
      /*  tv_AttendHeader = view.findViewById(R.id.tv_frag_own_perf_attend_heading)

        val text = "<font color=" + context?.resources?.getColor(R.color.black) + ">Attendance Report</font> <font color="+
                context?.resources?.getColor(R.color.gray_50) + ">" + "(Last Month)" + "</font>"
        tv_AttendHeader.text = Html.fromHtml(text)*/


        aaChart = view.findViewById<AAChartView>(R.id.aa_chart_view)
        aaChart1 = view.findViewById<AAChartView>(R.id.aa_chart_view1)
        aaChart2 = view.findViewById<AAChartView>(R.id.aa_chart_view2)
        tv_present_atten = view.findViewById(R.id.tv_frag_own_performance_present_atten)
        tv_absent_atten = view.findViewById(R.id.tv_frag_own_performance_absent_atten)

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
        // room used data filter
        val attendancePresent = AppDatabase.getDBInstance()!!.userAttendanceDataDao().getAttendanceCountPresentwise(firstDate,lastDate,false)
        println("Present attendance " + attendancePresent)
        val attendanceReq = AttendanceRequest()
        attendanceReq.user_id = Pref.user_id
        attendanceReq.session_token = Pref.session_token
        attendanceReq.start_date = firstDate
        attendanceReq.end_date = lastDate
        callAttendanceListApi(attendanceReq,firstDate,lastDate,daysInMonth)


    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun callAttendanceListApi(attendanceReq: AttendanceRequest,firstDate:String,lastDate:String,daysInMonth:Int) {
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
        aaChart.aa_drawChartWithChartModel(ChartDataModelNew.configurePieChart(attend,absent))
        aaChart1.aa_drawChartWithChartModel(ChartDataModelNew.configurePolarColumnChart())
        aaChart2.aa_drawChartWithChartModel(ChartDataModelNew.configurePolarBarChart())


       Handler().postDelayed(Runnable {
            var totalH:Int = ll_attend_view.height
            var totalW:Int = ll_attend_view.width
            ll_attend_view.isDrawingCacheEnabled = true
            var b:Bitmap = Bitmap.createBitmap(ll_attend_view.getDrawingCache())
            ll_attend_view.isDrawingCacheEnabled = false
        }, 5000)

    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun ShareDataAsPdf(ReportName: String) {
        var document: Document = Document(PageSize.A4, 36f, 36f, 36f, 80f)

        val time = System.currentTimeMillis()
        var fileName = ReportName.toUpperCase() +  "_" + time
        fileName=fileName.replace("/", "_")
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()+"/FSMApp/PERFORMANCE/"

        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }

        try{
            //PdfWriter.getInstance(document, FileOutputStream(path + fileName + ".pdf"))
            var pdfWriter :PdfWriter = PdfWriter.getInstance(document, FileOutputStream(path + fileName + ".pdf"))

            document.open()
            var font: Font = Font(Font.FontFamily.HELVETICA, 10f, Font.BOLD)
            val companydel = Paragraph(ReportName, font)
            companydel.alignment = Element.ALIGN_CENTER

            val projectName = Paragraph("Project Name : ", font)
            projectName.alignment = Element.ALIGN_LEFT
            projectName.spacingAfter = 5f
            document.add(projectName)

            ll_attend_view.isDrawingCacheEnabled = true
            var bitM:Bitmap = Bitmap.createBitmap(ll_attend_view.getDrawingCache())
            ll_attend_view.isDrawingCacheEnabled = false
            val bitmapPrint = Bitmap.createScaledBitmap(bitM, bitM.width, bitM.height, false);

            val stream = ByteArrayOutputStream()
            bitmapPrint.compress(Bitmap.CompressFormat.PNG, 100, stream)

            var img: Image? = null
            val byteArray: ByteArray = stream.toByteArray()
            try {
                img = Image.getInstance(byteArray)
                img.scaleToFit(190f, 90f)
                img.scalePercent(20f)
                img.alignment = Image.ALIGN_LEFT
            } catch (e: BadElementException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            //val pHead = Paragraph()
            //pHead.add(Chunk(img, 90f, -90f))
            //document.add(pHead)

            document.add(img)

            val projectN = Paragraph("Project N : ", font)
            projectN.alignment = Element.ALIGN_LEFT
            projectN.spacingAfter = 5f
            document.add(projectN)

            document.close()

            var sendingPath=path+fileName+".pdf"
           if (!TextUtils.isEmpty(sendingPath)) {
                try {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    val fileUrl = Uri.parse(sendingPath)
                    val file = File(fileUrl.path)
                    val uri: Uri = FileProvider.getUriForFile(mContext, context!!.applicationContext.packageName.toString() + ".provider", file)
                    shareIntent.type = "image/png"
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
                    startActivity(Intent.createChooser(shareIntent, "Share pdf using"))
                } catch (e: Exception) {
                    e.printStackTrace()
                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                }
            }
        }catch (ex: Exception){
            ex.printStackTrace()
            Toaster.msgShort(mContext, ex.message.toString())
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
        }

    }

    fun get_Resized_Bitmap(bmp: Bitmap, newHeight: Int, newWidth: Int): Bitmap? {
        val width = bmp.width
        val height = bmp.height
        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height
        // CREATE A MATRIX FOR THE MANIPULATION
        val matrix = Matrix()
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight)
        // "RECREATE" THE NEW BITMAP
        return Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, false)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.iv_frag_performance_attenshare->{
                ShareDataAsPdf("Attendance REPORT")
            }
        }
    }
}