package me.blankm.versionchecklib.callback;

import java.io.File;

/**
 * Created by admin on 2017/8/16.
 */

public interface APKDownloadListener {
     void onDownloading(int progress);
    void onDownloadSuccess(File file);
    void onDownloadFail();
}
