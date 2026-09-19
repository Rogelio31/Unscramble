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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.unscramled.ui.theme.UnscramledTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

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

    var userAnswer by remember{
        mutableStateOf("")
    }

    val correctAnswer = "CAT"
    var score by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        Text(
            text = "TAC",
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
                if (userAnswer == correctAnswer){
                    score++
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
