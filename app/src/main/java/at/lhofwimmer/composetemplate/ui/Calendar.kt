package at.lhofwimmer.composetemplate.ui

import android.graphics.Paint
import android.os.Build
import android.os.Message
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.DayOfWeek
import java.util.*
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.data.local.static.recipeDetail
import at.lhofwimmer.composetemplate.data.local.static.recipeListItems
import at.lhofwimmer.composetemplate.swipe.ComposePagerSnapHelper
import org.intellij.lang.annotations.JdkConstants
import java.util.Collections.list


enum class DinnerType {
    Breakfast, Brunch, Lunch, Linner, Dinner
}

data class CalendarEntry(
    val date: Calendar? = null,
    var recipe: RecipeListItem? = null)

var recordedRecipes : MutableList<String> = mutableListOf()

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalFoundationApi
@Composable
fun SimpleCalender() {
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ComposePagerSnapHelper(width = 2.dp) { listState ->
            LazyRow(state = listState) {
                items((1..3).toList()) { week ->
                    Column(
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "KW $week", Modifier.padding(170.dp,0.dp))
                        DrawWeek()
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { setShowDialog(true)}) {
            Text("Create Shopping List")
        }
        MessagBox(showDialog, setShowDialog)
    }
}


@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawWeek() {

    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
        for(i in 0..4)
        {
            Text( DinnerType.values()[i].toString())
            Row()
            {
                for (j in 1..7) {
                    Column() {
                        Entry()
                        if(i == 4)
                            Text(text = DayOfWeek.of(j).toString().substring(0,3), modifier = Modifier.padding(6.dp))
                    }
                }
            }
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun Entry(modifier: Modifier = Modifier) {
    var calendarEntry by remember { mutableStateOf(CalendarEntry()) }
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .border(0.3f.dp, Color.DarkGray)
            .clickable { setShowDialog(true) }
            .size(width = 55.dp, height = 80.dp))

    {
        Text(text = calendarEntry.recipe?.name ?: "", fontSize = 12.sp)
    }
    calendarEntry = DialogDemo(showDialog, setShowDialog)
}

@Composable
fun DialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) : CalendarEntry {
    var selection by remember { mutableStateOf(CalendarEntry()) }
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
                        if (selection != null)
                            recordedRecipes.add(selection.recipe!!.name)
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
                        selection.recipe = null

                    },
                ) {
                    Text("Cancel")
                }
            },
            text = {
                LazyColumn() {
                    items(recipeListItems) { item ->
                        RecipeListItem(item, item == selection.recipe) { selection.recipe = item}
                    }
                }
            }
        )
    }
    return selection
}

@Composable
fun MessagBox(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
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




