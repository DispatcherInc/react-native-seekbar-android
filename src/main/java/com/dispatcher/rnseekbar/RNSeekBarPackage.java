package com.dispatcher.rnseekbar;

import android.app.Activity;

import java.util.*;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

public class RNSeekBarPackage implements ReactPackage {

    public RNSeekBarPackage() {
        
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return new ArrayList<>();
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new RNSeekBarViewManager()
        );        
    }

}