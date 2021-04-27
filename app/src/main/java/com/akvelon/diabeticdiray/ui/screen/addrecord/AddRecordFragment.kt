package com.akvelon.diabeticdiray.ui.screen.addrecord

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.akvelon.diabeticdiray.R
import com.akvelon.diabeticdiray.database.RecordingDatabase
import com.akvelon.diabeticdiray.databinding.FragmentAddRecordBinding

class AddRecordFragment : Fragment() {
    private lateinit var viewModel: AddRecordViewModel
    private var binding: FragmentAddRecordBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create viewModel
        val application = requireNotNull(this.activity).application
        val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
        val viewModelFactory = AddRecordViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(AddRecordViewModel::class.java)

        binding = FragmentAddRecordBinding.inflate(
            layoutInflater, container, false
        )

        // Set Action bar Menu
        setHasOptionsMenu(true)

        return binding!!.root
    }

    fun correctFields(): Boolean {
        if (binding!!.sugarEditText.text.toString().isNotEmpty() &&
            binding!!.insulinEditText.text.toString().isNotEmpty()
        )
            return true
        return false
    }

    fun saveButtonPressed() {
        if (correctFields()) {
            viewModel.addRecord(
                binding!!.sugarEditText.text.toString(),
                binding!!.insulinEditText.text.toString(),
                binding!!.noteEditText.text.toString()
            )
            Toast.makeText(context, "added successful", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addRecordFragment_to_listFragment)
        } else {
            Toast.makeText(context, "error, not all fields field", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            saveButtonPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
