package com.andreisingeleytsev.workoutapp.ui.screens.training_screen

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.CountDownTimer
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.utils.ExerciseItem
import com.andreisingeleytsev.workoutapp.ui.utils.ExercisesList
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.TrainingItem
import com.andreisingeleytsev.workoutapp.ui.utils.UIEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class TrainingViewModel : ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: TrainingEvents) {
        when (event) {
            is TrainingEvents.OnExercisePressed -> {
                isExercise.value = true
                currentExcerise.value = event.index
                time =
                    ExercisesList.exercises[currentExcerise.value!!].time
                currentTime.longValue = time
                timer.start()
            }

            is TrainingEvents.OnMainTrainButtonPressed -> {
                when (trainingState.intValue) {
                    0 -> {
                        isExercise.value = true
                        currentExcerise.value = trainingItem.value!!.exerciseIndexesList.first()
                        trainingState.intValue = 1
                        time =
                            ExercisesList.exercises[currentExcerise.value!!].time
                        currentTime.longValue = time
                        timer.start()
                    }

                    1 -> {
                        isExercise.value = true
                        trainingItem.value!!.exerciseIndexesList.forEach {
                            if (!doneExercise.contains(it)) {
                                currentExcerise.value = it
                                time =
                                    ExercisesList.exercises[currentExcerise.value!!].time
                                currentTime.longValue = time
                                timer.start()
                                return
                            }
                        }
                    }

                    2 -> {
                        sendUIEvent(UIEvents.OnBack)
                    }
                }
            }

            is TrainingEvents.OnMainExerciseButtonPressed -> {
                doneExercise.add(currentExcerise.value!!)
                isExercise.value = false
                timer!!.cancel()
                if (doneExercise.size == trainingItem.value!!.exerciseIndexesList.size) trainingState.intValue =
                    2
            }
        }
    }

    private fun sendUIEvent(event: UIEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    val trainingItem = mutableStateOf<TrainingItem?>(
        null
    )
    private var time = 0L
    val isExercise = mutableStateOf(false)
    val trainingState = mutableIntStateOf(0)
    val doneExercise = mutableSetOf<Int>()

    val currentExcerise = mutableStateOf<Int?>(null)
    val currentTime = mutableLongStateOf(
        0L
    )

    private var timer=object : CountDownTimer(100000, 1000) {
        override fun onTick(p0: Long) {
            currentTime.longValue =  currentTime.longValue - 1L
            if (currentTime.longValue<=0L) {
                cancel()
                doneExercise.add(currentExcerise.value!!)
                isExercise.value = false
            }
        }

        override fun onFinish() {
            doneExercise.add(currentExcerise.value!!)
            isExercise.value = false
        }
    }
}