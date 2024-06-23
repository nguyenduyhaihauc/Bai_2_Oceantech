package duyndph34554.fpoly.bai_2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import duyndph34554.fpoly.bai_2.R
import duyndph34554.fpoly.bai_2.databinding.FragmentDessertBinding
import duyndph34554.fpoly.bai_2.viewModel.FoodViewModel


class DessertFragment : Fragment() {

    private var _binding: FragmentDessertBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        // Thiết lập trạng thái của các checkbox
        foodViewModel.checkboxStates.observe(viewLifecycleOwner) { checkboxStates ->
            binding.chkDessert1.isChecked = checkboxStates["Banh ngot"] ?: false
            binding.chkDessert2.isChecked = checkboxStates["Kem"] ?: false
            binding.chkDessert3.isChecked = checkboxStates["Hoa qua"] ?: false
        }

        // Xử lý sự kiện checkbox được nhấn
        binding.chkDessert1.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Banh ngot", isChecked)
        }

        binding.chkDessert2.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Kem", isChecked)
        }

        binding.chkDessert3.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Hoa qua", isChecked)
        }

        binding.btnNextDessert.setOnClickListener {
            findNavController().navigate(R.id.action_dessertFragment_to_beverageFragment)
        }
        binding.btnBackDessert.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}