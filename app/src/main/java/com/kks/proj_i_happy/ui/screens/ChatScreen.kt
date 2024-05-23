package com.kks.proj_i_happy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kks.proj_i_happy.util.DefaultScreen
import kotlinx.coroutines.launch

@Composable
fun ChatScreen(navController: NavController){
    DefaultScreen(navController) {
        ChatBody()
    }
}

@Composable
fun ChatBody() {
    val messages = remember { mutableStateListOf<Pair<String, Boolean>>() }
    val (text, setText) = remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            coroutineScope.launch {
                listState.animateScrollToItem(messages.size - 1)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
            reverseLayout = false // 위에서 아래로 정렬
        ) {
            items(messages) { (message, isUserMessage) ->
                ChatMessage(message = message, isUserMessage = isUserMessage)
            }
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = text,
                onValueChange = setText,
                modifier = Modifier.weight(1f),
                placeholder = { Text("Enter message") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        if (text.isNotEmpty()) {
                            messages.add(Pair("You: $text", true))
                            messages.add(Pair("Bot: ${getResponse(text)}", false))
                            setText("")
                        }
                    }
                )
            )
            Button(
                onClick = {
                    if (text.isNotEmpty()) {
                        messages.add(Pair("You: $text", true))
                        messages.add(Pair("Bot: ${getResponse(text)}", false))
                        setText("")
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun ChatMessage(message: String, isUserMessage: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isUserMessage) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isUserMessage) Color(0xFFDCF8C6) else Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {
            Text(text = message)
        }
    }
}

fun getResponse(message: String): String {
    // 간단한 정해진 답변 예시
    return when {
        message.contains("hello", ignoreCase = true) -> "Hi there!"
        message.contains("how are you", ignoreCase = true) -> "I'm good, thank you!"
        else -> "I don't understand."
    }
}