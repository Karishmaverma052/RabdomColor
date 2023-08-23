package com.example.rabdomcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rabdomcolor.ui.theme.RabdomColorTheme
import java.lang.Math.random
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabdomColorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun RandomColorGenerator() {
    var currentColor by remember { mutableStateOf(generateRandomColor()) }
    var counter= remember{mutableStateOf(0)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(currentColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(500.dp)
                .background(currentColor)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Change Color counter=${counter.value}",
            fontSize = 50.sp,
        )

        Button(onClick = { counter.value++
            currentColor = generateRandomColor() }) {
            Text(text = "Change Color", fontSize = 20.sp)

        }

    }
}

fun generateRandomColor(): Color {
    val random = Random
    return Color(
        red = random.nextFloat(),
        green = random.nextFloat(),
        blue = random.nextFloat(),
        alpha = 1.0f
    )
}
@Composable
@Preview
fun PreviewRandomColorGenerator() {
    RandomColorGenerator()
}
