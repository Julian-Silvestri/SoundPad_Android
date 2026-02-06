package com.silvestri.soundpad.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.silvestri.soundpad.R
import com.silvestri.soundpad.models.MainViewModel
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding

class MainFragment: Fragment(R.layout.main_fragment_layout) {

    private lateinit var binding: MainFragmentLayoutBinding
    private val viewModel: MainViewModel by viewModels()
    private var whiteColor:Int? = null
    private var emeraldGreen: Int? = null
    private var orangeColor: Int? = null
    private var recordText:Int? = null
    private var stopRecordingText:Int? = null
    private var recordingText:Int? = null
    private var playText:Int? = null
    private var stopText: Int? = null

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setupColorsAndText()
    }

    private fun setupColorsAndText(){
        whiteColor = R.color.white
        emeraldGreen = R.color.emeraldGreen
        orangeColor = R.color.orange
        viewModel.emeraldGreenId.set(emeraldGreen)
        viewModel.orangeColorId.set(orangeColor)
        viewModel.whiteColorId.set(whiteColor)
        setTextValuesForUse()
    }

    private fun setTextValuesForUse(){
        recordText = R.string.record
        recordingText = R.string.recording
        stopRecordingText = R.string.stop_recording
        playText = R.string.play
        stopText = R.string.stop
        viewModel.playTextId.set(playText)
        viewModel.recordTextId.set(recordText)
        viewModel.stopTextId.set(stopText)
        viewModel.stopRecordingButtonTextId.set(stopRecordingText)
        viewModel.recordingTextId.set(recordingText)
        viewModel.setupStringTexts()
        viewModel.setupColors()
        viewModel.setupSoundPaths()
        setupViews()
    }




    private fun setupViews(){
        viewModel.recordingInProgressVisibility.set(false)
        viewModel.mainLayoutVisibility.set(true)
    }

}