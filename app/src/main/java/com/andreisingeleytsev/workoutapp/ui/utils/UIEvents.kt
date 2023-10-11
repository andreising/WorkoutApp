package com.andreisingeleytsev.workoutapp.ui.utils

sealed class UIEvents(){
    data class Navigate(val route: String): UIEvents()
    data object OnBack: UIEvents()
}