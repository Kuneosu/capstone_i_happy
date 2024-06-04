package com.kks.proj_i_happy.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R
import com.kks.proj_i_happy.util.DefaultScreen
import com.kks.proj_i_happy.util.doDayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    DefaultScreen(navController) {
        HomeBody()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeBody(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HomeDateText()
            PersonalInfo()
        }
        Spacer(modifier = Modifier.size(4.dp))
        Weather()
        Spacer(modifier = Modifier.size(10.dp))
        EventCard()
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "무엇이 필요하신가요 ?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(10.dp))
        MenuCards()
    }
}

@Composable
fun MenuCards() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        val cardWidth = 200.dp
        val cardHeight = 170.dp
        items(4) {
            when (it) {
                0 -> {
                    Card(
                        modifier = Modifier
                            .width(cardWidth)
                            .height(cardHeight)
                            .padding(end = 10.dp, bottom = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFf0f0f0)
                        )
                    ) {
                        MenuItem(
                            imageId = R.drawable.tips,
                            text = "오늘의 꿀팁"
                        )
                    }
                }

                1 -> {
                    Card(
                        modifier = Modifier
                            .width(cardWidth)
                            .height(cardHeight)
                            .padding(start = 10.dp, bottom = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFf2d0cd)
                        )
                    ) {
                        MenuItem(
                            imageId = R.drawable.chat,
                            text = "AI와 대화하기"
                        )
                    }
                }

                2 -> {
                    Card(
                        modifier = Modifier
                            .width(cardWidth)
                            .height(cardHeight)
                            .padding(end = 10.dp, top = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFf2d0cd)
                        )
                    ) {
                        MenuItem(
                            imageId = R.drawable.sleep,
                            text = "수면 관리하기"
                        )
                    }
                }

                3 -> {
                    Card(
                        modifier = Modifier
                            .width(cardWidth)
                            .height(cardHeight)
                            .padding(start = 10.dp, top = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFf0f0f0)
                        )
                    ) {
                        MenuItem(
                            imageId = R.drawable.calendar,
                            text = "아이 일정 달력"
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun MenuItem(imageId: Int, text: String, description: String? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = description,
            modifier = Modifier
                .size(100.dp)
                .padding(15.dp)
        )

        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun EventCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFf0f0f0)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "아이를 위한 \n이벤트에 참여해보세요 !",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Button(
                    onClick = {},
                    modifier = Modifier.height(36.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    ),
                ) {
                    Text(
                        text = "둘러보기",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "",
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}

@Composable
fun Weather() {
    Column {
        Text(
            // 날씨 API 연동 필요
            text = "최저 기온 : 4 / 최고 기온: 12/ 소나기 예정",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}

@Composable
fun PersonalInfo() {
    Image(
        painter = painterResource(id = R.drawable.applogo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .padding(2.dp)
            .clip(RoundedCornerShape(90.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(90.dp))
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeDateText() {

    val localDate: LocalDate = LocalDate.now()
    val dayOfWeek = doDayOfWeek()
    val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")

    val formattedDate = localDate.format(formatter) + " ($dayOfWeek)"

    Text(
        text = formattedDate,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    )

}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun HomePreview() {
//    HomeScreen()
}