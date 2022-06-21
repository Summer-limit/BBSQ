/*
package com.nwnujsj.classtable.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class MySlideSwitch
  extends View
{
  private static boolean isSwitchOn;
  private int circleColor;
  private MySwitchStateChangeListener listener;
  private Paint paint;
  private float radius;
  private RectF rect;
  private int switchOffColor;
  private int switchOnColor;
  private int textColor;
  private float textSize;
  
  public MySlideSwitch(Context paramContext)
  {
    super(paramContext);
  }
  
  public MySlideSwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet, paramContext);
  }
  
  public MySlideSwitch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet, paramContext);
  }
  
  private void init(AttributeSet paramAttributeSet, Context paramContext)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MySlideSwitch);
    int j = paramAttributeSet.getIndexCount();
    int i = 0;
    if (i >= j)
    {
      paramAttributeSet.recycle();
      this.paint = new Paint();
      this.rect = new RectF();
      setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MySlideSwitch.this.changeSwitchStatus();
        }
      });
      return;
    }
    int k = paramAttributeSet.getIndex(i);
    switch (k)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      this.radius = paramAttributeSet.getDimensionPixelSize(k, (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
      continue;
      this.textSize = paramAttributeSet.getInteger(k, 12);
      continue;
      this.switchOnColor = paramAttributeSet.getColor(k, -16711936);
      continue;
      this.switchOffColor = paramAttributeSet.getColor(k, -7829368);
      continue;
      this.circleColor = paramAttributeSet.getColor(k, -1);
      continue;
      this.textColor = paramAttributeSet.getColor(k, -16777216);
      continue;
      isSwitchOn = paramAttributeSet.getBoolean(k, false);
    }
  }
  
  protected void changeSwitchStatus()
  {
    if (isSwitchOn) {}
    for (boolean bool = false;; bool = true)
    {
      isSwitchOn = bool;
      if (this.listener != null)
      {
        System.out.println(isSwitchOn);
        this.listener.mySwitchStateChanged(isSwitchOn);
      }
      postInvalidate();
      return;
    }
  }
  
  public boolean isSwitchOn()
  {
    return isSwitchOn;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 3.0F * this.radius;
    float f2 = 2.0F * this.radius;
    this.paint.setAntiAlias(true);
    if (isSwitchOn)
    {
      this.paint.setColor(this.switchOnColor);
      this.paint.setStyle(Style.FILL);
      paramCanvas.drawCircle(this.radius, this.radius, this.radius, this.paint);
      this.rect.set(this.radius, 0.0F, this.radius + f1, f2);
      paramCanvas.drawRect(this.rect, this.paint);
      this.paint.setColor(this.circleColor);
      paramCanvas.drawCircle(this.radius + f1, this.radius, this.radius, this.paint);
      this.paint.setColor(this.textColor);
      this.paint.setTextSize(50.0F);
      localFontMetrics = this.paint.getFontMetrics();
      f2 = localFontMetrics.bottom;
      f3 = localFontMetrics.top;
      f1 = this.radius;
      f2 = (f2 - f3) / 2.0F;
      f3 = localFontMetrics.bottom;
      paramCanvas.drawText("打开", this.radius, f1 + f2 - f3, this.paint);
      return;
    }
    this.paint.setColor(this.switchOffColor);
    this.paint.setStyle(Style.FILL);
    this.rect.set(this.radius, 0.0F, this.radius + f1, f2);
    paramCanvas.drawRect(this.rect, this.paint);
    paramCanvas.drawCircle(this.radius + f1, this.radius, this.radius, this.paint);
    this.paint.setColor(this.circleColor);
    paramCanvas.drawCircle(this.radius, this.radius, this.radius, this.paint);
    this.paint.setColor(this.textColor);
    this.paint.setTextSize(50.0F);
    f2 = this.paint.measureText("关闭");
    FontMetrics localFontMetrics = this.paint.getFontMetrics();
    float f4 = localFontMetrics.bottom;
    float f5 = localFontMetrics.top;
    float f3 = this.radius;
    f4 = (f4 - f5) / 2.0F;
    f5 = localFontMetrics.bottom;
    paramCanvas.drawText("关闭", this.radius + f1 - f2, f3 + f4 - f5, this.paint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    int k = MeasureSpec.getMode(paramInt1);
    paramInt1 = MeasureSpec.getSize(paramInt1);
    switch (k)
    {
    default: 
      paramInt1 = j;
      j = MeasureSpec.getMode(paramInt2);
      paramInt2 = MeasureSpec.getSize(paramInt2);
      switch (j)
      {
      default: 
        paramInt2 = i;
      }
      break;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      break;
      paramInt1 = getPaddingLeft() + getPaddingRight();
      break;
      continue;
      paramInt2 = paramInt1 / 20;
    }
  }
  
  public void setListener(MySwitchStateChangeListener paramMySwitchStateChangeListener)
  {
    this.listener = paramMySwitchStateChangeListener;
  }
  
  public void setSwitchOn(boolean paramBoolean)
  {
    isSwitchOn = paramBoolean;
  }
  
  public static abstract interface MySwitchStateChangeListener
  {
    public abstract void mySwitchStateChanged(boolean paramBoolean);
  }
}


*/
