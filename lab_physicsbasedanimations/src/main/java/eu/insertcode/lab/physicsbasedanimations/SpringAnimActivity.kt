/*
 *    Copyright 2020 Maarten de Goede
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

package eu.insertcode.lab.physicsbasedanimations

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import kotlinx.android.synthetic.main.activity_spring_anim.*

class SpringAnimActivity : AppCompatActivity(), View.OnTouchListener {
    private lateinit var springAnimX: SpringAnimation
    private lateinit var springAnimY: SpringAnimation

    private var diffX = 0f
    private var diffY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring_anim)

        animatedSpringView.setOnTouchListener(this)

        springAnimX = SpringAnimation(animatedSpringView, object : FloatPropertyCompat<View>("translationX") {
            override fun getValue(view: View?) = view?.translationX ?: 0f
            override fun setValue(view: View?, value: Float) {
                view?.translationX = value
            }
        })

        springAnimY = SpringAnimation(animatedSpringView, object : FloatPropertyCompat<View>("translationY") {
            override fun getValue(view: View) = view.translationY
            override fun setValue(view: View, value: Float) {
                view.translationY = value
            }
        })

        val centerX = animatedSpringView.x
        val centerY = animatedSpringView.y
        val springForceX = SpringForce(centerX).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }

        val springForceY = SpringForce(centerY).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }

        springAnimX.spring = springForceX
        springAnimY.spring = springForceY
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                diffX = event.rawX - v.x
                diffY = event.rawY - v.y
                springAnimX.cancel()
                springAnimY.cancel()
            }
            MotionEvent.ACTION_MOVE -> {
                animatedSpringView.x = event.rawX - diffX
                animatedSpringView.y = event.rawY - diffY
            }
            MotionEvent.ACTION_UP -> {
                springAnimX.start()
                springAnimY.start()
            }
        }
        return true
    }
}
