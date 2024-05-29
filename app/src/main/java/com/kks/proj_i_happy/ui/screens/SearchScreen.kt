package com.kks.proj_i_happy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R
import com.kks.proj_i_happy.util.DefaultScreen
import com.kks.proj_i_happy.util.HorizonWideButton

@Composable
fun SearchScreen(navController: NavController) {
    DefaultScreen(navController = navController) {
        SearchBody()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchBody() {
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
    val popularSearches = listOf(
        "아이가 읽기 좋은 책", "수면관리", "학교", "아이를 위한 습관", "수유 팁",
        "기침이 잦을 때", "초등학교 입학 준비물"
    )
    val categories = listOf("건강관리", "육아", "놀이", "자기계발")

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 검색 바
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0F0F0), shape = CircleShape)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                placeholder = { Text("필요한 정보를 검색하세요") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { /* 검색 기능 구현 */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        }

        // 인기 검색어
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "popular searches",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                popularSearches.forEach { search ->
                    Text(
                        text = search,
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(20.dp))
                            .border(1.2.dp, Color.Black, shape = RoundedCornerShape(20.dp))
                            .padding(horizontal = 18.dp, vertical = 9.dp),
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // 카테고리
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Categories", fontSize = 16.sp, color = Color.Gray,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                categories.forEach { category ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Red
                        )
                        Text(
                            text = category,
                            modifier = Modifier.padding(start = 8.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        // 검색 버튼
        HorizonWideButton(
            colors = listOf(Color.Red, Color.White),
            text = "검색",
            border = false,
            modifier = Modifier.fillMaxWidth()
        ) {
            /* 검색 기능 구현 */
        }

    }
}
