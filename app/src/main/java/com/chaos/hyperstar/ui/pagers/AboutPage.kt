package com.chaos.hyperstar.ui.pagers

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaos.hyperstar.R
import com.chaos.hyperstar.ui.base.MiuixIntentSuperArrow
import com.chaos.hyperstar.ui.base.XMiuixClass
import getWindowSize
import top.yukonga.miuix.kmp.MiuixScrollBehavior
import top.yukonga.miuix.kmp.MiuixSuperSwitch
import top.yukonga.miuix.kmp.basic.MiuixCard
import top.yukonga.miuix.kmp.basic.MiuixLazyColumn
import top.yukonga.miuix.kmp.basic.MiuixText
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.utils.enableOverscroll

@Composable
fun ThirdPage(
    activity : ComponentActivity,
    topAppBarScrollBehavior: MiuixScrollBehavior,
    padding: PaddingValues,
    enableOverScroll: Boolean,
) {
    MiuixLazyColumn(
        modifier = Modifier.height(getWindowSize().height.dp),
        enableOverScroll = enableOverScroll,
        contentPadding = PaddingValues(top = padding.calculateTopPadding()+16.dp, bottom = padding.calculateBottomPadding()+16.dp),
        topAppBarScrollBehavior = topAppBarScrollBehavior
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                MiuixText(
                    text = "Hyper",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                MiuixText(
                    text = "Star",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.blue),
                )
            }

            MiuixText(
                text = stringResource(id = R.string.xposed_desc),
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 140.dp),
                fontWeight = FontWeight.Medium,
                color = MiuixTheme.colorScheme.subTextBase,
                textAlign = TextAlign.Center
            )

        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            MiuixCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 12.dp),
                insideMargin = DpSize(0.dp,14.dp)
            ) {

                MiuixText(
                    text = stringResource(R.string.developer_title),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 10.dp, bottom = 8.dp),
                    fontSize = 15.sp,
                    color = colorResource(R.color.class_name_color),
                    fontWeight = FontWeight.Medium
                )
                MiuixIntentSuperArrow(
                    leftIcon = R.drawable.dd,
                    title = "东东说他舍不得",
                    summary = "@GG Chaos | Hook",
                    activity = activity,
                    url = "coolmarket://u/8555749"
                )
            }

        }
        item {
            MiuixCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 12.dp),
                insideMargin = DpSize(0.dp,14.dp)
            ) {
                MiuixText(
                    text = stringResource(R.string.discussion_title),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 10.dp, bottom = 8.dp),
                    fontSize = 15.sp,
                    color = colorResource(R.color.class_name_color),
                    fontWeight = FontWeight.Medium
                )
                MiuixIntentSuperArrow(
                    title = stringResource(R.string.qq_group_title),
                    activity = activity,
                    url = "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&amp;k=5ONF7LuaoQS6RWEOUYBuA0x4X8ssvHJp&amp;authKey=Pic4VQJxKBJwSjFzsIzbJ50ILs0vAEPjdC8Nat4zmiuJRlftqz9%2FKjrBwZPQTc4I&amp;noverify=0&amp;group_code=810317966"
                )
                MiuixIntentSuperArrow(
                    title = "Telegram",
                    activity = activity,
                    url = "https://t.me/+QQWVM0ToHyEyZmRl"
                )
            }



            MiuixCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                    insideMargin = DpSize(0.dp,14.dp),
            ) {
                MiuixText(
                    text = stringResource(R.string.references_title),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 10.dp, bottom = 8.dp),
                    fontSize = 15.sp,
                    color = colorResource(R.color.class_name_color),
                    fontWeight = FontWeight.Medium
                )
                MiuixIntentSuperArrow(
                    title = "miuix-kotlin-multiplatform",
                    summary = "YuKongA | Apache-2.0",
                    activity = activity,
                    url = "https://github.com/miuix-kotlin-multiplatform/miuix"
                )
                MiuixIntentSuperArrow(
                    title = "Xposed",
                    summary = "rovo89,Tungstwenty | Apache-2.0",
                    activity = activity,
                    url = "https://github.com/rovo89/XposedBridge"
                )
                MiuixIntentSuperArrow(
                    title = "HyperCeiler",
                    summary = "ReChronoRain | AGPL-3.0",
                    activity = activity,
                    url = "https://github.com/ReChronoRain/HyperCeiler"
                )
            }



        }
    }
}