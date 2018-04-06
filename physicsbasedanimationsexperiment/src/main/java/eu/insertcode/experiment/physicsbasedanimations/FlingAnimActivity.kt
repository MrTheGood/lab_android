package eu.insertcode.experiment.physicsbasedanimations

import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ViewTreeObserver
import kotlinx.android.synthetic.main.activity_fling_anim.*

class FlingAnimActivity : AppCompatActivity() {
    companion object {
        private const val MIN_DISTANCE_MOVED = 50
        private const val FRICTION = 1.1f
    }

    private var maxTranslationX = 0
    private var maxTranslationY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_anim)

        val gestureDetector = GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent?) = true
            override fun onFling(downEvent: MotionEvent, moveEvent: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                val distanceX = Math.abs(downEvent.rawX - moveEvent.rawX)
                val distanceY = Math.abs(downEvent.rawY - moveEvent.rawY)

                if (distanceX > MIN_DISTANCE_MOVED) {
                    FlingAnimation(animatedFlingView, DynamicAnimation.TRANSLATION_X).apply {
                        setStartVelocity(velocityX)
                        setMaxValue(maxTranslationX.toFloat())
                        setMinValue(-maxTranslationX.toFloat())
                        friction = FRICTION
                        start()
                    }
                }
                if (distanceY > MIN_DISTANCE_MOVED) {
                    FlingAnimation(animatedFlingView, DynamicAnimation.TRANSLATION_Y).apply {
                        setStartVelocity(velocityY)
                        setMinValue(-maxTranslationY.toFloat())
                        setMaxValue(maxTranslationY.toFloat())
                        friction = FRICTION
                        start()
                    }
                }
                return true
            }
        })

        flingViewLayout.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                maxTranslationX = (flingViewLayout.width - animatedFlingView.width) / 2
                maxTranslationY = (flingViewLayout.height - animatedFlingView.height) / 2
                flingViewLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

        animatedFlingView.setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
    }
}
