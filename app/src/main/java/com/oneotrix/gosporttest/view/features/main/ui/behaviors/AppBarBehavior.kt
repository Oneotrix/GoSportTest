package com.oneotrix.gosporttest.view.features.main.ui.behaviors

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout

class AppBarBehavior(context: Context?, attrs: AttributeSet?) :
    AppBarLayout.Behavior(context, attrs) {

    private var height: Int? = null

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)

        val rc = target as RecyclerView
        val secondView = child.getChildAt(1)
        val answer = rc.canScrollVertically(-1)

        if (height == null) height = secondView.height

        when(dy >= 0) {
            true -> {
                if (!answer) {
                    slideView(secondView, secondView.height,0)
                }
            }
            false -> {
                if (!answer) {
                    slideView(secondView, secondView.height, height!!)
                }
            }
        }
    }

    private fun slideView(view: View, currentHeight: Int, newHeight: Int) {
        val sliderAnimator = ValueAnimator
            .ofInt(currentHeight, newHeight)
            .setDuration(300)

        sliderAnimator.addUpdateListener { animation1 ->
            run {
                val value = animation1.getAnimatedValue() as Int
                view.layoutParams.height = value
                view.requestLayout()
            }

        }

        val animationSet = AnimatorSet()
        animationSet.interpolator = LinearInterpolator()

        animationSet.play(sliderAnimator)
        animationSet.start()

    }

}