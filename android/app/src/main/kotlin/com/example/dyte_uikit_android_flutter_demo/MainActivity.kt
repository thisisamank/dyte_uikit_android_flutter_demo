package com.example.dyte_uikit_android_flutter_demo

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel


class MainActivity: FlutterActivity() {

    private lateinit var uiKitChannel: MethodChannel
    private val channelName: String = "io.dyte/launch_android_uikit"


    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        uiKitChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName);
        uiKitChannel
            .setMethodCallHandler { call: MethodCall, result: MethodChannel.Result ->
                if (call.method == "launchAndroidUiKit") {
                    val intent = Intent(this, LoadUiKitActivity::class.java)
                    startActivity(intent)
                    result.success(null)
                } else {
                    result.notImplemented()
                }
            }
    }


}
