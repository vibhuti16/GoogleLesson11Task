package googleless11task.vibhuti.com.googlelesson11task.ui.download;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import googleless11task.vibhuti.com.googlelesson11task.R;

public class DownloadActivity extends AppCompatActivity implements DownloadContract.View{

    private DownloadContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        PresenterInjector.injectDownloadPresenter(this);

        final EditText edtUrl = findViewById(R.id.edt_url);
        findViewById(R.id.btn_edt_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPresenter.onStartDownloadclicked(DownloadActivity.this,edtUrl.getText().toString());
            }
        });
    }

    @Override
    public void setPresenter(DownloadContract.Presenter presenter) {

        this.mPresenter = presenter;
    }

    @Override
    public void showNotification() {

        Toast.makeText(DownloadActivity.this,"Download complete",Toast.LENGTH_LONG).show();
    }
}
