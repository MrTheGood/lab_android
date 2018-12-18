/*
 *    Copyright 2018 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.experiment.physicsbasedanimations

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
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
