package googleless11task.vibhuti.com.googlelesson11task.receiver;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import googleless11task.vibhuti.com.googlelesson11task.R;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class DownloadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
            Notification("Download",context,"Complete");
        }
    }

    public void Notification(String title,Context context, String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "")
                .setSmallIcon(R.drawable.ic_cloud_download)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        mBuilder.notify();

    }
}
