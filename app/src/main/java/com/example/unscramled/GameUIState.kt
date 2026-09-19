package com.example.unscramled

data class GameUiState(
    val scrambledWord: String = "",
    val userAnswer: String = "",
    val score: Int = 0
)