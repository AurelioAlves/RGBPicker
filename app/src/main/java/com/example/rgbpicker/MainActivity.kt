package com.example.rgbpicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mColorView: View
    private lateinit var mColorPickerRed: SeekBar
    private lateinit var mColorPickerGreen: SeekBar
    private lateinit var mColorPickerBlue: SeekBar


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_color_colorview)
        mColorPickerRed = findViewById(R.id.main_seekbar_colorpicker_red)
        mColorPickerGreen = findViewById(R.id.main_seekbar_colorpicker_green)
        mColorPickerBlue = findViewById(R.id.main_seekbar_colorpicker_blue)

        mColorPickerRed.setOnSeekBarChangeListener( this )
        mColorPickerGreen.setOnSeekBarChangeListener( this )
        mColorPickerBlue.setOnSeekBarChangeListener( this )
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if( fromUser ) {
            Log.i("App", "Value: $progress")
            when( seekBar?.id) {
                R.id.main_seekbar_colorpicker_red -> {
                    mColorView.setBackgroundColor(Color.rgb(progress, mColorPickerGreen.progress, mColorPickerBlue.progress))
                }

                R.id.main_seekbar_colorpicker_green -> {
                    mColorView.setBackgroundColor(Color.rgb(mColorPickerRed.progress, progress, mColorPickerBlue.progress))
                }

                R.id.main_seekbar_colorpicker_blue -> {
                    mColorView.setBackgroundColor(Color.rgb(mColorPickerRed.progress, mColorPickerGreen.progress, progress))
                }
            }

        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "Start Touch")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "Stop Touch")
    }
}