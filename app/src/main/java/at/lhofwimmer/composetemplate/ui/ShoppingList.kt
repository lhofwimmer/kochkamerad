package at.lhofwimmer.composetemplate.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.solver.widgets.Rectangle
import at.lhofwimmer.composetemplate.data.local.static.Ingredient
import at.lhofwimmer.composetemplate.data.local.static.RecipeDetail
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.data.local.static.recipeDetail
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShopList()
{

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Button(onClick = { /*TODO*/ }, enabled = false) {
                Text("<")
            }

            Text(modifier = Modifier.padding(20.dp), text = "<NoName>")
            Button(onClick = { /*TODO*/ }, enabled = false) {
                Text(">")
            }
        }
        Box(modifier = Modifier.border(0.3f.dp, Color.DarkGray)) {
            LazyColumn(Modifier.height(550.dp)) {
                items(recipeDetail.ingredients) { ingredient ->
                    entry(ingredient)
                }
            }
        }

        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(modifier = Modifier.padding(12.dp),onClick = { /*TODO*/ }) {
                Text("Select/Deselect All")
            }
            TextButton(modifier = Modifier.padding(12.dp),onClick = { /*TODO*/ }) {
                Text("Inc/Decrease All")
            }
        }
    }
}

@Composable
fun entry(rd : Ingredient)
{
    var checked by remember { mutableStateOf(true) }
    var amount by remember { mutableStateOf(0)}
    Box(modifier = Modifier.border(0.3f.dp, Color.DarkGray)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row() {
                Checkbox(checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colors.primary))
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = rd.name)
            }

            Box(modifier = Modifier.padding(5.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (checked)
                        Text(amount.toString())
                    Spacer(modifier = Modifier.padding(10.dp))
                    Column() {
                        Button(modifier = Modifier.padding(1.dp),
                            onClick = { amount++ },
                            enabled = checked)
                        {
                            Text(text = "+")
                        }
                        Button(modifier = Modifier.padding(1.dp),
                            onClick = { amount-- },
                            enabled = checked and (amount > 0))
                        {
                            Text(text = "-")
                        }
                    }
                }
            }
        }
    }
}