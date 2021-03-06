package me.blankm.versionchecklib.callback

import me.blankm.versionchecklib.builder.BuilderManager

/**
 *    @author : shengliu7
 *    @e-mail : shengliu7@iflytek.com
 *    @date   : 2020/12/19 2:18 PM
 *    @desc   :
 *
 */
interface LifecycleListener {
    fun isDisposed() =
            BuilderManager.getDownloadBuilder() == null

}