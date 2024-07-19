package duyndph34554.fpoly.bai_2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//ViewModel giup quan ly du lieu mot cach ben vung qua các thay doi cau hinh
class FoodViewModel : ViewModel() {

//    MutableLiveData chua danh sach cac mon an duoc chon
    private val _selectedFoods = MutableLiveData<MutableList<String>>(mutableListOf())
//    Duoc dung de doc cac thanh phan trong Android
    val selectedFoods: LiveData<MutableList<String>> get() = _selectedFoods

    //    Luu tru trang thai duoc chon
    private val _checkboxStates = MutableLiveData<MutableMap<String, Boolean>>(mutableMapOf())
    val checkboxStates: LiveData<MutableMap<String, Boolean>> get() = _checkboxStates


//    Them mon an vao danh sach neu chua co mon an do
    private fun addFood(food: String) {
        _selectedFoods.value?.apply {
            if (!contains(food)) {
                add(food)
                _selectedFoods.value = this
            }
        }
    }

//    Xoa mon an
    private fun remoteFood(food: String) {
        _selectedFoods.value?.apply {
            remove(food)
            _selectedFoods.value = this
        }
    }

//    Cap nhat trang thai cua mon an
    fun updateCheckboxState(food: String, isChecked: Boolean) {
        _checkboxStates.value?.apply {
            put(food, isChecked)
            _checkboxStates.value = this
        }

//    Kiem tra neu checkBox duoc chon thi them, bo chon thi remote
        if (isChecked) {
            addFood(food)
        } else {
            remoteFood(food)
        }
    }
}