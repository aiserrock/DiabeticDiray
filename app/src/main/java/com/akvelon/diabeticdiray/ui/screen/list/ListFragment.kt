package com.akvelon.diabeticdiray.ui.screen.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.akvelon.diabeticdiray.R
import com.akvelon.diabeticdiray.database.RecordingDatabase
import com.akvelon.diabeticdiray.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        val application = requireNotNull(this.activity).application
        val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
        val viewModelFactory = ListViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListViewModel::class.java)

        binding.addRecording.setOnClickListener {
            viewModel.onAddButtonPressed()
        }

        return binding.root
    }
}
