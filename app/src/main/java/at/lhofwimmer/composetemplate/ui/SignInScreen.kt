package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.lhofwimmer.composetemplate.ui.theme.Yellow100
import at.lhofwimmer.composetemplate.ui.theme.Yellow50

@Composable
fun SignIn() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow100)
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp, top = 100.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
//            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = "Koch\nKamerad",
                style = MaterialTheme.typography.h3,
                fontSize = 58.sp,
                lineHeight = 54.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email address")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text("Password")
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
            )

            Button(
                onClick = { /*TODO navigate to main screen*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign In", modifier = Modifier.padding(8.dp),)
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = { /*TODO register*/ }) {
                    Text("Register")
                }
            }
        }
    }
}