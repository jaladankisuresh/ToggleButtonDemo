package com.imnotout.togglebuttondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_expandable_text_view.*
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.R.attr.start
import android.support.v4.widget.TextViewCompat.getMaxLines
import android.animation.ObjectAnimator
import android.transition.TransitionManager
import android.view.ViewGroup
import org.jetbrains.anko.contentView


class ExpandableTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_text_view)

        txt_expandable_textview.run {
            text = """Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    |Ut volutpat interdum interdum. Nulla laoreet lacus diam, vitae
                    |sodales sapien commodo faucibus. Vestibulum et feugiat enim. Donec
                    |semper mi et euismod tempor. Sed sodales eleifend mi id varius. Nam
                    |et ornare enim, sit amet gravida sapien. Quisque gravida et enim vel
                    |volutpat. Vivamus egestas ut felis a blandit. Vivamus fringilla
                    |ignissim mollis. Maecenas imperdiet interdum hendrerit. Aliquam
                    |dictum hendrerit ultrices. Ut vitae vestibulum dolor. Donec auctor ante
                    |eget libero molestie porta. Nam tempor fringilla ultricies. Nam sem
                    |lectus, feugiat eget ullamcorper vitae, ornare et sem. Fusce dapibus ipsum
                    |sed laoreet suscipit. """.trimMargin()

            setCompoundDrawablesWithIntrinsicBounds( 0, 0, 0, R.drawable.ic_expand_more_black_18dp)
            getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if(lineCount > maxLines){
                        setOnClickListener {
                            if(maxLines == lineCount){
//                              In Expanded View, On Click trigger view collapse
                                maxLines = 2
                                setCompoundDrawablesWithIntrinsicBounds( 0, 0, 0, R.drawable.ic_expand_more_black_18dp)
                            }
                            else {
//                              In Collapsed View, On Click trigger view expand
                                maxLines = lineCount
                                setCompoundDrawablesWithIntrinsicBounds( 0, 0, 0, R.drawable.ic_expand_less_black_18dp)
                            }
                            TransitionManager.beginDelayedTransition(parent as ViewGroup)
                        }
                    }

                    getViewTreeObserver().removeOnGlobalLayoutListener(this)
                }
            })
        }
    }
}
