package googleless11task.vibhuti.com.googlelesson11task.ui.download;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import googleless11task.vibhuti.com.googlelesson11task.R;

public class ShowImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        String uri = getIntent().getStringExtra("url");
        ((ImageView)findViewById(R.id.img_downloaded_image)).setImageURI(Uri.parse(uri));

    }

}
