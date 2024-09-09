package com.chaos.hyperstar.ui.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.chaos.hyperstar.utils.EventState
import top.yukonga.miuix.kmp.MiuixSuperArrow


@Composable
fun MiuixIntentSuperArrow(
    leftIcon : Int? = null,
    title : String,
    summary : String? = null,
    url : String,
    activity: ComponentActivity
)
{
    var eventState by remember { mutableStateOf(EventState.Idle) }
    val scale by animateFloatAsState(if (eventState == EventState.Pressed) 0.90f else 1f)

    MiuixSuperArrow(
        modifier = Modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
        }.pointerInput(eventState) {
            awaitPointerEventScope {
                eventState = if (eventState == EventState.Pressed) {
                    waitForUpOrCancellation()
                    EventState.Idle
                } else {
                    awaitFirstDown(false)
                    EventState.Pressed
                }
            }
        },
        leftAction = if (leftIcon != null){ {
            Image(
                painter = painterResource(leftIcon),
                contentDescription = title,
                modifier = Modifier.size(35.dp)
            )
        } }else{ null },
        title = title,
        summary = summary,
        onClick = {
            // 启动新的Activity
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    )
}
@Composable
fun MiuixActivitySuperArrow(
    leftIcon:Int ? = null,
    title : String,
    summary : String ? = null,
    activity: Class<*> ,
    context: Context
) {
    var eventState by remember { mutableStateOf(EventState.Idle) }
    val scale by animateFloatAsState(if (eventState == EventState.Pressed) 0.90f else 1f)

    MiuixSuperArrow(
        modifier = Modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
        }.pointerInput(eventState) {
            awaitPointerEventScope {
                eventState = if (eventState == EventState.Pressed) {
                    waitForUpOrCancellation()
                    EventState.Idle
                } else {
                    awaitFirstDown(false)
                    EventState.Pressed
                }
            }
        },
        leftAction = if (leftIcon != null){ {
            Image(
                painter = painterResource(leftIcon),
                contentDescription = title,
                modifier = Modifier.size(35.dp)
            )
        } }else{ null },
        title = title,
        summary = summary,
        onClick = {
            // 启动新的Activity
            context.startActivity(Intent(context, activity))
        }
    )
}
