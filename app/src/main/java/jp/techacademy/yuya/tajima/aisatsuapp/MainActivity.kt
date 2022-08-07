package jp.techacademy.yuya.tajima.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            showTimePickerDialog()
            Log.d("DEBUG_PRINT", "clicked")
        }
    }

    private fun showTimePickerDialog() {

        val calender = Calendar.getInstance()
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("DEBUG_PRINT", "$hour:$minute")
                    val msg = when(hour) {
                        in 2..9 -> "おはよう"
                        in 10..17 -> "こんにちは"
                        else -> "こんばんは"
                    }
                    this.message.text = msg
                },
                hour,
                minute,
                true
        )
        timePickerDialog.show()
    }
}