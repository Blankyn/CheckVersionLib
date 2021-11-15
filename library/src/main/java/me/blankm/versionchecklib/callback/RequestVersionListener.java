package me.blankm.versionchecklib.callback;

import androidx.annotation.Nullable;

import me.blankm.versionchecklib.builder.DownloadBuilder;
import me.blankm.versionchecklib.builder.UIData;

/**
 * Created by admin on 2018/1/12.
 */

public interface RequestVersionListener  {
    /**
     * @param result the result string of request
     * @return developer should return version bundle ,to use when showing UI page,could be null
     */
    @Nullable
    UIData onRequestVersionSuccess(DownloadBuilder downloadBuilder, String result);

    void onRequestVersionFailure(String message);

}
