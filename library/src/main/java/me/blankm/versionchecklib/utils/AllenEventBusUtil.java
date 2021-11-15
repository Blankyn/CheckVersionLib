package me.blankm.versionchecklib.utils;


import org.greenrobot.eventbus.EventBus;

import me.blankm.versionchecklib.eventbus.CommonEvent;

/**
 * Created by admin on 2018/1/18.
 */

public class AllenEventBusUtil {
    public static void sendEventBus(int eventType) {
        CommonEvent commonEvent = new CommonEvent();
        commonEvent.setSuccessful(true);
        commonEvent.setEventType(eventType);
        EventBus.getDefault().post(commonEvent);
    }
    public static void sendEventBusStick(int eventType) {
        CommonEvent commonEvent = new CommonEvent();
        commonEvent.setSuccessful(true);
        commonEvent.setEventType(eventType);
        EventBus.getDefault().postSticky(commonEvent);
    }
}
