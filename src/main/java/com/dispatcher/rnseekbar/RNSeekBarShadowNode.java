package com.dispatcher.rnseekbar;

import javax.annotation.Nullable;

import java.util.HashSet;
import java.util.Set;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactProp;

/**
 * Node responsible for holding the style of the ProgressBar, see under
 * {@link android.R.attr.progressBarStyle} for possible styles. ReactProgressBarViewManager
 * manages how this style is applied to the ProgressBar.
 */
public class RNSeekBarShadowNode extends LayoutShadowNode implements CSSNode.MeasureFunction {  

  private Integer mHeight = -1;
  private Integer mWidth = -1;
  

  public RNSeekBarShadowNode() {
    setMeasureFunction(this);
  }

  @Override
  public void measure(CSSNode node, float width, MeasureOutput measureOutput) {    
    if (mWidth == -1) {
      SeekBar seekBar = new SeekBar(getThemedContext(), null);
      final int spec = View.MeasureSpec.makeMeasureSpec(
          ViewGroup.LayoutParams.MATCH_PARENT,
          View.MeasureSpec.UNSPECIFIED);
      seekBar.measure(spec, spec);
      mHeight = seekBar.getMeasuredHeight();
      mWidth = seekBar.getMeasuredWidth();     
    }

    measureOutput.height = mHeight;
    measureOutput.width = mWidth;
  }
}