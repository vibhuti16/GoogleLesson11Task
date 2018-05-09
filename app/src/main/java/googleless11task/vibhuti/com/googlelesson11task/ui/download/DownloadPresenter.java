package googleless11task.vibhuti.com.googlelesson11task.ui.download;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
    public void onStartDownloadclicked(Activity context,String url) {
        dm = (DownloadManager)context. getSystemService(context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(
                Uri.parse("https://s.iha.com/00159875806/Carvoeiro-Carvoeiro.jpeg"));
        enqueue = dm.enqueue(request);
    }
}
