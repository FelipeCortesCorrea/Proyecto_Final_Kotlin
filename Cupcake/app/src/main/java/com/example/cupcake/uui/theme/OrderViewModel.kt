package com.example.cupcake.uui.theme

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

private const val PRICE_PER_CUPCAKE = 3500.00

private const val PRICE_FOR_SAME_DAY_PICKUP = 2000.00

class OrderViewModel : ViewModel(){


    private val _uiState = MutableStateFlow(
        OrderUiState(
            pickupOptions = pickupOptions()
        )
    )
    val uiState : StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setQuantity(numberCupcake: Int){
        _uiState.update { currenState ->
            currenState.copy(
                quantity = numberCupcake,
                price = calculatePrice(quantity = numberCupcake)
            )
        }
    }

    fun setFlavor(desiredFlavor: String){
        _uiState.update { currentState ->
            currentState.copy(flavor = desiredFlavor)
        }
    }


    fun setDate(pickupDate: String){
        _uiState.update { currentState ->
            currentState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    fun resetOrder(){
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ):String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE

        if (pickupOptions()[0]== pickupDate){
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        return NumberFormat.getCurrencyInstance().format(calculatedPrice)
    }

    private fun pickupOptions(): List<String>{
        val dateOptions = mutableListOf<String>()

        Locale.setDefault(Locale("es","CO"))

        val formatter = SimpleDateFormat("E, d MMMM 'at' HH:mm:ss", Locale.getDefault())

        formatter.timeZone = TimeZone.getTimeZone("America/Bogota")

        val calendar = Calendar.getInstance()

        repeat(4){
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)

        }
        return dateOptions
    }
}