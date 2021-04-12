package com.jupiter.application.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {

    lateinit var gDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this,this)
        img.setOnTouchListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        txv.text = "按下"
        return true
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        txv.text = "短按"
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        txv.text = "長按"
    }


    override fun onShowPress(p0: MotionEvent?) {
        txv.text = "按下後無後續動作"
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        txv.text = "拖曳\nx1y1: " +  e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString()
        return true
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        txv.text = "快滑\nx1y1: " + e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString() +
                "\nX軸Y軸速度:" + velocityX.toString() + ", " +  velocityY.toString()
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        txv.text = "連續點兩下"
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

}