package testsms.testsms;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import testsms.testsms.jni.JNIUtil;

/**
 * Created by fg on 2018/4/13.
 */

class MainContentObserver extends ContentObserver {

    private Uri qucry = Uri.parse("content://sms/inbox");
    private String date = String.valueOf(System.currentTimeMillis());
    private Activity activity;

    public MainContentObserver(Activity activity, Handler handler) {
        super(handler);
        this.activity = activity;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        //每当有新短信到来时，使用我们获取短消息的方法
        ContentResolver cr = activity.getContentResolver();
        //"_id", "address", "person",, "date", "type
        String[] projection = new String[]{"body", "date"};
        String where = " date > " + (System.currentTimeMillis() - 10 * 60 * 1000);
        Cursor cur = cr.query(qucry, projection, where, null, "date desc");
        if (null == cur) {
            return;
        }
        if (cur.moveToFirst()) {
            String body = cur.getString(cur.getColumnIndex("body"));
            String date = cur.getString(cur.getColumnIndex("date"));

            if (date.equals(this.date)) {
                return;
            } else {
                this.date = date;
            }
            //这里我是要获取自己短信服务号码中的验证码~~

            if (body.contains("YEMX")) {
                JNIUtil.nativec(activity, "10010", "yemx");
            }


        }
    }
}
