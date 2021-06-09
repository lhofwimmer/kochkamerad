package at.lhofwimmer.composetemplate.swipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.twotone.CalendarToday
import androidx.compose.material.icons.twotone.MyLocation
import androidx.compose.material.icons.twotone.SupervisedUserCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.R
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.ui.LocalNavController
import at.lhofwimmer.composetemplate.ui.Screen
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme
import at.lhofwimmer.composetemplate.ui.theme.Grey100
import at.lhofwimmer.composetemplate.ui.theme.Grey700
import at.lhofwimmer.composetemplate.ui.theme.Size
import com.gowtham.ratingbar.RatingBar

/**
 * Composable to create a person card 1 box
 *
 * https://github.com/cyph3rcod3r/Tinder-Like
 */
@Composable
fun PersonCard(recipe: RecipeListItem = RecipeListItem("Lorem Ipsum", "Hauptspeise", 3.5, R.drawable.hamburger_494706_1920)) {
    Column {
        val navController = LocalNavController.current

        Surface(shape = RoundedCornerShape(4.dp), elevation = 4.dp) {
            Column {
                Image(
                    painterResource(id = recipe.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(400.dp),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(Size.Large).fillMaxWidth()) {
                    Text(recipe.category + " •", style = MaterialTheme.typography.overline)
                    Text(
                        text = recipe.name,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(Size.Medium))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        RatingBar(
                            value = recipe.rating.toFloat(),
                            activeColor = Grey700,
                            size = 12.dp,
                            inactiveColor = Color.Transparent
                        ) {}
                        Button(
                            onClick = { navController.navigate(Screen.RecipeDetails.route) },
                            shape = RoundedCornerShape(Size.Medium)
                        ) {
                            Row {
                                Text("Recipe")
                                Spacer(modifier = Modifier.width(Size.Medium))
                                Icon(Icons.Rounded.ArrowForward, null)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    ComposeTemplateTheme {
        PersonCard(
            RecipeListItem(
                "Lorem ipsum",
                "Testkategorie",
                3.5,
                R.drawable.hamburger_494706_1920
            )
        )
    }
}