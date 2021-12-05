package pl.marchuck.lunchcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import pl.marchuck.lunchcomposer.data.Starch
import pl.marchuck.lunchcomposer.data.StarchType
import pl.marchuck.lunchcomposer.data.Veggies
import pl.marchuck.lunchcomposer.generator.StarchGenerator
import pl.marchuck.lunchcomposer.generator.StarchResult
import pl.marchuck.lunchcomposer.ui.theme.LunchComposerTheme
import java.util.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {

    val random = Random()

    val starchGenerator = StarchGenerator(random)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LunchComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    var randomVeggie by remember { mutableStateOf(Veggies.NONE) }
                    var randomStarch by remember { mutableStateOf(Starch.NONE) }

                    Column {
                        Text(text = "Welcome to Lunch Composer!")
                        Text(text = "Randomize starch and veggies")
                        Button(onClick = {
                            randomVeggie = Veggies.generate(random)
                        }) {
                            Text(
                                if (randomVeggie == Veggies.NONE) {
                                    "select veggies"
                                } else {
                                    randomVeggie.name
                                }
                            )
                        }
                        Button(onClick = {
                            val randomStarchType = StarchType.generate(random)
                            val result = starchGenerator.generate(randomStarchType)
                            randomStarch = when (result) {
                                is StarchResult.Failure -> Starch.NONE
                                is StarchResult.Success -> result.starch
                            }
                        }) {
                            Text(
                                if (randomStarch == Starch.NONE) {
                                    "select starch"
                                } else {
                                    randomStarch.name
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LunchComposerTheme {
        Greeting("Android")
    }
}