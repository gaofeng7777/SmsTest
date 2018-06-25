#include <jni.h>

#ifdef __cplusplus

extern "C" {

jstring Java_testsms_testsms_jni_JNIUtil_getPWD(JNIEnv *, jobject, jobject);
void Java_testsms_testsms_jni_JNIUtil_nativec(JNIEnv *, jclass, jobject, jstring,jstring);
}

#endif
