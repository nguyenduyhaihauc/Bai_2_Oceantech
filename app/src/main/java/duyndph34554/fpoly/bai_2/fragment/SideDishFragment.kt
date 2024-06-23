package duyndph34554.fpoly.bai_2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import duyndph34554.fpoly.bai_2.R
import duyndph34554.fpoly.bai_2.databinding.FragmentSideDishBinding
import duyndph34554.fpoly.bai_2.viewModel.FoodViewModel

class SideDishFragment : Fragment() {

    private var _binding: FragmentSideDishBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSideDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

//        Thiet lap
        foodViewModel.checkboxStates.observe(viewLifecycleOwner) { checkboxState ->
            binding.chkSideDish1.isChecked = checkboxState["Dau tam hanh"] ?: false
            binding.chkSideDish2.isChecked = checkboxState["Top mo"] ?:false
            binding.chkSideDish3.isChecked = checkboxState["Long xao dua"] ?: false
        }

//        Xu ly
        binding.chkSideDish1.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Dua tam hanh", isChecked)
        }

        binding.chkSideDish2.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Top mo", isChecked)
        }

        binding.chkSideDish3.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Long xao dua", isChecked)
        }

        binding.btnNextSideDish.setOnClickListener {
            findNavController().navigate(R.id.action_sideDishFragment_to_dessertFragment)
        }

        binding.btnBackSideDish.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}