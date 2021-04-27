package com.akvelon.diabeticdiray.ui.screen.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.akvelon.diabeticdiray.databinding.FragmentGraphBinding
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.util.*

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

        // generate Dates
        val calendar = Calendar.getInstance()
        val d1 = calendar.time
        calendar.add(Calendar.DATE, 1)
        val d2 = calendar.time
        calendar.add(Calendar.DATE, 1)
        val d3 = calendar.time

        // val list = viewModel.records24hour

        // Set Graph
        val graph = binding?.graph as GraphView
        val series = LineGraphSeries(
            arrayOf(
                DataPoint(d1, 1.0),
                DataPoint(d2, 5.1),
                DataPoint(d3, 3.3),
            )
        )
        graph.addSeries(series)

        // set date label formatter
        graph.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(graph.context)
        graph.gridLabelRenderer.numHorizontalLabels = mNumLabels

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
