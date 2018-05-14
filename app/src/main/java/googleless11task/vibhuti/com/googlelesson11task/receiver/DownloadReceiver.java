package googleless11task.vibhuti.com.googlelesson11task.receiver;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import googleless11task.vibhuti.com.googlelesson11task.R;
import googleless11task.vibhuti.com.googlelesson11task.ui.download.ShowImageActivity;

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
}
