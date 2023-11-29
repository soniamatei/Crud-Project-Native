package com.example.catminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Setting(val set: Int) {
    Add(1),
    Update(2)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUpdateView(
    setting: Int,
    id: Int? = null,
    navCtrl: NavHostController,
    list: PasswordsListViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
            )
        }
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        )
        {
            var newPassword by remember { mutableStateOf(Password(0, "", "", "", "", "")) }
            var been by remember { mutableStateOf(1) }
            if (setting == Setting.Update.set && been == 1) {
                newPassword = list.passwordList.find { it.id == id }!!
                been = 0
            }

            Column( //fields
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.field_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    TextField(
                        value = newPassword.serviceWebsiteName,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = CustomColor.FantasticBlue.color,
                            containerColor = Color.Transparent,
                            textColor = CustomColor.White.color,
                            placeholderColor = CustomColor.White.color,
                            disabledLabelColor = CustomColor.White.color,
                            focusedLabelColor = CustomColor.BestPink.color,
                            disabledTextColor = CustomColor.Gray.color,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        onValueChange = { newPassword = newPassword.copy(serviceWebsiteName = it) },
                        label = {
                            Text(
                                text = "Service/Website Name"
                            )
                        },
                        textStyle = textStyle
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.field_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    TextField(
                        value = newPassword.email,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = CustomColor.FantasticBlue.color,
                            containerColor = Color.Transparent,
                            textColor = CustomColor.White.color,
                            placeholderColor = CustomColor.White.color,
                            disabledLabelColor = CustomColor.White.color,
                            focusedLabelColor = CustomColor.BestPink.color,
                            disabledTextColor = CustomColor.Gray.color,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        onValueChange = { newPassword = newPassword.copy(email = it) },
                        label = {
                            Text(
                                text = "Email"
                            )
                        },
                        textStyle = textStyle
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.field_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    TextField(
                        value = newPassword.username,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = CustomColor.FantasticBlue.color,
                            containerColor = Color.Transparent,
                            textColor = CustomColor.White.color,
                            placeholderColor = CustomColor.White.color,
                            disabledLabelColor = CustomColor.White.color,
                            focusedLabelColor = CustomColor.BestPink.color,
                            disabledTextColor = CustomColor.Gray.color,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        onValueChange = { newPassword = newPassword.copy(username = it) },
                        label = {
                            Text(
                                text = "Username"
                            )
                        },
                        textStyle = textStyle
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.field_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    TextField(
                        value = newPassword.password,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = CustomColor.FantasticBlue.color,
                            containerColor = Color.Transparent,
                            textColor = CustomColor.White.color,
                            placeholderColor = CustomColor.White.color,
                            disabledLabelColor = CustomColor.White.color,
                            focusedLabelColor = CustomColor.BestPink.color,
                            disabledTextColor = CustomColor.Gray.color,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        onValueChange = { newPassword = newPassword.copy(password = it) },
                        label = {
                            Text(
                                text = "Password"
                            )
                        },
                        textStyle = textStyle
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.field_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    TextField(
                        value = newPassword.note,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = CustomColor.FantasticBlue.color,
                            containerColor = Color.Transparent,
                            textColor = CustomColor.White.color,
                            placeholderColor = CustomColor.White.color,
                            disabledLabelColor = CustomColor.White.color,
                            focusedLabelColor = CustomColor.BestPink.color,
                            disabledTextColor = CustomColor.Gray.color,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = { newPassword = newPassword.copy(note = it) },
                        label = {
                            Text(
                                text = "Note"
                            )
                        },
                        textStyle = textStyle
                    )
                }
            }
            Spacer(modifier = Modifier.height(70.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                val func: () -> Unit
                if (setting == Setting.Update.set) {
                    func = {
                        list.update(
                            id = newPassword.id,
                            serviceWebsiteName = newPassword.serviceWebsiteName,
                            email = newPassword.email,
                            username = newPassword.username,
                            password = newPassword.password,
                            note = newPassword.note
                        )
                        navCtrl.navigate(Screen.ListView.route)
                    }
                } else {
                    func = {
                        list.insert(
                            serviceWebsiteName = newPassword.serviceWebsiteName,
                            email = newPassword.email,
                            username = newPassword.username,
                            password = newPassword.password,
                            note = newPassword.note
                        )
                        navCtrl.navigate(Screen.ListView.route)
                    }
                }
                button(text = "Save", onClick = func)
                button(text = "Cancel", onClick = { navCtrl.navigate(Screen.ListView.route) })
            }
        }
    }
}


@Preview
@Composable
fun AddUpdatePreview() {
    AddUpdateView(
        setting = Setting.Add.set, navCtrl = rememberNavController(),
        list = viewModel<PasswordsListViewModel>()
    )
}