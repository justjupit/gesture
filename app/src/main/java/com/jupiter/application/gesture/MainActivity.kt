package com.jupiter.application.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {

    lateinit var gDetector: GestureDetector
    var flag:Boolean = true
    var pictureNo:Int = 0
    var totalPictures:Int = 7


    fun showPicture(){
        /*
        when (PictureNo){
            0 -> img.setImageResource(R.drawable.pu0)
            1 -> img.setImageResource(R.drawable.pu1)
            2 -> img.setImageResource(R.drawable.pu2)
            3 -> img.setImageResource(R.drawable.pu3)
        }
        */

        var res:Int = getResources().getIdentifier("pu" + (pictureNo),
            "drawable", getPackageName())
        img.setImageResource(res)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this,this)
        img.setOnTouchListener(this)
        var res:Int = -1
        var countDrawables:Int = -1
        while (res != 0) {
            countDrawables++;
            res = getResources().getIdentifier("pu" + (countDrawables),
                "drawable", getPackageName());
        }
        totalPictures = countDrawables
        txv.text=pictureNo.toString()
    }
/*
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }
*/
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        flag=true
        return true
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        pictureNo = 0
        showPicture()
        txv.text=pictureNo.toString()
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {

    }


    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        if(flag){
            if (e1.getY() < e2.getY()){
            pictureNo++
             if (pictureNo == totalPictures) {
                  pictureNo = 0
            }
        } else {
            pictureNo--;
             if (pictureNo < 0) {
                 pictureNo = totalPictures - 1
            }
        }
         showPicture()
         txv.text = pictureNo.toString()
        }
            flag = false
            return true
        }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        pictureNo = totalPictures - 1
        showPicture()
        txv.text=pictureNo.toString()
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {

        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

}