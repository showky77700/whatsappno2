package com.showky1.whatsappno2; // غيّرها حسب package name

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotificationListener extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();

        // فلترة إشعارات واتساب فقط
        if (packageName.equals("com.whatsapp")) {
            CharSequence title = sbn.getNotification().extras.getCharSequence("android.title");
            CharSequence text = sbn.getNotification().extras.getCharSequence("android.text");

            // طباعة الرسالة في Logcat
            Log.d("WHATSAPP_NOTIFICATION", "من: " + title + "، رسالة: " + text);
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // يمكن استخدامه لاحقًا إن أردت معرفة متى يُزال الإشعار
    }
}
