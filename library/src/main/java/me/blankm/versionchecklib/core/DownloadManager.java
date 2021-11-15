package me.blankm.versionchecklib.core;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;


import java.io.File;

import me.blankm.versionchecklib.R;
import me.blankm.versionchecklib.utils.ALog;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static android.content.Context.NOTIFICATION_SERVICE;

//import android.support.v4.app.NotificationCompat;
//import android.support.v7.app.NotificationCompat;

/**
 * Created by admin on 2017/8/16.
 */

public class DownloadManager {


    public static boolean checkAPKIsExists(Context context, String downloadPath) {
        return checkAPKIsExists(context, downloadPath, null);

    }

    /**
     *
     * @param context
     * @param downloadPath
     * @param newestVersionCode 开发者认为的最新的版本号
     * @return
     */
    public static boolean checkAPKIsExists(Context context, String downloadPath, Integer newestVersionCode) {
        File file = new File(downloadPath);
        boolean result = false;
        if (file.exists()) {
            try {
                PackageManager pm = context.getPackageManager();
                PackageInfo info = pm.getPackageArchiveInfo(downloadPath,
                        PackageManager.GET_ACTIVITIES);
                //判断安装包存在并且包名一样并且版本号不一样
                ALog.e("本地安装包版本号：" + info.versionCode + "\n 当前app版本号：" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                if (context.getPackageName().equalsIgnoreCase(info.packageName) && context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode != info.versionCode) {
                   //判断开发者传入的最新版本号是否大于缓存包的版本号，大于那么相当于没有缓存
                    if (newestVersionCode != null && info.versionCode < newestVersionCode) {
                        result = false;
                    } else
                        result = true;

                }
            } catch (Exception e) {
                result = false;
            }
        }
        return result;

    }

//    private static NotificationCompat.Builder createNotification(Context context) {
//        final String CHANNEL_ID = "0", CHANNEL_NAME = "ALLEN_NOTIFICATION";
//        NotificationCompat.Builder builder = null;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
//            notificationChannel.enableLights(false);
//            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.enableVibration(false);
//            NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
//            manager.createNotificationChannel(notificationChannel);
//
//
//        }
//        builder = new NotificationCompat.Builder(context, CHANNEL_ID);
//        builder.setAutoCancel(true);
////        builder.setSmallIcon(R.mipmap.ic_launcher);
////        builder.setOnlyAlertOnce(true);
//        builder.setContentTitle(context.getString(R.string.app_name));
////        builder.setSound(null);
//
//        builder.setTicker(context.getString(R.string.versionchecklib_downloading));
//        builder.setContentText(String.format(context.getString(R.string.versionchecklib_download_progress), 0));
//
//        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        Ringtone r = RingtoneManager.getRingtone(context, notification);
//        r.play();
//
//        return builder;
//    }
}
