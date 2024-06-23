package duyndph34554.fpoly.bai_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import duyndph34554.fpoly.bai_2.R
import duyndph34554.fpoly.bai_2.databinding.FragmentBeverageBinding
import duyndph34554.fpoly.bai_2.databinding.FragmentSelectedFoodBinding
import duyndph34554.fpoly.bai_2.viewModel.FoodViewModel

class SelectedFoodFragment : Fragment() {

    private lateinit var viewModel: FoodViewModel
    private var _binding: FragmentSelectedFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectedFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        viewModel.selectedFoods.observe(viewLifecycleOwner) { selectedFoods ->
//            Hien thi mon an
            val stringBuilder = StringBuilder()
            for (food in selectedFoods) {
                stringBuilder.append(food).append("\n") //Them mon an vao dong moi
            }
            binding.txtSelectedFood.text = stringBuilder.toString()
        }

        binding.btnBackSelectFood.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}