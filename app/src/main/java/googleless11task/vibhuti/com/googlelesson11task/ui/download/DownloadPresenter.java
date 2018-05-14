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

    public void Notification(String title,Context context, String message) {
        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(context, ShowImageActivity.class);
        // Send data to NotificationView Class
        intent.putExtra("title", title);
        intent.putExtra("text", message);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Create Notification using NotificationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context)
                // Set Icon
                .setSmallIcon(R.drawable.ic_cloud_download)
                // Set Ticker Message
                .setTicker(message)
                // Set Title
                .setContentTitle(title)
                // Set Text
                .setContentText(message)
                // Add an Action Button below Notification
                .addAction(R.drawable.ic_cloud_download, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());

    }

    @Override
    public void registerReceiver(Activity context) {
        final Thread backgroundThread = Thread.currentThread();
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context,"download complete",Toast.LENGTH_LONG).show();
                long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,0);
                if (downloadId == enqueue) {
                    synchronized (backgroundThread) {
                        backgroundThread.notify();
                        String action = intent.getAction();
                        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                            Notification("Download",context,"Complete");
                        }
                    }
                }
            }
        };

        context.registerReceiver(receiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }
}
