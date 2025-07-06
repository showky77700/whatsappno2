import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

Future<void> openNotificationAccessSettings() async {
  const platform = MethodChannel('notification_access');
  await platform.invokeMethod('openSettings');
}


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key}); // استخدام المفتاح ضروري لتحسين الأداء

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'WhatsApp Listener',
      debugShowCheckedModeBanner: false, // إخفاء شريط "debug"
      theme: ThemeData(
        primarySwatch: Colors.green, // لون التطبيق
      ),
      home: const HomeScreen(),
    );
  }
}

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('مراقبة إشعارات واتساب'),
      ),
      body: const Center(
        child: Text(
          'انتظر وصول الرسائل...',
          style: TextStyle(fontSize: 18),
        ),
      ),
    );
  }
}
