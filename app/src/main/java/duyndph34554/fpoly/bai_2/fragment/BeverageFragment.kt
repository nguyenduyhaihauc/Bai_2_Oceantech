package duyndph34554.fpoly.bai_2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import duyndph34554.fpoly.bai_2.R
import duyndph34554.fpoly.bai_2.databinding.FragmentBeverageBinding
import duyndph34554.fpoly.bai_2.viewModel.FoodViewModel

class BeverageFragment : Fragment() {

    private var _binding: FragmentBeverageBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeverageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

//        Thiet lap trang thai checkBox
        foodViewModel.checkboxStates.observe(viewLifecycleOwner) { checkboxState ->
            binding.chkBeverage1.isChecked = checkboxState["Nuoc cam"] ?: false
            binding.chkBeverage2.isChecked = checkboxState["Nuoc tao"] ?: false
            binding.chkBeverage3.isChecked = checkboxState["Nuoc oi"] ?: false
        }

//        Xu ly su kien checkBox duoc nhan
        binding.chkBeverage1.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Nuoc cam", isChecked)
        }

        binding.chkBeverage2.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Nuoc tao", isChecked)
        }

        binding.chkBeverage3.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Nuoc oi", isChecked)
        }

        binding.btnNextBeverage.setOnClickListener {
            findNavController().navigate(R.id.action_beverageFragment_to_selectedFoodFragment)
        }

        binding.btnBackBeverage.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}