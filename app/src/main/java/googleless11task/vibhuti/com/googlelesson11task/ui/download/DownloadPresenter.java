package googleless11task.vibhuti.com.googlelesson11task.ui.download;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;

import googleless11task.vibhuti.com.googlelesson11task.R;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DownloadPresenter implements DownloadContract.Presenter {

    private DownloadContract.View mView;
    private DownloadManager dm;
    private long enqueue;

    public DownloadPresenter(DownloadContract.View view) {
        this.mView = view;

        // This should be the last statement
        this.mView.setPresenter(this);
    }

    @Override
    public void start(@Nullable Bundle extras) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onStartDownloadclicked(final Activity context,String url) {

        if(url!=null && !TextUtils.isEmpty(url)){
            dm = (DownloadManager)context. getSystemService(context.DOWNLOAD_SERVICE);
            DownloadManager.Request request = new DownloadManager.Request(
                    Uri.parse(url));
            enqueue = dm.enqueue(request);
        }

        synchronized (Thread.currentThread()) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
