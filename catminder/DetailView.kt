package com.example.catminder

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

var headerStyle = TextStyle(
    color = CustomColor.White.color,
    fontSize = 20.sp,
    fontFamily = oxaniumFamily,
    fontWeight = FontWeight.Normal,
)
var textStyle = TextStyle(
    color = CustomColor.Gray.color,
    fontSize = 15.sp,
    fontFamily = oxaniumFamily,
    fontWeight = FontWeight.Light,
)

@Composable
fun field(
    tag: String, input: String
) {
    Text(
        text = tag, style = headerStyle
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = input, style = textStyle
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun button(
    text: String, onClick: () -> Unit
) {
    TextButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .width(80.dp)
            .height(40.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.button_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = text,
                style = TextStyle(
                    color = CustomColor.White.color,
                    fontFamily = oxaniumFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                ),
            )
        }
    }
}


@Composable
fun DetailView(
    password: Password, isOpen: Boolean, onClose: () -> Unit, navCtrl: NavHostController,
    list: PasswordsListViewModel
) {
    if (isOpen) {
        Dialog(onDismissRequest = { onClose() }) {
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.dialog_background),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = password.serviceWebsiteName, style = TextStyle(
                                color = CustomColor.White.color,
                                fontSize = 35.sp,
                                fontFamily = oxaniumFamily,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        field(tag = "Email:", input = password.id.toString())
                        field(tag = "Username:", input = password.username)
                        field(tag = "Password:", input = password.password)
                        field(tag = "Note:", input = password.note)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        button(text = "Delete", onClick = {
                            list.delete(password.id)
                            onClose()
                        })
                        button(text = "Edit", onClick = {
                            navCtrl.navigate(Screen.AppUpdate.withArgs(Setting.Update.set.toString(),
                                password.id.toString()))
                            onClose()
                        })
                        button(text = "Cancel", onClick = onClose)
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    var isPopupOpen by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            isPopupOpen = true
        }) {
            Text("Open Pop-up")
        }
        DetailView(
            password = Password(
                1,
                "Google",
                "smth@joke.ro",
                "joker",
                "hahhahha",
                "jfhiusfdgehsjdhffffffffffffffffffffffffffffffffffffffffffffffffff" +
                        "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                        "fffffffffffffffffffffffffffffffffffffffff"
            ), isOpen = isPopupOpen, onClose = {
                isPopupOpen = false
            }, navCtrl = rememberNavController(),
            list = viewModel<PasswordsListViewModel>()
        )
    }
}