package com.kks.proj_i_happy.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// colors : colors[0] = containerColor, colors[1] = textColor
@Composable
fun HorizonWideButton(
    colors: List<Color>,
    text: String,
    border: Boolean,
    modifier: Modifier = Modifier,
    clickEvent: () -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val mainContentWidth = (screenWidth / 1.3).dp

    val borderStroke = if (border) {
        BorderStroke(2.dp, colors[1])
    } else {
        BorderStroke(0.dp, Color.Black)
    }

    Button(
        onClick = clickEvent,
        modifier = Modifier
            .width(mainContentWidth),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors[0]
        ),
        border = borderStroke
    ) {
        Text(
            text = text,
            color = colors[1],
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 3.dp)
        )
    }
}