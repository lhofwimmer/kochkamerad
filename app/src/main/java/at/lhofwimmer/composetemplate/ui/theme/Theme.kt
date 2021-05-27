package at.lhofwimmer.composetemplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import at.lhofwimmer.composetemplate.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Green500 = Color(0xFF10B981)
val Green600 = Color(0xFF059669)
val Green700 = Color(0xFF047857)
val Yellow50 = Color(0xFFFFFBEB)
val Yellow100 = Color(0xFFFEF3C7)
val Yellow400 = Color(0xFFFBBF24)
val Grey100 = Color(0xFFF3F4F6)
val Grey700 = Color(0xFF374151)
val Grey800 = Color(0xFF1F2937)

private val LightColorPalette = lightColors(
    primary = Green600,
    primaryVariant = Green500,
    secondary = Yellow400,
    secondaryVariant = Yellow100,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Grey800,
    onBackground = Grey800,
    onSurface = Grey800
)

val inter = FontFamily(
    Font(R.font.inter_thin, FontWeight.W100),
    Font(R.font.inter_extralight, FontWeight.W200),
    Font(R.font.inter_light, FontWeight.W300),
    Font(R.font.inter_regular, FontWeight.W400),
    Font(R.font.inter_medium, FontWeight.W500),
    Font(R.font.inter_semibold, FontWeight.W600),
    Font(R.font.inter_bold, FontWeight.W700),
    Font(R.font.inter_extrabold, FontWeight.W800),
    Font(R.font.inter_black, FontWeight.W900),
)

val montserrat = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.W100),
    Font(R.font.montserrat_extralight, FontWeight.W200),
    Font(R.font.montserrat_light, FontWeight.W300),
    Font(R.font.montserrat_regular, FontWeight.W400),
    Font(R.font.montserrat_medium, FontWeight.W500),
    Font(R.font.montserrat_semibold, FontWeight.W600),
    Font(R.font.montserrat_bold, FontWeight.W700),
    Font(R.font.montserrat_extrabold, FontWeight.W800),
    Font(R.font.montserrat_black, FontWeight.W900),
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W300,
        fontSize = 97.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W300,
        fontSize = 61.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W400,
        fontSize = 48.sp,
    ),
    h4 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W400,
        fontSize = 34.sp,
        letterSpacing = (0.25).sp
    ),
    h5 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
    ),
    h6 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        letterSpacing = (0.15).sp
    ),
    body1 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        letterSpacing = (0.5).sp
    ),
    body2 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = (0.25).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = montserrat,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = (0.15).sp
    ),
    subtitle2 = TextStyle(
        fontFamily = montserrat,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        letterSpacing = (0.1).sp
    ),
    button = TextStyle(
        fontFamily = inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        letterSpacing = (1.25).sp
    ),
    caption = TextStyle(
        fontFamily = inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = (0.4).sp
    ),
    overline = TextStyle(
        fontFamily = inter,
        fontSize = 10.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = (1.5).sp
    )
)

object Size {
    val Small = 4.dp
    val Medium = 8.dp
    val Large = 16.dp
    val XLarge = 32.dp
}

@Composable
fun ComposeTemplateTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}