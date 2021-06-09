package at.lhofwimmer.composetemplate.ui

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.lhofwimmer.composetemplate.MainActivity
import at.lhofwimmer.composetemplate.ui.components.Logo
import at.lhofwimmer.composetemplate.ui.theme.Size
import at.lhofwimmer.composetemplate.ui.theme.Yellow100
import at.lhofwimmer.composetemplate.ui.theme.Yellow50

@Composable
fun SignIn() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .padding(bottom = Size.Large, start = Size.Large, end = Size.Large, top = 100.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
//            verticalArrangement = Arrangement.Center,
        ) {

            Logo()

            Spacer(modifier = Modifier.height(Size.Large))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email address")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(Size.Large))

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
                onClick = { context.startActivity(Intent(context,MainActivity::class.java)) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Sign In", modifier = Modifier.padding(8.dp))
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = { /*TODO register*/ }) {
                    Text("Register")
                }
            }
        }
    }
}