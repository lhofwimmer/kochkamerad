package at.lhofwimmer.composetemplate.ui

import android.text.Layout
import android.widget.ListView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.ui.theme.Size
import java.sql.Time
import java.text.DecimalFormat
import java.time.DayOfWeek
import java.time.Month
import java.util.*
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun simpleCalender(){

    Column(modifier = Modifier.fillMaxSize()) {

        Row() {
            Column(){
                for (index in 8..22)
                {
                    if(index < 10)
                    {
                        Text(text = "0$index:00")
                    }
                    else
                    {
                        Text(text = "$index:00")
                    }

                }
            }
            val pagerState = rememberPagerState(pageCount = 52)

            HorizontalPager(state = pagerState) { page ->
                // Our page content

                Column(modifier = Modifier.fillMaxWidth()
                    .background(MaterialTheme.colors.primary)) {
                    Text(text = "KW $page")
                    drawWeek()
                }
            }

            /*LazyRow() {
                stickyHeader {  }
                var index = 1
                items(52) { week ->
                    Column() {
                        Text(text = "KW $index")
                        drawWeek()
                    }
                    index += 1
                }
            }*/
        }



    }
}


@Composable
fun drawWeek()
{
    Row() {
        for(index in 1..7)
        {
            Column {
                for(index in 1..5)
                {
                    Entry(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun Entry(modifier: Modifier = Modifier)
{
    var CalendarEntry by remember{ mutableStateOf(CalendarEntry()) }
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .clickable { })
    {
        Text(text = CalendarEntry.recipe?.name ?: "")
    }

}

data class CalendarEntry(
    val date: Calendar? = null,
    val recipe: RecipeListItem? = null
)






/*fun initCal() : list
{
    var list = listOf(371)

    val cal = Calendar.getInstance()
    cal.set(2020,0,1)

    //ToDo get max range of year skip 7-first day of year
    for(index in 1..60)
    {
        cal.add(Calendar.DATE, 1)
    }
    return list
}*/
