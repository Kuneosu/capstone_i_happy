package com.kks.proj_i_happy.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R
import com.kks.proj_i_happy.util.DefaultScreen


@Composable
fun NewsScreen(navController: NavController) {
    DefaultScreen(navController) {
        NewsBody(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsBody(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                ),
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.LightGray, Color.Transparent),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .background(Color.White)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TipsSection()
                    Spacer(modifier = Modifier.height(16.dp))
                    RecommendedArticlesSection()
                    Spacer(modifier = Modifier.height(16.dp))
                    CommunitySection()
                }

            }
        }
    }

}

@Composable
fun TipsSection() {
    Column {
        Text(text = "오늘의 꿀팁", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        TipCard(
            title = "Tip 1",
            content = "아이의 눈높이에 맞춰 소통하세요. 아이와 눈높이를 맞추는 것은 단순히 신체적인 측면만이 아니라, 아이의 감정과 생각에 공감하는 것을 의미합니다."
        )
        TipCard(
            title = "Tip 2",
            content = "일관성 있는 규칙과 훈육을 유지하세요. 아이에게 명확하고 일관성 있는 규칙을 정하고, 규칙을 어겼을 때 일관된 훈육을 하는 것이 중요합니다."
        )
        TipCard(
            title = "Tip 3",
            content = "아이를 칭찬하고 격려하세요. 아이가 좋은 행동을 하거나 노력했을 때 칭찬하고 격려하는 것은 아이의 자존감을 높여줍니다."
        )

    }
}

@Composable
fun TipCard(title: String, content: String) {
    var expanded by remember { mutableStateOf(false) }
    var lineCount by remember { mutableIntStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .animateContentSize()
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(
                text = content,
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                color = Color.Gray,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = {
                    lineCount = it.lineCount
                }
            )
            if (lineCount >= 2) {
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = if (expanded) "Show less" else "Show more"
                        )
                    }
                }
            } else {
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}


@Composable
fun RecommendedArticlesSection() {
    Column {
        Text(text = "추천 기사", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        ArticleCard(
            imageResId = R.drawable.ic_launcher_background,
            title = "트랜스포머 다시 돌아왔다! 가족과 함께 즐기는 영화!",
            date = "2024.03.22. 동일일보"
        )
        Spacer(modifier = Modifier.height(8.dp))

        ArticleCard(
            imageResId = R.drawable.ic_launcher_background,
            title = "고대 문명의 신비를 만나다! 아이와 함께 가는 고대 건축 미술관",
            date = "2024.03.20. 동일일보"
        )
    }
}

@Composable
fun ArticleCard(imageResId: Int, title: String, date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = date, fontSize = 14.sp, color = Color.Gray)
        }


    }
}

@Composable
fun CommunitySection() {
    Column {
        Text(text = "육아 정보 커뮤니티", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        CommunityPost(
            username = "Username",
            content = "Post content goes here..."
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CommunityPost(username: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.applogo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(text = username, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            Text(text = content, fontSize = 14.sp)
        }


    }
}