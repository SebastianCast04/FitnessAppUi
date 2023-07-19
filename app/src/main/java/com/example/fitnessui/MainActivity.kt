package com.example.fitnessui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessui.ui.theme.FitnessUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {

    val workOutCategories =
        listOf("Chest", "Full body", "Cardio", "Cross Fit", "Cyclist", "Glutes", "Power")
    FitnessUiTheme() {

        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.padding(18.dp),
                    elevation = 0.dp,
                    backgroundColor = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(65.dp)
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "profie picture"
                            )
                        }
                        Text(buildAnnotatedString {
                            append("Hello, ")

                            withStyle(
                                SpanStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Sebastian")
                            }
                        }, modifier = Modifier.padding(start = 10.dp))

                        Spacer(modifier = Modifier.weight(1f))

                        BadgedBox(badge = {
                            Badge(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.Red)
                                    .align(Alignment.BottomEnd)
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notification Icon",
                                tint = Color.Black
                            )
                        }

                    }
                }
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                    elevation = 5.dp,
                    backgroundColor = Color.Black
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        //Buttons to select information in the bottom nvigation

                        BottomNavigationItem(
                            selected = true,
                            onClick = { /*TODO*/ },
                            selectedContentColor = Color.White,
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Bottom Icon"
                                )
                            }
                        )


                        BottomNavigationItem(
                            selected = false,
                            onClick = { /*TODO*/ },
                            unselectedContentColor = Color.Gray,
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Fullscreen,
                                    contentDescription = "Bottom Icon"
                                )
                            }
                        )


                        BottomNavigationItem(
                            selected = false,
                            onClick = { /*TODO*/ },
                            unselectedContentColor = Color.Gray,
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Tune,
                                    contentDescription = "Bottom Icon"
                                )
                            }
                        )


                        BottomNavigationItem(
                            selected = false,
                            onClick = { /*TODO*/ },
                            unselectedContentColor = Color.Gray,
                            icon = {
                                Icon(
                                    imageVector = Icons.Rounded.CalendarMonth,
                                    contentDescription = "Bottom Icon"
                                )
                            }
                        )
                    }
                }
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
            ) {

                Spacer(modifier = Modifier.size(0.5.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    items(workOutCategories) { workout ->

                        WorkOutType(workOut = workout)
                    }
                }

                Spacer(modifier = Modifier.size(25.dp))

                //Exercise Box
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(10))
                        .background(colorResource(id = R.color.light_purple))
                ) {
                    Column(Modifier.padding(horizontal = 20.dp, vertical = 22.dp)) {

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Grow\nyour chest",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp
                            )

                            Button(
                                shape = RoundedCornerShape(20.dp),
                                contentPadding = PaddingValues(6.dp),
                                onClick = {},
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = colorResource(
                                        id = R.color.purple_200
                                    )
                                )
                            ) {
                                Text(text = "Middle level", color = Color.White, fontSize = 10.sp)
                            }
                        }

                        Spacer(modifier = Modifier.size(15.dp))

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color.White)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {

                                Spacer(modifier = Modifier.weight(0.5f))

                                Image(
                                    painter = painterResource(id = R.drawable.ches),
                                    contentDescription = "Exercise image",
                                    modifier = Modifier.size(200.dp)
                                )

                            }
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Schedule,
                                contentDescription = "Reloj Icon",
                                tint = Color.Black
                            )
                            Text(
                                text = "40 minutes",
                                fontSize = 18.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Transparent)
                            ) {
                                Text(
                                    text = "Start",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Icon(
                                    imageVector = Icons.Outlined.ArrowForward,
                                    contentDescription = "go",
                                    tint = Color.Black,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                            }

                        }

                    }
                }

                // Bottom Section

                Spacer(modifier = Modifier.size(40.dp))

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(20))
                        .background(colorResource(id = R.color.orange))
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(contentAlignment = Alignment.Center) {

                            CircularProgressIndicator(
                                modifier = Modifier.size(75.dp),
                                color = Color.Black,
                                progress = 0.56f,
                                strokeWidth = 8.dp
                            )
                            Text(
                                text = "56%",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )

                        }

                        Column {
                            Text(
                                text = "Great!!",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Your chest it's getting\nbigger every day",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WorkOutType(workOut: String) {

    var selected by remember { mutableStateOf(false) }
    val backgroundColor = if (selected) Color.Black else Color.White
    val textColor = if (selected) Color.White else Color.Black

    OutlinedButton(
        onClick = { selected = !selected },
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(6.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(text = workOut, color = textColor, fontSize = 18.sp)
    }


}

