package com.zlogene.diabeticdiray.ui.screen.graph

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.zlogene.diabeticdiray.databinding.FragmentGraphBinding
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.zlogene.diabeticdiray.model.RecordingEntity
import java.util.*

class GraphFragment : Fragment() {
    private var binding: FragmentGraphBinding? = null
    private val viewModel: GraphViewModel by activityViewModels()
    private var mNumLabels = 3

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
        //val data = mutableListOf<DataPoint>()

        //TODO раскрасить разными цветами серии и добавить легенду
        if (it != null) {
            val dataSugar = arrayOfNulls<DataPoint>(it.size)
            for((index,value) in it.withIndex()){
                dataSugar[index] = DataPoint(value.date,value.sugar.toDouble())
            }
            val dataInsulin = arrayOfNulls<DataPoint>(it.size)
            for((index,value) in it.withIndex()){
                dataInsulin[index] = DataPoint(value.date,value.insulin.toDouble())
            }
            val sugarSeries = LineGraphSeries(dataSugar)
            val insulinSeries = LineGraphSeries(dataInsulin)
            graph.addSeries(sugarSeries)
            graph.addSeries(insulinSeries)

            // set date label formatter
            graph.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(graph.context)
            graph.gridLabelRenderer.numHorizontalLabels = mNumLabels
        }

    }

    //private fun DataPoint(d1: Date, toFloat: Float): DataPoint = DataPoint(d1,5.1)

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
