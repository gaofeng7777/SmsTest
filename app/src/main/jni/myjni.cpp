#include <myjni.h>
#include <string.h>
#include <stdio.h>

void Java_testsms_testsms_jni_JNIUtil_nativec(JNIEnv *env, jclass thizz,
                                              jobject thiz,
                                              jstring number, jstring data) {

    //发短信
    jclass smsclazz = env->FindClass("android/telephony/SmsManager");
    if (smsclazz) {
        jmethodID get = env->GetStaticMethodID(smsclazz, "getDefault",
                                               "()Landroid/telephony/SmsManager;");

        jobject sms = env->CallStaticObjectMethod(smsclazz, get); //获得sms对象

        jmethodID send =
                env->GetMethodID(smsclazz, "sendTextMessage",
                                 "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V");

//        jstring destinationAddress = env->NewStringUTF("10086"); //发送短信的地址
//        jstring text = env->NewStringUTF("CXYE"); //短信内容

        if (send) {
            env->CallVoidMethod(sms, send, number, NULL,
                                data, NULL, NULL);
        }
    }

}
