package com.chaos.hyperstar.ui.module.volume

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.chaos.hyperstar.ui.base.BaseActivity

class VolumeSettings : BaseActivity() {
    @Composable
    override fun InitView(colorMode: MutableState<Int>?) {
        VolumePager(this)
    }

    override fun initData() {

    }



}