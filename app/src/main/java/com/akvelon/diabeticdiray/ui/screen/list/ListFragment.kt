package com.akvelon.diabeticdiray.ui.screen.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        setHasOptionsMenu(true)

        // Create viewModel
        val application = requireNotNull(this.activity).application
        val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
        val viewModelFactory = ListViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListViewModel::class.java)

        // Set RecyclerView
        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.records.observe(
            viewLifecycleOwner,
            { records ->
                if (records != null)
                    adapter.recordings = records
            }
        )

        // AddRecording button Listener
        binding.addRecording.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addRecordFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete_all) {
            viewModel.deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }
}
