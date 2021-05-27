package at.lhofwimmer.composetemplate.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import at.lhofwimmer.composetemplate.ui.theme.Grey700

@Composable
fun Logo() {
    Text(
        text = "Koch\nKamerad",
        style = MaterialTheme.typography.h2,
        fontWeight = FontWeight.ExtraBold,
        color = Grey700,
        fontSize = 68.sp,
        lineHeight = 58.sp
    )
}