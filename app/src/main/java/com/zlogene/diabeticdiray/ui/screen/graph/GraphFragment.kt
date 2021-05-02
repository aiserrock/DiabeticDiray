package com.zlogene.diabeticdiray.ui.screen.graph

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.zlogene.diabeticdiray.database.RecordingDatabase
import com.zlogene.diabeticdiray.databinding.FragmentGraphBinding
import com.zlogene.diabeticdiray.model.RecordingEntity
import com.zlogene.diabeticdiray.ui.screen.list.ListViewModel
import com.zlogene.diabeticdiray.ui.screen.list.ListViewModelFactory
import com.zlogene.diabeticdiray.util.DataConverter


class GraphFragment : Fragment() {
    private var binding: FragmentGraphBinding? = null
    private lateinit var viewModel: GraphViewModel
    private lateinit var graphicView: LineChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create viewModel
        val application = requireNotNull(this.activity).application
        val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
        val viewModelFactory = GraphViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GraphViewModel::class.java)

        viewModel.records.observe(viewLifecycleOwner, {
            updateGraphic(it)
        })

        binding = FragmentGraphBinding.inflate(
            layoutInflater, container, false
        )

        graphicView = binding?.chart as LineChart
        graphicView.isDragEnabled = true
        graphicView.setScaleEnabled(true)

        val tmp = viewModel.records.value

        return binding!!.root
    }

    private fun updateGraphic(f: MutableList<RecordingEntity>) {
        try {
            graphicView.clear()
            val dataSets: ArrayList<ILineDataSet> = ArrayList()
            val entries = mutableListOf<Entry>()
            for (function in f) {
                entries.add(Entry(15f, 20f))
            }
            val series = LineDataSet(entries, "Sugar")
            series.color = Color.BLUE
            series.valueTextSize = 0.0F
            series.setDrawCircles(false)
            series.setDrawCircleHole(false)
            series.lineWidth = 10f
            dataSets.add(series)
            val data = LineData(dataSets)
            graphicView.data = data
            graphicView.notifyDataSetChanged()
        } catch (e: Exception) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
