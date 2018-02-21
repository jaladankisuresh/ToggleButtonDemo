package com.imnotout.togglebuttondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_accordion_demo.*
import org.jetbrains.anko.startActivity

class AccordionDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accordion_demo)

        val collection = listOf<String>("One", "Two", "Three", "Four", "Five")
        list_accordion_item.run{
            adapter = AccordionItemAdapter(collection)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
        btn_expandable_text_demo.setOnClickListener {
            startActivity<ExpandableTextViewActivity>()
        }
    }
}
