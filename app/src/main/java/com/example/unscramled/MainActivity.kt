package com.example.unscramled

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.unscramled.ui.theme.UnscramledTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnscramledTheme {
                GameScreen()
            }
        }
    }
}

@Composable
fun GameScreen() {

    var userAnswer by remember {
        mutableStateOf("")
    }

    val words: List<String> = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )

    var currentWordIndex by remember {
        mutableIntStateOf(0)
    }

    // Correct answer
    val correctAnswer: String = words[currentWordIndex]

    // Scrambled word
    var scrambledWord by remember {
        mutableStateOf(
            words[0].toList().shuffled().joinToString("")
        )
    }

    // Score
    var score by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        Text(
            text = scrambledWord,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        OutlinedTextField(
            value = userAnswer,
            onValueChange = {
                userAnswer = it
            },
            label = {
                Text("Enter your Answer")
            }
        )

        Button(
            onClick = {

                if (userAnswer.uppercase() == correctAnswer) {


                    score++

                    if (currentWordIndex < words.size - 1) {

                        currentWordIndex++
                        userAnswer = ""
                        scrambledWord = words[currentWordIndex]
                            .toList()
                            .shuffled()
                            .joinToString("")
                    }
                }
            }
        ) {
            Text("SUBMIT")
        }

        Text(
            text = "Score: $score"
        )
    }
}