package com.flexibond.features.performanceAPP.model

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels

class ChartDataModelNew {
    companion object{

        fun configurePieChart(attendP:Int,absentP : Int): AAChartModel {
            return AAChartModel()
                .chartType(AAChartType.Pie)
                .backgroundColor("#ffffff")
                .title("")
                .subtitle("")
                .colorsTheme(arrayOf("#0019b2", "#f5862c"))
                .dataLabelsEnabled(true)//是否直接显示扇形图数据
                .yAxisTitle("℃")
                .series(arrayOf(
                    AASeriesElement()
                        .name("")
                        .innerSize("60%")
                        .size(90)
                        .dataLabels(AADataLabels()
                            .enabled(true)
                            .useHTML(true)
                            .distance(10)
                            .format("<b></b> {point.percentage:.1f} %"))
                        .data(arrayOf(
                            arrayOf("Present",   attendP),
                            arrayOf("Absent", absentP)
                        ))))
        }
        fun configurePolarColumnChart(): AAChartModel {
            return AAChartModel()
                .chartType(AAChartType.Column)
                .polar(false)
                .dataLabelsEnabled(true)
                .legendEnabled(false)
                .yAxisTitle("")
                .colorsTheme(arrayOf("#0019b2", "#f5862c","#E7310A", "#E4E40E"))
                .categories(arrayOf("January", "February","March","April"))
                .series(arrayOf(
                    AASeriesElement()
                        .name("")
                        .colorByPoint(true)
                        .data(arrayOf(1000, 1500,2000,3000))
                ))
        }

        fun configurePolarBarChart(): AAChartModel {
            return AAChartModel()
                .chartType(AAChartType.Bar)
                .polar(false)
                .dataLabelsEnabled(true)
                .legendEnabled(false)
                .yAxisTitle("")
                .colorsTheme(arrayOf("#0019b2", "#f5862c","#E7310A", "#E4E40E"))
                .categories(arrayOf("January", "February","March","April"))
                .series(arrayOf(
                    AASeriesElement()
                        .name("")
                        .colorByPoint(true)
                        .data(arrayOf(1000, 1500,2000,3000))
                ))
        }
    }


}