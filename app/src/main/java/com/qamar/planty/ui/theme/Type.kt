package com.qamar.planty.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val textFont = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val titleFont = TextStyle(
    fontFamily = logoFont,
    fontWeight = FontWeight.Normal,
    fontSize = 40.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)
val titleFont20 = TextStyle(
    fontFamily = logoFont,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val normalFont = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    fontSize = 30.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp,
    textAlign = TextAlign.Center
)