package com.zlogene.diabeticdiray.ui.screen.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.zlogene.diabeticdiray.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {
    private var binding: FragmentStatisticsBinding? = null
    private val viewModel: StatisticsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatisticsBinding.inflate(
            layoutInflater, container, false
        )
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
