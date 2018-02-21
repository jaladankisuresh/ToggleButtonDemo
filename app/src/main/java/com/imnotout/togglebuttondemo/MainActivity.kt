package com.imnotout.togglebuttondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.CompoundButton
import android.R.id.toggle
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggleButton.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked) {
                val colorWhite = ContextCompat.getColor(view.context, R.color.white)
                view.setTextColor(colorWhite)
                view.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_tick_white, 0, 0, 0)
            }
            else {
                val colorPrimary = ContextCompat.getColor(view.context, R.color.colorPrimary)
                view.setTextColor(colorPrimary)
                view.setCompoundDrawablesWithIntrinsicBounds( 0, 0, 0, 0)
            }
        }
        btn_accordian_demo.setOnClickListener{
            startActivity<AccordionDemoActivity>()
        }
    }
}
