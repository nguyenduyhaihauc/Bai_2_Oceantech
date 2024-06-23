package duyndph34554.fpoly.bai_2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel : ViewModel() {

    private val _selectedFoods = MutableLiveData<MutableList<String>>(mutableListOf())
    val selectedFoods: LiveData<MutableList<String>> get() = _selectedFoods

    private val _checkboxStates = MutableLiveData<MutableMap<String, Boolean>>(mutableMapOf())
    val checkboxStates: LiveData<MutableMap<String, Boolean>> get() = _checkboxStates

    private fun addFood(food: String) {
        _selectedFoods.value?.apply {
            if (!contains(food)) {
                add(food)
                _selectedFoods.value = this
            }
        }
    }

    private fun remoteFood(food: String) {
        _selectedFoods.value?.apply {
            remove(food)
            _selectedFoods.value = this
        }
    }

    fun updateCheckboxState(food: String, isChecked: Boolean) {
        _checkboxStates.value?.apply {
            put(food, isChecked)
            _checkboxStates.value = this
        }

        if (isChecked) {
            addFood(food)
        } else {
            remoteFood(food)
        }
    }
}