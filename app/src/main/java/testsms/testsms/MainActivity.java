package testsms.testsms;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import testsms.testsms.jni.JNIUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //监听短信内容
                getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, new MainContentObserver(MainActivity.this, new Handler()));
                //发短信
                JNIUtil.nativec(MainActivity.this,"10010","cxye");


            }
        });

    }
}
