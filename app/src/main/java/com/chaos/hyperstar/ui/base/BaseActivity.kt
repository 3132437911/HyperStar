package com.chaos.hyperstar.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.chaos.hyperstar.ui.base.theme.HyperStarTheme
import com.chaos.hyperstar.utils.PreferencesUtil

abstract class BaseActivity : ComponentActivity() {

    @Composable abstract fun InitView(colorMode: MutableState<Int>?)
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        setContent {
            val colorMode = remember { mutableIntStateOf(PreferencesUtil.getInt("color_mode",0)) }
            val darkMode = colorMode.intValue == 2 || (isSystemInDarkTheme() && colorMode.intValue == 0)
            DisposableEffect(darkMode) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT) { darkMode },
                    navigationBarStyle = SystemBarStyle.auto(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT) { darkMode },)
                window.isNavigationBarContrastEnforced = false  // Xiaomi moment, this code must be here
                onDispose {}
            }
            HyperStarTheme(colorMode.intValue) {
                InitView(colorMode)
            }
        }
    }

}
