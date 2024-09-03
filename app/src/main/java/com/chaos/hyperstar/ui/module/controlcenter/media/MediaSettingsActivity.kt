package com.chaos.hyperstar.ui.module.controlcenter.media

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chaos.hyperstar.ui.module.ui.theme.HyperStarTheme
import com.chaos.hyperstar.utils.PreferencesUtil

class MediaSettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorMode = remember { mutableIntStateOf(PreferencesUtil.getInt("color_mode",0)) }
            DisposableEffect(isSystemInDarkTheme()) {
                enableEdgeToEdge()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    window.isNavigationBarContrastEnforced = false // Xiaomi moment, this code must be here
                }
                onDispose {}
            }
            HyperStarTheme(colorMode = colorMode.value){
                Greeting(this)
            }
        }
    }
}

@Composable
private fun Greeting(activity: ComponentActivity?){
    activity?.let { MediaSettingsPager(it) }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    HyperStarTheme {
        Greeting(null)
    }
}