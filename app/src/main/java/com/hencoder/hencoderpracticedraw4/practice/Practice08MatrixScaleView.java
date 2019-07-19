package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice08MatrixScaleView extends View {
    Paint  paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point  point1 = new Point(200, 200);
    Point  point2 = new Point(600, 200);
    private Matrix mMatrix;
    private Matrix mMatrix1;

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        mMatrix = new Matrix();
        mMatrix.reset();
        mMatrix.postScale(1.3f, 1.3f);

        mMatrix1 = new Matrix();
        mMatrix1.reset();
        mMatrix1.postScale(0.7f, 1.3f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);

        canvas.concat(mMatrix1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);

        canvas.restore();
    }
}
