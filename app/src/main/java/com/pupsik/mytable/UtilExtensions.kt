package com.pupsik.mytable

import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
how to use (RequestObject)
activity.setLightStatusBar()
activity.clearLightStatusBar()
 **/

// make black text to statusBar (time, battery)
fun AppCompatActivity.setLightStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        var flags = this.window.decorView.systemUiVisibility
        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        this.window.decorView.systemUiVisibility = flags
    }
}

//make white text to statusBar (time, battery)
fun AppCompatActivity.clearLightStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        var flags = this.window.decorView.systemUiVisibility
        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        this.window.decorView.systemUiVisibility = flags
        flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        this.window.decorView.systemUiVisibility = flags
    }
}