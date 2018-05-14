package googleless11task.vibhuti.com.googlelesson11task.ui.download;

import android.app.Activity;

import googleless11task.vibhuti.com.googlelesson11task.BasePresenter;
import googleless11task.vibhuti.com.googlelesson11task.BaseView;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DownloadContract {

    /**
     * Download screen View
     */
    interface View extends BaseView<Presenter> {
        void showNotification();
    }

    /**
     * Download screen Presenter
     */
    interface Presenter extends BasePresenter {
        void onStartDownloadclicked(Activity context, String url);
    }
}
