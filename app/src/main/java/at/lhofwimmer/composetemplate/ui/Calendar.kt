package at.lhofwimmer.composetemplate.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.lhofwimmer.composetemplate.R
import java.time.DayOfWeek
import java.util.*
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.data.local.static.recipeListItems
import at.lhofwimmer.composetemplate.swipe.ComposePagerSnapHelper
import at.lhofwimmer.composetemplate.ui.theme.Size


enum class DinnerType {
    Breakfast, Brunch, Lunch, Linner, Dinner
}

data class CalendarEntry(
    val date: Calendar? = null,
    var recipe: RecipeListItem? = null
)

object RecipeSource {
    var recordedRecipes: MutableList<String> = mutableListOf()
}

@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalFoundationApi
@Composable
fun SimpleCalender() {
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ComposePagerSnapHelper(width = 2.dp) { listState ->
            LazyRow(state = listState) {
                items((1..3).toList()) { week ->
                    Column(
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "KW $week", Modifier.padding(170.dp, 0.dp))
                        DrawWeek()
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { setShowDialog(true) }) {
            Text("Create Shopping List")
        }
        MessageBox(showDialog, setShowDialog)
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawWeek() {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        for (i in 0..4) {
            Text(DinnerType.values()[i].toString())
            Row()
            {
                for (j in 1..7) {
                    Column() {
                        Entry()
                        if (i == 4)
                            Text(text = DayOfWeek.of(j).toString().substring(0, 3), modifier = Modifier.padding(6.dp))
                    }
                }
            }
        }

    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Entry(modifier: Modifier = Modifier) {
    var recipeItem by remember { mutableStateOf(RecipeListItem("", "", 0.0, R.drawable.salmon_518032_1920)) }
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .border(0.3f.dp, Color.DarkGray)
            .clickable { setShowDialog(true) }
            .size(width = 55.dp, height = 80.dp))

    {
        Text(text = recipeItem.name ?: "", fontSize = 12.sp)
    }
    recipeItem = dialogDemo(showDialog, setShowDialog)
}

@ExperimentalMaterialApi
@Composable
fun dialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit): RecipeListItem {
    var selection by remember { mutableStateOf(RecipeListItem("", "", 0.0, R.drawable.salmon_518032_1920)) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text("Title")
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                        if (selection.name.isBlank())
                            RecipeSource.recordedRecipes.add(selection.name)
                    },
                ) {
                    Text("Submit")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                        selection = RecipeListItem("", "", 0.0, R.drawable.salmon_518032_1920)
                    },
                ) {
                    Text("Cancel")
                }
            },
            text = {
                Column {
                    recipeListItems.forEach { item ->
                        Card(
                            elevation = Size.Small,
                            modifier = Modifier
                                .padding(Size.Small)
                                .fillMaxWidth()
                                .border(
                                    2.dp,
                                    if (item == selection) MaterialTheme.colors.primary else Color.Transparent,
                                    RoundedCornerShape(Size.Medium)
                                ),
                            shape = RoundedCornerShape(Size.Medium),
                            onClick = { selection = item }
                        ) {
                            Text(item.name, modifier = Modifier.padding(Size.Medium))
                        }
                    }
                }


//                LazyRow(state = rememberLazyListState()) {
//                    items(recipeListItems) { item ->
//                        RecipeListItem(item, item == selection.recipe) { selection.recipe = item }
//                    }
//                }
            }
        )
    }
    return selection
}

@Composable
fun MessageBox(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
            },
            text = {
                Text("Shopping list has been created.")
            }
        )
    }
}




