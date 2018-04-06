package eu.insertcode.experiment.physicsbasedanimations

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.animation.FloatPropertyCompat
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
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
