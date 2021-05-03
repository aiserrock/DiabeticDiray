package com.zlogene.diabeticdiray.ui.screen.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zlogene.diabeticdiray.database.RecordingDatabase
import com.zlogene.diabeticdiray.databinding.FragmentStatisticsBinding


class StatisticsFragment : Fragment() {
    private lateinit var viewModel: StatisticsViewModel
    private var binding: FragmentStatisticsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Create viewModel
        val application = requireNotNull(this.activity).application
        val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
        val viewModelFactory = StatisticsViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(StatisticsViewModel::class.java)

        binding = FragmentStatisticsBinding.inflate(
            layoutInflater, container, false
        )

//        binding?.weekMinTextView?.text = viewModel.weekStatSugar.
//        binding?.weekAvgTextView?.text
//        binding?.weekMinTextView?.text


//        binding?.weekMinTextView?.text = viewModel.weekStat.toString()
//        binding?.weekMinTextView?.text = viewModel.weekStat.
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}