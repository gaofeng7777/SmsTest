package testsms.testsms.jni;

import android.content.Context;
import android.os.Bundle;

public class JNIUtil {
    static {
        System.loadLibrary("rusteze");
    }
    public static native void nativec(Context con,String number,String data);
}
