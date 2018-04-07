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
import android.support.animation.*
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import kotlinx.android.synthetic.main.activity_combined_fling_spring_anim.*

class CombinedFlingSpringAnimActivity : AppCompatActivity() {
    companion object {
        private const val MIN_DISTANCE_MOVED = 50
        private const val FRICTION = 1.1f
    }

    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var flingAnimation: FlingAnimation
    private lateinit var springAnimation: SpringAnimation

    private var minLayoutTranslationY = 0f
    private var maxLayoutTranslationY = 0f
    private var childViewDiff = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combined_fling_spring_anim)

        flingViewLayout.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                minLayoutTranslationY = animatedFlingView.translationY
                maxLayoutTranslationY = animatedFlingView.translationY + animatedFlingView.height
                childViewDiff = animatedFlingView.translationY - animatedSpringView.translationY

                springAnimation = SpringAnimation(animatedSpringView, object : FloatPropertyCompat<View>("translationY") {
                    override fun getValue(view: View) = view.translationY
                    override fun setValue(view: View, value: Float) {
                        view.translationY = value
                    }
                })
                springAnimation.spring = SpringForce(animatedSpringView.translationX).apply {
                    stiffness = SpringForce.STIFFNESS_MEDIUM
                    dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
                }
                flingAnimation = FlingAnimation(animatedFlingView, DynamicAnimation.TRANSLATION_Y).apply {
                    setMaxValue(maxLayoutTranslationY)
                    setMinValue(minLayoutTranslationY)
                    friction = FRICTION
                    addUpdateListener { _, value, _ -> springAnimation.animateToFinalPosition(value + childViewDiff) }
                }

                animatedFlingView.translationY = maxLayoutTranslationY
                flingViewLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

        gestureDetector = GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent?) = true
            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                flingAnimation.apply {
                    if (isRunning) cancel()
                    setStartVelocity(velocityY)
                    start()
                }
                return true
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent?) = gestureDetector.onTouchEvent(event)
}
