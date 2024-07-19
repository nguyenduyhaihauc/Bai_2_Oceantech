package duyndph34554.fpoly.bai_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import duyndph34554.fpoly.bai_2.R
import duyndph34554.fpoly.bai_2.databinding.FragmentDessertBinding
import duyndph34554.fpoly.bai_2.databinding.FragmentMainDishBinding
import duyndph34554.fpoly.bai_2.viewModel.FoodViewModel


//Fragment mon chinh
class MainDishFragment : Fragment() {
    private var _binding: FragmentMainDishBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

//        Thiet lap
        foodViewModel.checkboxStates.observe(viewLifecycleOwner) { checkboxState ->
            binding.chkMainDish1.isChecked = checkboxState["Com rang"] ?: false
            binding.chkMainDish2.isChecked = checkboxState["Pho bo"] ?: false
            binding.chkMainDish3.isChecked = checkboxState["Pho ga"] ?: false
        }

//        Xu ly
        binding.chkMainDish1.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Com rang", isChecked)
        }

        binding.chkMainDish2.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Pho bo", isChecked)
        }

        binding.chkMainDish3.setOnCheckedChangeListener { _, isChecked ->
            foodViewModel.updateCheckboxState("Pho ga", isChecked)
        }

        binding.btnNextMainDish.setOnClickListener {
            findNavController().navigate(R.id.action_mainDishFragment_to_sideDishFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}