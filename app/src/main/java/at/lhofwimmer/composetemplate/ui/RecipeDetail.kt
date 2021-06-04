package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.data.local.static.recipeDetail
import at.lhofwimmer.composetemplate.ui.theme.*
import com.gowtham.ratingbar.RatingBar

@Composable
@Preview
fun RecipeDetail() {
    LazyColumn(modifier = Modifier.scrollable(rememberScrollState(), orientation = Orientation.Vertical)) {
        item {
            Surface(
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painterResource(recipeDetail.image), null)
                Surface(
                    elevation = Size.Medium,
                    shape = RoundedCornerShape(Size.Medium),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = Size.Large, end = Size.Large, bottom = Size.Large, top = 212.dp)
                ) {
                    Column(modifier = Modifier.padding(Size.Large)) {
                        Text(recipeDetail.category + " •", style = MaterialTheme.typography.overline)
                        Spacer(modifier = Modifier.height(Size.Small))

                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text(recipeDetail.name, style = MaterialTheme.typography.h5, modifier = Modifier.weight(1f))

                            RatingBar(
                                value = recipeDetail.rating.toFloat(),
                                activeColor = Grey700,
                                size = 16.dp,
                                inactiveColor = Color.Transparent
                            ) {}
                        }
                    }
                }
            }
        }

        item {
            Column(modifier = Modifier.padding(Size.Large)) {
                Text("Zutaten", style = MaterialTheme.typography.h6, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(Size.Large))
                recipeDetail.ingredients.forEach { ingredient ->
                    var checked by remember { mutableStateOf(false) }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it },
                            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colors.primary)
                        )
                        Spacer(modifier = Modifier.width(Size.Medium))
                        Text(
                            buildAnnotatedString {
                                if (ingredient.amount != null) {
                                    append(ingredient.amount)
                                    append(" ")
                                }
                                append(ingredient.name)
                            },
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.clickable { checked = !checked },
                            color = if (checked) Grey800.copy(alpha = 0.5f) else Grey800
                        )
                    }

                    Spacer(modifier = Modifier.height(Size.Small))
                }
            }
        }

        item {
            var stepNumber by remember { mutableStateOf(1) }
            Column(modifier = Modifier.padding(Size.Large)) {
                Text("Zubereitung", style = MaterialTheme.typography.h6, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(Size.Large))
                recipeDetail.steps.forEach { step ->
                    Row {
                        Text("$stepNumber.", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(Size.Medium))
                        Text(step)
                    }
                    Spacer(modifier = Modifier.height(Size.Medium))
                    stepNumber++
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
    //header: image, name, category, group, expenditure,
}