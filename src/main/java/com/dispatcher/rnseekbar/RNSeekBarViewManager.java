package com.dispatcher.rnseekbar;

import android.util.Log;

import javax.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.CatalystStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ViewProps;

import java.util.ArrayList;
import java.util.Map;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class RNSeekBarViewManager extends BaseViewManager<FrameLayout, RNSeekBarShadowNode> {
    public static final String REACT_CLASS = "RNSeekBar";
    public static final String PROP_PROGRESS = "progress";
    public static final String PROP_MAX = "max";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = PROP_PROGRESS)
    public void setProgress(FrameLayout view, @Nullable Integer value) {      
      if(view.getChildCount() == 0) {
        throw new IllegalStateException("SeekBar not yet created");
      }

      SeekBar sb = (SeekBar)view.getChildAt(0);
      if(sb.getProgress() == value) {
        return;
      }
      sb.setProgress(value);
    }

    @ReactProp(name = PROP_MAX)
    public void setMax(FrameLayout view, @Nullable Integer max) {      
      if(view.getChildCount() == 0) {
        throw new IllegalStateException("SeekBar not yet created");
      }

      SeekBar sb = (SeekBar)view.getChildAt(0);
      sb.setMax(max);
    }

    @Override
    protected FrameLayout createViewInstance(ThemedReactContext context) {
        final FrameLayout view = new FrameLayout(context);
        SeekBar sb = new SeekBar(view.getContext(), null);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {       
          @Override public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override public void onStopTrackingTouch(SeekBar seekBar) {
            
          }

          @Override       
          public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {     
            WritableMap event = Arguments.createMap();
            event.putInt("progress", progress);
            ReactContext reactContext = (ReactContext)view.getContext();
            reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                view.getId(),
                "topChange",
                event);                                        
          }
        });

        view.addView(
            sb,
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

  	@Override
  	public RNSeekBarShadowNode createShadowNodeInstance() {
    	return new RNSeekBarShadowNode();
  	}

  	@Override
  	public Class<RNSeekBarShadowNode> getShadowNodeClass() {
    	return RNSeekBarShadowNode.class;
  	}

  	@Override
    public void updateExtraData(FrameLayout root, Object extraData) {
  	}
}
