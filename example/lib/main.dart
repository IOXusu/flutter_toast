import 'package:flutter/material.dart';
import 'package:flutter_toast/flutter_toast.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: RaisedButton(
            onPressed: () {
              FlutterToast.showToast('Hello Xusu',
                  duration: 'short', textColor: 0xffff0000, textSize: 20.0);
            },
          ),
        ),
      ),
    );
  }
}
