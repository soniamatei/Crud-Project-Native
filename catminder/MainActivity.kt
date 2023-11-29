package com.example.catminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.catminder.ui.theme.CatMinderTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


val oxaniumFamily = FontFamily(
    Font(R.font.oxanium_extralight, FontWeight.ExtraLight),
    Font(R.font.oxanium_light, FontWeight.Light),
    Font(R.font.oxanium_regular, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.oxanium_medium, FontWeight.Medium),
    Font(R.font.oxanium_bold, FontWeight.Bold),
    Font(R.font.oxanium_semibold, FontWeight.SemiBold),
    Font(R.font.oxanium_extrabold, FontWeight.ExtraBold)
)
enum class CustomColor(val color: Color) {
    White(Color(android.graphics.Color.parseColor("#DFEDFF"))),
    Gray(Color(android.graphics.Color.parseColor("#818E9F"))),
    FadedBlue(Color(android.graphics.Color.parseColor("#476995"))),
    SourCherryPink(Color(android.graphics.Color.parseColor("#360A15"))),
    PavementPink(Color(android.graphics.Color.parseColor("#120B0D"))),
    SmoothBlack(Color(android.graphics.Color.parseColor("#0A0506"))),
    BestPink(Color(android.graphics.Color.parseColor("#D8055E"))),
    FantasticBlue(Color(android.graphics.Color.parseColor("#2374AB"))),
}

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatMinderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CustomColor.SmoothBlack.color
                ) {
                    navController = rememberNavController()
                    SetUpNavGraph(navController = navController)
                }
            }
        }
    }
}
