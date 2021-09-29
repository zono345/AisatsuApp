package jp.techacademy.yusuke.shimozono.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//以下は追記
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import android.app.TimePickerDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (hour in 2..9) {
                    textView1.text = "おはよう"
                } else if (hour in 10..17) {
                    textView1.text = "こんにちは"
                } else {
                    textView1.text = "こんばんは"
                }
                Log.d("UI_PARTS", "$hour:$minute")
            },
            10, 0, true
        )
        timePickerDialog.show()
    }
}