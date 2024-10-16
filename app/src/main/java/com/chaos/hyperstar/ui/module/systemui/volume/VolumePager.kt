package com.chaos.hyperstar.ui.module.systemui.volume

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.chaos.hyperstar.R
import com.chaos.hyperstar.ui.base.ModuleNavPagers
import com.chaos.hyperstar.ui.base.ModulePagers
import com.chaos.hyperstar.ui.base.XMiuixSuperSliderSwitch
import com.chaos.hyperstar.ui.base.XSuperDropdown
import com.chaos.hyperstar.ui.base.XSuperSwitch
import com.chaos.hyperstar.ui.base.classes
import com.chaos.hyperstar.ui.base.firstClasses
import com.chaos.hyperstar.utils.Utils

@Composable
fun VolumePager(
    navController: NavController
) {
    ModuleNavPagers(
        activityTitle = stringResource(R.string.sound_settings),
        navController = navController,
        endClick = {
            Utils.rootShell("killall com.android.systemui")
                   },
    ){
        firstClasses(
            title = R.string.basics
        ) {
            XSuperDropdown(
                title = stringResource(R.string.is_super_blur_volume_title),
                key = "is_super_blur_volume",
                option = R.array.is_super_blur_entire
            )
            XSuperSwitch(
                title = stringResource(R.string.is_use_pad_volume_title),
                summary = stringResource(R.string.is_use_pad_volume_summary),
                key = "is_use_pad_volume"
            )
        }
        classes(title = R.string.progress_bar){
            XMiuixSuperSliderSwitch(
                switchTitle = stringResource(R.string.is_change_qs_progress_radius_title),
                switchKey = "is_change_volume_progress_radius",
                switchSummary = stringResource(id = R.string.progress_radius_summary),
                title = stringResource(R.string.qs_progress_radius_title) ,
                key ="volume_progress_radius",
                minValue = 0f,
                maxValue = 20f,
                progress = 2f,
                unit = "dp",
                decimalPlaces = 1
            )

        }
    }

}