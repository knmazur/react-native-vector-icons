package com.oblador.vectoricons;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.views.text.ReactFontManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class VectorIconsModule extends NativeVectorIconsSpec {
  private VectorIconsModuleImpl delegate;

  @Override
  public String getName() {
    return VectorIconsModuleImpl.REACT_CLASS;
  }

  public VectorIconsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    delegate = new VectorIconsModuleImpl(reactContext);
  }

  @ReactMethod
  public void getImageForFont(String fontFamily, String glyph, double fontSize, double color, final Promise promise) {
    delegate.getImageForFont(fontFamily, glyph, (int)fontSize, (int)color, promise);
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  public String getImageForFontSync(String fontFamily, String glyph, double fontSize, double color) {
    return delegate.getImageForFontSync(fontFamily, glyph, (int)fontSize, (int)color);
  }
}
