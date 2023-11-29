package com.example.catminder

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ListItem(
    password: Password,
    navController: NavHostController,
    list: PasswordsListViewModel
) {
    var isPopupOpen by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .clickable {
                isPopupOpen = true
            }
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.item_border),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = password.serviceWebsiteName,
                    style = TextStyle(
                        color = CustomColor.White.color,
                        fontSize = 25.sp,
                        fontFamily = oxaniumFamily,
                        fontWeight = FontWeight.SemiBold,
                    ))
                Text(
                    text = "Username: " + password.username,
                    style = TextStyle(
                        color = CustomColor.FadedBlue.color,
                        fontSize = 15.sp,
                        fontFamily = oxaniumFamily,
                        fontWeight = FontWeight.Light
                    ))
                Text(
                    text = "Password: " + password.password,
                    style = TextStyle(
                        color = CustomColor.FadedBlue.color,
                        fontSize = 15.sp,
                        fontFamily = oxaniumFamily,
                        fontWeight = FontWeight.Light
                    ))
            }
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.key),
                contentDescription = null,
            )

            DetailView(
                password = password,
                isOpen = isPopupOpen,
                onClose = {
                    isPopupOpen = false
                },
                navCtrl = navController,
                list = list
            )
        }
    }
}

@Composable
fun RecyclerView(
    navController: NavHostController,
    list: PasswordsListViewModel
) {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
            contentAlignment = Alignment.TopStart
        ){
            Image(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
            )
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                items(items = list.passwordList) { item ->
                    ListItem(
                        password = item,
                        navController = navController,
                        list = list
                    )
                }
            }
            Box (
                modifier = Modifier.padding(15.dp)
            ) {
                TextButton(
                    onClick = {
                        navController.navigate(Screen.AppUpdate.withArgs(Setting.Add.set.toString()))
                    },
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
//                    .padding(50.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = R.drawable.add_button),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecyclePreview() {
    RecyclerView(
        navController = rememberNavController(),
        list = viewModel<PasswordsListViewModel>()
    )
}
