package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

/**
 * 属性动画-旋转
 */
public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    private int rotationCount = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    private int rotationState = 0;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (rotationState) {
                    case 0:
                        //绕imageview中心点旋转
                        imageView.animate().rotation(180);
                        break;
                    case 1:
                        imageView.animate().rotation(0);
                        break;
                    case 2:
                        //imageview中心点绕x轴旋转
                        imageView.animate().rotationX(180);
                        break;
                    case 3:
                        imageView.animate().rotationX(0);
                        break;
                    case 4:
                        //imageview中心点绕y轴旋转
                        imageView.animate().rotationY(180);
                        break;
                    case 5:
                        imageView.animate().rotationY(0);
                        break;
                }

                rotationState++;
                if (rotationState == rotationCount) {
                    rotationState = 0;
                }
            }
        });
    }
}