import 'dart:async';

import 'package:flutter/services.dart';

class FlutterToast {
  static const MethodChannel _channel = const MethodChannel('flutter_toast');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<Null> showToast(String msg,
      {String duration, int textColor, double textSize}) async {
    _channel.invokeMethod('showToast', {
      'msg': msg,
      'duration': duration,
      'textColor': textColor,
      'textSize': textSize,
    });
    return null;
  }
}
