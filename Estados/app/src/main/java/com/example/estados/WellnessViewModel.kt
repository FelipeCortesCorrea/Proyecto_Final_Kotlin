package com.example.estados
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel




class WellnessViewModel : ViewModel() {
    fun changeTaskChecked(item: WellnessTask, checked: Boolean)=
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }