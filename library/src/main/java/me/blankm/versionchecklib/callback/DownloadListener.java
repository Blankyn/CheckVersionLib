package me.blankm.versionchecklib.callback;

import java.io.File;

/**
 * Created by admin on 2017/8/16.
 */

public interface DownloadListener  {
    void onCheckerDownloading(int progress);
    void onCheckerDownloadSuccess(File file);
    void onCheckerDownloadFail();
    void onCheckerStartDownload();
}
