package me.blankm.versionchecklib.utils;

import android.util.Log;

import me.blankm.versionchecklib.core.AllenChecker;

/**
 * Created by allenliu on 2017/8/16.
 */

public class ALog {
    public static void e(String msg) {
        if (AllenChecker.isDebug()) {
            if (msg != null && !msg.isEmpty())
                Log.e("Allen Checker", msg);
        }
    }
}
