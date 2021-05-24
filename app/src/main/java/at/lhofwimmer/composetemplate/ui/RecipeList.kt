package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.data.local.static.recipeListItems
import at.lhofwimmer.composetemplate.ui.theme.Grey700
import at.lhofwimmer.composetemplate.ui.theme.Grey800
import at.lhofwimmer.composetemplate.ui.theme.Size
import com.gowtham.ratingbar.ComposeStars
import com.gowtham.ratingbar.RatingBar

@ExperimentalFoundationApi
@Composable
fun RecipeList() {
    val items = remember {
        val newList = mutableListOf<RecipeListItem>()

        repeat(2) {
            recipeListItems.forEach {
                newList.add(it)
            }
        }

        newList
    }

    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(items) { recipe ->
            RecipeListItem(recipe)
        }
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun RecipeListItem(recipe: RecipeListItem) {
    Card(
        modifier = Modifier
            .padding(Size.Medium)
            .clickable {

            }, elevation = Size.Small
    ) {
        Column {
            //image
            Image(
                painterResource(recipe.image),
                contentDescription = null,
                modifier = Modifier.height(140.dp),
                contentScale = ContentScale.FillHeight
            )

            Column(modifier = Modifier.padding(Size.Large)) {
                // category
                Text(recipe.category + " •", style = MaterialTheme.typography.overline)
                Spacer(modifier = Modifier.height(Size.Small))
                // name
                Text(recipe.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(Size.Large))
                // stars
                RatingBar(value = recipe.rating.toFloat(), activeColor = Grey700, size = 16.dp, inactiveColor = Color.Transparent) {}
            }
        }
    }
}