package me.blankm.versionchecklib.net;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import me.blankm.versionchecklib.core.http.AllenHttp;
import me.blankm.versionchecklib.core.http.FileCallBack;
import me.blankm.versionchecklib.callback.DownloadListenerKt;

import java.io.File;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2018/1/18.
 */

public class DownloadManger {
    public static void download(final String url, String referer, final String downloadApkPath, final String fileName, final DownloadListenerKt listener) {
        if (url != null && !url.isEmpty()) {
            Request request = new Request
                    .Builder()
                    //#issue 220
                    .addHeader("Accept-Encoding", "identity")
                    .addHeader("Referer", TextUtils.isEmpty(referer) ? "" : referer)
                    .url(url).build();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (listener != null && !listener.isDisposed())
                        listener.onCheckerStartDownload();
                }
            });

            AllenHttp.getHttpClient().newCall(request).enqueue(new FileCallBack(downloadApkPath, fileName) {
                @Override
                public void onSuccess(final File file, Call call, Response response) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            if (listener != null && !listener.isDisposed())
                                listener.onCheckerDownloadSuccess(file);
                        }
                    });
                }

                @Override
                public void onDownloading(final int progress) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            if (listener != null && !listener.isDisposed())
                                listener.onCheckerDownloading(progress);
                        }
                    });
                }

                @Override
                public void onDownloadFailed() {
                    handleFailed(listener);
                }
            });


        } else {
            throw new RuntimeException("you must set download url for download function using");
        }
    }


    private static void handleFailed(final DownloadListenerKt listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (listener != null && !listener.isDisposed())
                    listener.onCheckerDownloadFail();

            }
        });
    }

}
