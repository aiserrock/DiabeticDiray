package com.zlogene.diabeticdiray.ui.screen.graph

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.zlogene.diabeticdiray.databinding.FragmentGraphBinding
import com.zlogene.diabeticdiray.model.RecordingEntity

class GraphFragment : Fragment() {
    private var binding: FragmentGraphBinding? = null
    private val viewModel: GraphViewModel by activityViewModels()
    private var mNumLabels = 4

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGraphBinding.inflate(
            layoutInflater, container, false
        )



        viewModel.records.observe(viewLifecycleOwner, { updateGraph(it) })

        return binding!!.root
    }

    private fun updateGraph(it: MutableList<RecordingEntity>?) {

        // Set Graph
        val graph = binding?.graph as GraphView

        // title axis
        graph.gridLabelRenderer.verticalAxisTitle  = "Value"
        graph.gridLabelRenderer.horizontalAxisTitle  = "Date"

        // clear old series
        graph.series.clear()
        // getting data from db
        if (it != null) {
            val dataSugar = arrayOfNulls<DataPoint>(it.size)
            for((index, value) in it.withIndex()){
                dataSugar[index] = DataPoint(value.date, value.sugar.toDouble())
            }
            val dataInsulin = arrayOfNulls<DataPoint>(it.size)
            for((index, value) in it.withIndex()){
                dataInsulin[index] = DataPoint(value.date, value.insulin.toDouble())
            }

            // Setup sugar series
            val sugarSeries = LineGraphSeries(dataSugar)
            // styling series
            sugarSeries.title = "Sugar"
            sugarSeries.color = Color.GREEN
            sugarSeries.isDrawDataPoints = true
            sugarSeries.thickness = 8
            graph.addSeries(sugarSeries)

            // Setup insulin series
            val insulinSeries = LineGraphSeries(dataInsulin)
            // styling series
            insulinSeries.title = "Insulin"
            insulinSeries.color = Color.BLUE
            insulinSeries.isDrawDataPoints = true
            insulinSeries.thickness = 8
            graph.addSeries(insulinSeries)

            // legend
            graph.legendRenderer.isVisible = true
            graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP

            // set date label formatter
            graph.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(graph.context)
            graph.gridLabelRenderer.numHorizontalLabels = mNumLabels
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
