package com.chaos.hyperstar.ui.module.controlcenter.list

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chaos.hyperstar.R
import com.chaos.hyperstar.ui.base.ActivityPagers
import com.chaos.hyperstar.ui.base.ColorPickerTool
import com.chaos.hyperstar.ui.base.XMiuixClasser
import com.chaos.hyperstar.ui.base.classes
import com.chaos.hyperstar.ui.base.firstClasses
import com.chaos.hyperstar.utils.Utils

@Composable
fun QSListColorPager(
    activity: ComponentActivity,
) {
    ActivityPagers(
        activityTitle = "普通磁贴颜色",
        activity = activity,
        endClick = {
            Utils.rootShell("killall com.android.systemui")
        },
    ) {
        firstClasses(
            title = "关闭状态"
        ) {

        }
        classes(
            title = "开启状态"
        ){
            ColorPickerTool(
                title = "常规·背景色",
                key = "list_enabled_color"
            )
            ColorPickerTool(
                title = "特殊·背景色",
                key = "list_warning_color"
            )
        }
        classes(
            title = "蓝牙临时开启状态"
        ){
            ColorPickerTool(
                title = "背景色",
                key = "list_restricted_color"
            )
        }

        classes(
            title = "禁用状态"
        ){
            ColorPickerTool(
                title = "背景色",
                key = "list_unavailable_color"
            )
        }


    }
}