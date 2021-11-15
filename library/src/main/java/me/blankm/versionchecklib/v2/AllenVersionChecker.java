package me.blankm.versionchecklib.v2;

import android.content.Context;

import androidx.annotation.Nullable;
import me.blankm.versionchecklib.core.http.AllenHttp;
import me.blankm.versionchecklib.utils.AllenEventBusUtil;
import me.blankm.versionchecklib.v2.builder.DownloadBuilder;
import me.blankm.versionchecklib.v2.builder.RequestVersionBuilder;
import me.blankm.versionchecklib.v2.builder.UIData;
import me.blankm.versionchecklib.v2.eventbus.AllenEventType;

/**
 * Created by allenliu on 2018/1/12.
 */

public class AllenVersionChecker {


    private AllenVersionChecker() {

    }

    public static AllenVersionChecker getInstance() {
        return AllenVersionCheckerHolder.allenVersionChecker;
    }

    private static class AllenVersionCheckerHolder {
        public static final AllenVersionChecker allenVersionChecker = new AllenVersionChecker();
    }

    @Deprecated
    public void cancelAllMission(Context context) {
        cancelAllMission();
    }

    public void cancelAllMission() {
        AllenHttp.getHttpClient().dispatcher().cancelAll();
//        Intent intent = new Intent(context.getApplicationContext(), VersionService.class);
//        context.getApplicationContext().stopService(intent);
        AllenEventBusUtil.sendEventBusStick(AllenEventType.CLOSE);
        AllenEventBusUtil.sendEventBusStick(AllenEventType.STOP_SERVICE);
    }

    /**
     * @param versionBundle developer should return version bundle ,to use when showing UI page,could be null
     * @return download builder for download setting
     */
    public DownloadBuilder downloadOnly(@Nullable UIData versionBundle) {
        return new DownloadBuilder(null, versionBundle);
    }

    /**
     * use request version function
     *
     * @return requestVersionBuilder
     */
    public RequestVersionBuilder requestVersion() {
        return new RequestVersionBuilder();
    }

}
