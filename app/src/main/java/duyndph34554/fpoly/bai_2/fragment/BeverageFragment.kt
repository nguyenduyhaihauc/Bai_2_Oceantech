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

//Fragment do uong
//Dai dien cho mot phan giao dien nguoi dung
class BeverageFragment : Fragment() {

    private var _binding: FragmentBeverageBinding? = null
    //Tra ve không null dung de truy cap cac thanh phan trong giao dien nguoi dung
    private val binding get() = _binding!!

    private lateinit var foodViewModel: FoodViewModel

//    Duoc goi khi khoi tao va tra ve giao dien nguoi dung cho Fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Lien ket giao dien XML thong qua binding
        _binding = FragmentBeverageBinding.inflate(inflater, container, false)
        return binding.root //Goc cua giao dien nguoi dung
    }

//    Duoc goi khi Fragment duoc khoi tao xong
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//    Cho phep chia se du lieu giua cac Fragment
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

//     Xu ly su kien nhan nut Next de den Fragment tiep theo
        binding.btnNextBeverage.setOnClickListener {
            findNavController().navigate(R.id.action_beverageFragment_to_selectedFoodFragment)
        }

//    Quay tro lai trang truoc
        binding.btnBackBeverage.setOnClickListener {
            findNavController().popBackStack()
        }
    }

//    Duoc goi khi Fragment bi pha huy
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Tranh ro rỉ bo nho
    }

}