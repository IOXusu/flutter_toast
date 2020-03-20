package com.xusu.flutter_toast

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

public class FlutterToastPlugin : MethodCallHandler {

    lateinit var mContext: Context
    lateinit var mToast: Toast

    constructor(context: Context) {
        mContext = context
    }

    companion object {
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "com.xusu.flutter_toast/flutter_toast")
            channel.setMethodCallHandler(FlutterToastPlugin(registrar.context()))
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        if (call.method == "showToast") {
            val msg = call.argument<String>("msg")
            val duration = call.argument<String>("duration")
            val textColor = call.argument<Number>("textColor")
            val textSize = call.argument<Number>("textSize")
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT)
            if (msg != null) {
                mToast.setText(msg)
            }
            if (duration != null) {
                if (duration.equals("long")) {
                    mToast.duration = Toast.LENGTH_LONG
                } else {
                    mToast.duration = Toast.LENGTH_SHORT
                }
            }
            val textView: TextView = mToast.view.findViewById(android.R.id.message) as TextView
            if (textView != null) {
                textView.text = msg
                textView.setTextColor(textColor as Int)
                textView.setTextSize(textSize as Float)
            }
            mToast.show()
        } else {
            result.notImplemented()
        }
    }
}
