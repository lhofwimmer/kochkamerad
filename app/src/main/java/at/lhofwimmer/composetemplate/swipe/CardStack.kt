package at.lhofwimmer.composetemplate.swipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CalendarToday
import androidx.compose.material.icons.twotone.MyLocation
import androidx.compose.material.icons.twotone.Phone
import androidx.compose.material.icons.twotone.SupervisedUserCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.R
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme
import java.net.URL

/**
 * Composable to create a person card 1 box
 *
 * https://github.com/cyph3rcod3r/Tinder-Like
 */
@Composable
fun PersonCard(recipe: RecipeListItem) {
    var details by remember { mutableStateOf(recipe.name) }
    val user = remember { mutableStateOf(true) }
    val dob = remember { mutableStateOf(false) }
    val loc = remember { mutableStateOf(false) }
    val phone = remember { mutableStateOf(false) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(shape = RoundedCornerShape(4.dp), elevation = 4.dp) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(painterResource(id = recipe.image), contentDescription = null, modifier = Modifier.size(192.dp))

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = details.orEmpty(), overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    IconButton(onClick = {
                        user.value = true; dob.value = false; loc.value = false;phone.value = false
                        details = recipe.name
                    }) {
                        Icon(
                            imageVector = Icons.TwoTone.SupervisedUserCircle,
                            contentDescription = null,
                            modifier = Modifier.height(56.dp)
                        )
                    }
                    IconButton(onClick = {
                        dob.value = true; user.value = false; loc.value = false;phone.value = false
                        details = recipe.category
                    }) {
                        Icon(
                            imageVector = Icons.TwoTone.CalendarToday,
                            contentDescription = null,
                            modifier = Modifier.height(56.dp)
                        )
                    }
                    IconButton(onClick = {
                        loc.value = true; dob.value = false; user.value = false;phone.value = false
                        details = recipe.rating.toString()
                    }) {
                        Icon(
                            imageVector = Icons.TwoTone.MyLocation,
                            contentDescription = null,
                            modifier = Modifier.height(56.dp)
                        )
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