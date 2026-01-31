package com.silvestri.soundpad.fragments

import android.app.Activity
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.silvestri.soundpad.R
import com.silvestri.soundpad.ViewModel.MainViewModel
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding
import java.io.File
import java.io.IOException

class MainFragment: Fragment(R.layout.main_fragment_layout) {

    private lateinit var binding: MainFragmentLayoutBinding
    private val viewModel: MainViewModel by viewModels()
    private var whiteColor:Int? = null
    private var emeraldGreen: Int? = null
    private var orangeColor: Int? = null
    private var recordText:Int? = null
    private var playText:Int? = null
    private var stopText: Int? = null
    private lateinit var currentAudioButton: AppCompatButton

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
        setupViews()
        setupSoundPaths(requireActivity())
        setColorsForUse()
        setTextValuesForUse()
    }

    private fun setColorsForUse(){
        whiteColor = R.color.white
        emeraldGreen = R.color.emeraldGreen
        orangeColor = R.color.orange
        viewModel.emeraldGreenColor.set(getColorResIdValue(emeraldGreen ?: 0))
        viewModel.orangeColor.set(getColorResIdValue(orangeColor ?: 0))
        viewModel.whiteColor.set(getColorResIdValue(whiteColor ?: 0))
    }

    private fun setTextValuesForUse(){
        recordText = R.string.record
        playText = R.string.play
        stopText = R.string.stop
        viewModel.playText.set(getStringResIdValue(playText ?: 0))
        viewModel.recordText.set(getStringResIdValue(recordText ?: 0))
        viewModel.stopText.set(getStringResIdValue(stopText ?: 0))
    }

    private fun getStringResIdValue(id: Int): String {
       return context?.getString(id) ?: ""
    }

    private fun getColorResIdValue(id: Int): Int {
        return context?.getColor(id) ?: 0
    }

    private fun setupSoundPaths(activity: Activity) {
        viewModel.soundOne = "${activity.externalCacheDir?.absolutePath}/soundOne.3gp"
        viewModel.soundTwo = "${activity.externalCacheDir?.absolutePath}/soundTwo.3gp"
        viewModel.soundThree = "${activity.externalCacheDir?.absolutePath}/soundThree.3gp"
        viewModel.soundFour = "${activity.externalCacheDir?.absolutePath}/soundFour.3gp"
        viewModel.soundFive = "${activity.externalCacheDir?.absolutePath}/soundFive.3gp"
        viewModel.soundSix = "${activity.externalCacheDir?.absolutePath}/soundSix.3gp"
        viewModel.soundSeven = "${activity.externalCacheDir?.absolutePath}/soundSeven.3gp"
        viewModel.soundEight = "${activity.externalCacheDir?.absolutePath}/soundEight.3gp"
        viewModel.soundNine = "${activity.externalCacheDir?.absolutePath}/soundNine.3gp"
        viewModel.soundTen = "${activity.externalCacheDir?.absolutePath}/soundTen.3gp"
        viewModel.soundEleven = "${activity.externalCacheDir?.absolutePath}/soundEleven.3gp"
        viewModel.soundTwelve = "${activity.externalCacheDir?.absolutePath}/soundTwelve.3gp"
        viewModel.soundThirteen = "${activity.externalCacheDir?.absolutePath}/soundThirteen.3gp"
        viewModel.soundFourteen = "${activity.externalCacheDir?.absolutePath}/soundFourteen.3gp"
        viewModel.soundFifteen = "${activity.externalCacheDir?.absolutePath}/soundFifteen.3gp"
        viewModel.soundSixteen = "${activity.externalCacheDir?.absolutePath}/soundSixteen.3gp"
        viewModel.soundSeventeen = "${activity.externalCacheDir?.absolutePath}/soundSeventeen.3gp"
        viewModel.soundEighteen = "${activity.externalCacheDir?.absolutePath}/soundEighteen.3gp"
        viewModel.soundNineteen = "${activity.externalCacheDir?.absolutePath}/soundNineteen.3gp"
        viewModel.soundTwenty = "${activity.externalCacheDir?.absolutePath}/soundTwenty.3gp"
        setupSoundButtonStyles(soundFiles = viewModel.soundFiles)
    }
    private fun setupSoundButtonStyles(soundFiles: Array<String>){
        var count = 0
        for(values in soundFiles){
            println("SOUND FILES = > $values")
            if(count > 20){
                return
            }
            val file = File(values)
            if(!file.exists()){
                println("SOUND DOES NOT EXIST = > ${soundFiles[count]}")
                setupRecordButtonSoundStyle(count)
            } else {
                setupPlayButtonSoundStyle(count)
            }
            count+=1
        }
    }

    private fun setupPlayButtonSoundStyle(index: Int){
        when (index) {
            0 -> {
                viewModel.soundOneText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundOneColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            1 -> {
                viewModel.soundTwoText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundThreeColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            2 -> {
                viewModel.soundThreeText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundThreeColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            3 -> {
                viewModel.soundFourText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundFourColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            4 -> {
                viewModel.soundFiveText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundFiveColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            5 -> {
                viewModel.soundSixText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundSixColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            6 -> {
                viewModel.soundSevenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundSevenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            7 -> {
                viewModel.soundEightText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundEightColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            8 -> {
                viewModel.soundNineText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundNineColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            9 -> {
                viewModel.soundTenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundTenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            10 -> {
                viewModel.soundElevenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundElevenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            11 -> {
                viewModel.soundTwelveText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundTwelveColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            12 -> {
                viewModel.soundThirteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundThirteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            13 -> {
                viewModel.soundFourteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundFourteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            14 -> {
                viewModel.soundFifteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundFifteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            15 -> {
                viewModel.soundSixteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundSixteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            16 -> {
                viewModel.soundSeventeenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundSeventeenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            17 -> {
                viewModel.soundEighteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundEighteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            18 -> {
                viewModel.soundNineteenText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundNineteenColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
            19 -> {
                viewModel.soundTwentyText.set(getStringResIdValue(playText ?: 0))
                viewModel.soundTwentyColor.set(getColorResIdValue(emeraldGreen ?: 0))
            }
        }

    }

    private fun setupRecordButtonSoundStyle(index: Int){
        if(index == 0){
            viewModel.soundOneText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundOneColor.set(getColorResIdValue(whiteColor ?: 0))
        }else if(index == 1){
            viewModel.soundTwoText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundTwoColor.set(getColorResIdValue(whiteColor ?: 0))
        }else if(index == 2){
            viewModel.soundThreeText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundThreeColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 3){
            viewModel.soundFourText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundFourColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 4){
            viewModel.soundFiveText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundFiveColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 5){
            viewModel.soundSixText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundSixColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 6){
            viewModel.soundSevenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundSevenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 7){
            viewModel.soundEightText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundEightColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 8){
            viewModel.soundNineText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundNineColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 9){
            viewModel.soundTenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundTenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 10){
            viewModel.soundElevenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundElevenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 11){
            viewModel.soundTwelveText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundTwelveColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 12){
            viewModel.soundThirteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundThirteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 13){
            viewModel.soundFourteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundFourteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 14){
            viewModel.soundFifteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundFifteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 15){
            viewModel.soundSixteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundSixteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 16){
            viewModel.soundSeventeenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundSeventeenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 17){
            viewModel.soundEighteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundEighteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 18){
            viewModel.soundNineteenText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundNineteenColor.set(getColorResIdValue(whiteColor ?: 0))
        }
        else if(index == 19){
            viewModel.soundTwentyText.set(getStringResIdValue(recordText ?: 0))
            viewModel.soundTwentyColor.set(getColorResIdValue(whiteColor ?: 0))
        }
    }

    private fun setupViews(){
        binding.recordingInProgressScreen.visibility = View.GONE
    }

}