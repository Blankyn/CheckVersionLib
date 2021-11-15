package me.blankm.versionchecklib.v2.callback;

import android.app.Dialog;
import android.content.Context;

import me.blankm.versionchecklib.v2.builder.UIData;

/**
 * Created by allenliu on 2018/1/18.
 */

public interface CustomDownloadFailedListener {
    Dialog getCustomDownloadFailed(Context context, UIData versionBundle);

}
