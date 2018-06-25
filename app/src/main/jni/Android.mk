LOCAL_PATH:=$(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:=rusteze

LOCAL_SRC_FILES:=myjni.cpp myjni.h

include $(BUILD_SHARED_LIBRARY)
