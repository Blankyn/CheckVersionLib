package me.blankm.versionchecklib.callback;

import android.app.Dialog;
import android.content.Context;

import me.blankm.versionchecklib.builder.UIData;

/**
 * Created by admin on 2018/1/18.
 */

public interface CustomVersionDialogListener {
    Dialog getCustomVersionDialog(Context context, UIData versionBundle);
}
