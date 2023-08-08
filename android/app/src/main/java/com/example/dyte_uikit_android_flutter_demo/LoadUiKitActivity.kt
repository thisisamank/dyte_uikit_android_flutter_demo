package com.example.dyte_uikit_android_flutter_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dyte.io.uikit.DyteUIKitBuilder
import dyte.io.uikit.DyteUIKitInfo
import io.dyte.core.models.DyteMeetingInfoV2

class LoadUiKitActivity : AppCompatActivity() {
    val meetingInfo = DyteMeetingInfoV2(
        authToken = "HARDCODED"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_ui_kit)
        val dyteUIKitInfo = DyteUIKitInfo(
            activity = this,
            dyteMeetingInfo = meetingInfo
        )
        val dyteUIKit = DyteUIKitBuilder.build(dyteUIKitInfo)
        dyteUIKit.startMeeting()
    }
}