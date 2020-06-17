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
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import kotlinx.android.synthetic.main.activity_dynamic_animation.*

class ChangingAnimActivity : AppCompatActivity() {
    private lateinit var animationX: SpringAnimation
    private lateinit var animationY: SpringAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_animation)

        animationX = SpringAnimation(animatedDynamicView, object : FloatPropertyCompat<View>("translationX") {
            override fun getValue(v: View) = v.translationX
            override fun setValue(v: View, value: Float) {
                v.translationX = value
            }
        })
        animationY = SpringAnimation(animatedDynamicView, object : FloatPropertyCompat<View>("translationY") {
            override fun getValue(v: View) = v.translationY
            override fun setValue(v: View, value: Float) {
                v.translationY = value
            }
        })

        animationX.spring = SpringForce(animatedDynamicView.x).apply {
            this.dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            this.stiffness = SpringForce.STIFFNESS_LOW
        }

        animationY.spring = SpringForce(animatedDynamicView.y).apply {
            this.dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            this.stiffness = SpringForce.STIFFNESS_LOW
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP) {
            animationX.animateToFinalPosition(event.x - animatedDynamicView.x)
            animationY.animateToFinalPosition(event.y - animatedDynamicView.y)
            return true
        }
        return super.onTouchEvent(event)

    }
}
