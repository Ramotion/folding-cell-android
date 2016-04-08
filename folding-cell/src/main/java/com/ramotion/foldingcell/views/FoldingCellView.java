package com.ramotion.foldingcell.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/**
 * Basic element for folding animation.
 */
public class FoldingCellView extends RelativeLayout {

    private View mBackView;
    private View mFrontView;

    public FoldingCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutParams layoutParams =
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);
        this.setClipToPadding(false);
        this.setClipChildren(false);
    }

    public FoldingCellView(View frontView, View backView, Context context) {
        super(context);
        this.mFrontView = frontView;
        this.mBackView = backView;

        LayoutParams layoutParams =
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        this.setClipToPadding(false);
        this.setClipChildren(false);

        if (mBackView != null) {
            this.addView(mBackView);
            LayoutParams mBackViewParams = (LayoutParams) mBackView.getLayoutParams();
            mBackViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mBackView.setLayoutParams(mBackViewParams);
            layoutParams.height = mBackViewParams.height;
        }

        if (mFrontView != null) {
            this.addView(mFrontView);
            LayoutParams frontViewLayoutParams = (LayoutParams) mFrontView.getLayoutParams();
            frontViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mFrontView.setLayoutParams(frontViewLayoutParams);
        }

        this.setLayoutParams(layoutParams);
    }

    public FoldingCellView withFrontView(View frontView) {
        this.mFrontView = frontView;

        if (mFrontView != null) {
            this.addView(mFrontView);
            LayoutParams frontViewLayoutParams = (LayoutParams) mFrontView.getLayoutParams();
            frontViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mFrontView.setLayoutParams(frontViewLayoutParams);
        }
        return this;
    }

    public FoldingCellView withBackView(View backView) {
        this.mBackView = backView;

        if (mBackView != null) {
            this.addView(mBackView);
            LayoutParams mBackViewParams = (LayoutParams) mBackView.getLayoutParams();
            mBackViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mBackView.setLayoutParams(mBackViewParams);

            LayoutParams layoutParams = (LayoutParams) this.getLayoutParams();
            layoutParams.height = mBackViewParams.height;
            this.setLayoutParams(layoutParams);
        }

        return this;
    }

    public View getBackView() {
        return mBackView;
    }

    public View getFrontView() {
        return mFrontView;
    }

    public void animateFrontView(Animation animation) {
        if (this.mFrontView != null)
            mFrontView.startAnimation(animation);
    }

}
