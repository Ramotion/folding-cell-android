package com.ramotion.foldingcell.animations;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

/**
 * Main piece of fold animation
 */
public class FoldAnimation extends Animation {

    public enum FoldAnimationMode {
        FOLD_UP, UNFOLD_DOWN, FOLD_DOWN, UNFOLD_UP
    }

    private final FoldAnimationMode mFoldMode;
    private final int mCameraHeight;
    private float mFromDegrees;
    private float mToDegrees;
    private float mCenterX;
    private float mCenterY;
    private Camera mCamera;


    public FoldAnimation(FoldAnimationMode foldMode, int cameraHeight, long duration) {
        this.mFoldMode = foldMode;
        this.setFillAfter(true);
        this.setDuration(duration);
        this.mCameraHeight = cameraHeight;
    }

    public FoldAnimation withAnimationListener(AnimationListener animationListener) {
        this.setAnimationListener(animationListener);
        return this;
    }

    public FoldAnimation withStartOffset(int offset) {
        this.setStartOffset(offset);
        return this;
    }

    public FoldAnimation withInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.setInterpolator(interpolator);
        }
        return this;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mCamera = new Camera();
        mCamera.setLocation(0, 0, -mCameraHeight);

        this.mCenterX = width / 2;
        switch (mFoldMode) {
            case FOLD_UP:
                this.mCenterY = 0;
                this.mFromDegrees = 0;
                this.mToDegrees = 90;
                break;
            case FOLD_DOWN:
                this.mCenterY = height;
                this.mFromDegrees = 0;
                this.mToDegrees = -90;
                break;
            case UNFOLD_UP:
                this.mCenterY = height;
                this.mFromDegrees = -90;
                this.mToDegrees = 0;
                break;
            case UNFOLD_DOWN:
                this.mCenterY = 0;
                this.mFromDegrees = 90;
                this.mToDegrees = 0;
                break;
            default:
                throw new IllegalStateException("Unknown animation mode.");
        }
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Camera camera = mCamera;
        final Matrix matrix = t.getMatrix();
        final float fromDegrees = mFromDegrees;
        final float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);

        camera.save();
        camera.rotateX(degrees);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
    }

    @Override
    public String toString() {
        return "FoldAnimation{" +
                "mFoldMode=" + mFoldMode +
                ", mFromDegrees=" + mFromDegrees +
                ", mToDegrees=" + mToDegrees +
                '}';
    }

}
