package com.chaos.hyperstar.ui.module.controlcenter.media

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chaos.hyperstar.R
import com.chaos.hyperstar.ui.base.ActivityPager
import com.chaos.hyperstar.ui.base.ActivityPagers
import com.chaos.hyperstar.ui.base.MiuixActivitySuperArrow
import com.chaos.hyperstar.ui.base.XMiuixClasser
import com.chaos.hyperstar.ui.base.XMiuixContentSwitch
import com.chaos.hyperstar.ui.base.XMiuixSuperDropdown
import com.chaos.hyperstar.ui.base.XMiuixSuperSliderSwitch
import com.chaos.hyperstar.ui.base.XMiuixSuperSwitch
import com.chaos.hyperstar.ui.module.controlcenter.media.app.MediaDefaultAppSettingsActivity
import com.chaos.hyperstar.utils.Utils


@Composable
fun MediaSettingsPager(activity: ComponentActivity) {
    ActivityPagers(
        activityTitle = "妙播设置",
        activity = activity,
        endClick = {
            Utils.rootShell("killall com.android.systemui")
                   },
        ){
            item{
                XMiuixClasser(
                    title = "基础设置",
                    content = {
                        MiuixActivitySuperArrow(
                            title = "默认播放应用选择",
                            context = activity,
                            activity = MediaDefaultAppSettingsActivity::class.java
                        )
                    }
                )
                XMiuixClasser(
                    title = "常规播放页",
                    top = 12.dp,
                    content = {

                        XMiuixContentSwitch(
                            switchTitle = "隐藏歌曲封面显示",
                            switchKey = "is_hide_cover",
                            content = {
                                XMiuixSuperSwitch(
                                    title = "标题&歌手居中显示",
                                    key = "is_title_center"
                                )

                            }
                        )
                        XMiuixSuperSwitch(
                            title = "标题过长滚动显示",
                            key = "is_title_marquee"
                        )
                        XMiuixSuperSwitch(
                            title = "歌手过长滚动显示",
                            key = "is_artist_marquee"
                        )
                        XMiuixSuperSwitch(
                            title = "暂无播放过长滚动显示",
                            key = "is_emptyState_marquee"
                        )
                        XMiuixContentSwitch(
                            switchTitle = stringResource(R.string.is_cover_background_title),
                            switchKey = "is_cover_background",
                            content = {
                                XMiuixSuperSliderSwitch(
                                    switchTitle = stringResource(R.string.is_cover_scale_background_title),
                                    switchKey = "is_cover_scale_background",
                                    title = stringResource(R.string.cover_scale_background_value_title),
                                    key = "cover_scale_background_value",
                                    progress = 1.5f,
                                    maxValue = 2f,
                                    minValue = 1.1f,
                                    decimalPlaces = 2
                                )
                                XMiuixSuperSliderSwitch(
                                    switchTitle = stringResource(R.string.is_cover_blur_background_title),
                                    switchKey = "is_cover_blur_background",
                                    title = stringResource(R.string.cover_blur_background_value_title),
                                    key = "cover_blur_background_value",
                                    progress = 50f,
                                    maxValue = 60f,
                                    minValue = 0f,
                                    decimalPlaces = 2
                                )
                                XMiuixSuperSliderSwitch(
                                    switchTitle = stringResource(R.string.is_cover_dim_background_title),
                                    switchKey = "is_cover_dim_background",
                                    title = stringResource(R.string.cover_dim_background_value_title),
                                    key = "cover_dim_background_value",
                                    progress = 50f,
                                    maxValue = 255f,
                                    minValue = 0f
                                )

                                XMiuixSuperSwitch(
                                    title = "启用封面背景暗边",
                                    key = "cover_anciently"
                                )
                            }
                        )

                    }
                )
                XMiuixClasser(
                    title = "扩展详情页",
                    top = 12.dp,
                    content = {
                        XMiuixSuperDropdown(
                            title = "设备名显示模式",
                            key = "is_local_speaker",
                            activity = activity,
                            option = R.array.is_local_speaker_entire,
                        )
                    }
                )
            }
    }

}
