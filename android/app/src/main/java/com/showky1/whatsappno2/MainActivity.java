package com.showky1.whatsappno2;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import android.content.Intent;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(io.flutter.embedding.engine.FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "notification_access")
            .setMethodCallHandler(
                (call, result) -> {
                    if (call.method.equals("openSettings")) {
                        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        result.success(null);
                    }
                }
            );
    }
}

