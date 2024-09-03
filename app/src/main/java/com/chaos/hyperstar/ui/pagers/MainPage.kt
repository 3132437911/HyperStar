package com.chaos.hyperstar.ui.pagers

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaos.hyperstar.R
import com.chaos.hyperstar.ui.base.MiuixActivitySuperArrow
import com.chaos.hyperstar.ui.module.controlcenter.ControlCenterSettings
import com.chaos.hyperstar.ui.module.volume.VolumeSettings
import getWindowSize
import top.yukonga.miuix.kmp.MiuixScrollBehavior
import top.yukonga.miuix.kmp.MiuixSuperArrow
import top.yukonga.miuix.kmp.MiuixSuperCheckbox
import top.yukonga.miuix.kmp.MiuixSuperDropdown
import top.yukonga.miuix.kmp.basic.MiuixBasicComponent
import top.yukonga.miuix.kmp.basic.MiuixCard
import top.yukonga.miuix.kmp.basic.MiuixLazyColumn
import top.yukonga.miuix.kmp.basic.MiuixText
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun MainPage(
    activity : ComponentActivity,
    topAppBarScrollBehavior: MiuixScrollBehavior,
    padding: PaddingValues,
    enableOverScroll: Boolean,
) {
    MiuixLazyColumn(
        modifier = Modifier.height(getWindowSize().height.dp),
        enableOverScroll = enableOverScroll,
        contentPadding = PaddingValues(top = padding.calculateTopPadding()+14.dp, bottom = padding.calculateBottomPadding()+14.dp),
        topAppBarScrollBehavior = topAppBarScrollBehavior
    ) {
        item {
            MiuixCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                insideMargin = DpSize(0.dp,14.dp)
            ) {
                MiuixText(
                    text = stringResource(R.string.systemui),
                    modifier = Modifier
                        .padding(horizontal = 28.dp)
                        .padding(top = 14.dp, bottom = 8.dp),
                    fontSize = 15.sp,
                    color = colorResource(R.color.class_name_color),
                    fontWeight = FontWeight.Medium
                )
                MiuixActivitySuperArrow(
                    leftIcon = R.drawable.icon_controlcenter,
                    title = stringResource(R.string.controlcenter),
                    context = activity,
                    activity = ControlCenterSettings::class.java

                )
                MiuixActivitySuperArrow(
                    leftIcon = R.drawable.ic_sound_settings,
                    title = stringResource(R.string.sound_settings),
                    context = activity,
                    activity = VolumeSettings::class.java

                )
            }

        }

    }
}


