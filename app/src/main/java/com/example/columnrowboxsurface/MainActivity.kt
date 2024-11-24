package com.example.columnrowboxsurface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.columnrowboxsurface.ui.theme.ColumnRowBoxSurfaceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnRowBoxSurfaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonnelList(personnel = sampleData())
                }
            }
        }
    }
}

fun generateRandomPhoneNumber(): String {
    val areaCode = Random.nextInt(100, 999)
    val centralOfficeCode = Random.nextInt(100, 999)
    val lineNumber = Random.nextInt(1000, 9999)
    return "$areaCode-$centralOfficeCode-$lineNumber"
}

@Composable
fun PersonnelList(personnel: List<Person>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .border(1.dp, Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Данные по персоналу:",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(8.dp),
                fontSize = 20.sp,
                color = Color.White
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .border(0.5.dp, Color.Black)
            ) {
                Text(
                    text = "Имя",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "Зарплата",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "Телефон",
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
            personnel.forEach { person ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(0.5.dp, Color.Black)
                ) {
                    Text(
                        text = person.name,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = person.salary.toString(),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = person.phoneNumber,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

fun sampleData(): List<Person> {
    return listOf(
        Person("Иван", 50000.0, generateRandomPhoneNumber()),
        Person("Петр", 60000.0, generateRandomPhoneNumber()),
        Person("Анна", 55000.0, generateRandomPhoneNumber()),
        Person("Дима", 70000.0, generateRandomPhoneNumber()),
        Person("Яна", 65000.0, generateRandomPhoneNumber()),
        Person("Гриша", 52000.0, generateRandomPhoneNumber()),
        Person("Игорь", 75000.0, generateRandomPhoneNumber()),
        Person("Алексей", 68000.0, generateRandomPhoneNumber())
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColumnRowBoxSurfaceTheme { PersonnelList(personnel = sampleData()) }
}
