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
import com.silvestri.soundpad.R
import com.silvestri.soundpad.ViewModel.MainViewModel
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding
import java.io.File
import java.io.IOException

class MainFragment: Fragment(R.layout.main_fragment_layout) {

    private lateinit var binding: MainFragmentLayoutBinding
    private var viewModel = MainViewModel()
    private var whiteColor:Int? = null
    private var emeraldGreen: Int? = null
    private var recordText:Int? = null
    private var playText:Int? = null
    private var stopText: Int? = null
    private lateinit var currentAudioButton: AppCompatButton

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
        setupButtons()
        setupViews()
        setupSoundPaths(requireActivity())
        setColorsForUse()
        setTextValuesForUse()
    }

    private fun setColorsForUse(){
        whiteColor = R.color.white
        emeraldGreen = R.color.emeraldGreen
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


    @RequiresApi(Build.VERSION_CODES.S)
    private fun setupButtons(){
        binding.soundOne.setOnClickListener {

        }
        binding.soundTwo.setOnClickListener {
            if(binding.soundTwo.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[1], button = binding.soundTwo)
            } else {
                //play an audio file
                if(binding.soundTwo.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioTwo(binding.soundTwo)
                } else {
                    playAudioTwo(pathName = soundFiles[1])
                    changeStyleToAudioPlaying(binding.soundTwo)
                }
            }
        }
        binding.soundThree.setOnClickListener {
            if(binding.soundThree.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[2], button = binding.soundThree)
            } else {
                //play an audio file
                if(binding.soundThree.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioThree(binding.soundThree)
                } else {
                    playAudioThree(pathName = soundFiles[2])
                    changeStyleToAudioPlaying(binding.soundThree)
                }
            }
        }
        binding.soundFour.setOnClickListener {
            if(binding.soundFour.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[3], button = binding.soundFour)
            } else {
                //play an audio file
                if(binding.soundFour.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioFour(binding.soundFour)
                } else {
                    playAudioFour(pathName = soundFiles[3])
                    changeStyleToAudioPlaying(binding.soundFour)
                }
            }
        }
        binding.soundFive.setOnClickListener {
            if(binding.soundFive.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[4], button = binding.soundFive)
            } else {
                //play an audio file
                if(binding.soundFive.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioFive(binding.soundFive)
                } else {
                    playAudioFive(pathName = soundFiles[4])
                    changeStyleToAudioPlaying(binding.soundFive)
                }
            }
        }
        binding.soundSix.setOnClickListener {
            if(binding.soundSix.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[5], button = binding.soundSix)
            } else {
                //play an audio file
                if(binding.soundSix.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioSix(binding.soundSix)
                } else {
                    playAudioSix(pathName = soundFiles[5])
                    changeStyleToAudioPlaying(binding.soundSix)
                }
            }
        }
        binding.soundSeven.setOnClickListener {
            if(binding.soundSeven.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[6], button = binding.soundSeven)
            } else {
                //play an audio file
                if(binding.soundSeven.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioSeven(binding.soundSeven)
                } else {
                    playAudioSeven(pathName = soundFiles[6])
                    changeStyleToAudioPlaying(binding.soundSeven)
                }
            }
        }
        binding.soundEight.setOnClickListener {
            if(binding.soundEight.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[7], button = binding.soundEight)
            } else {
                //play an audio file
                if(binding.soundEight.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioEight(binding.soundEight)
                } else {
                    playAudioEight(pathName = soundFiles[7])
                    changeStyleToAudioPlaying(binding.soundEight)
                }
            }
        }
        binding.soundNine.setOnClickListener {
            if(binding.soundNine.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[8], button = binding.soundNine)
            } else {
                //play an audio file
                if(binding.soundNine.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioNine(binding.soundNine)
                } else {
                    playAudioNine(pathName = soundFiles[8])
                    changeStyleToAudioPlaying(binding.soundNine)
                }
            }
        }
        binding.soundTen.setOnClickListener {
            if(binding.soundTen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[9], button = binding.soundTen)
            } else {
                //play an audio file
                if(binding.soundTen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioTen(binding.soundTen)
                } else {
                    playAudioTen(pathName = soundFiles[9])
                    changeStyleToAudioPlaying(binding.soundTen)
                }
            }
        }
        binding.soundEleven.setOnClickListener {
            if(binding.soundEleven.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[10], button = binding.soundEleven)
            } else {
                //play an audio file
                if(binding.soundEleven.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioEleven(binding.soundEleven)
                } else {
                    playAudioEleven(pathName = soundFiles[10])
                    changeStyleToAudioPlaying(binding.soundEleven)
                }
            }
        }
        binding.soundTwelve.setOnClickListener {
            if(binding.soundTwelve.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[11], button = binding.soundTwelve)
            } else {
                //play an audio file
                if(binding.soundTwelve.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioTwelve(binding.soundTwelve)
                } else {
                    playAudioTwelve(pathName = soundFiles[11])
                    changeStyleToAudioPlaying(binding.soundTwelve)
                }
            }
        }
        binding.soundThirteen.setOnClickListener {
            if(binding.soundThirteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[12], button = binding.soundThirteen)
            } else {
                //play an audio file
                if(binding.soundThirteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioThirteen(binding.soundThirteen)
                } else {
                    playAudioThirteen(pathName = soundFiles[12])
                    changeStyleToAudioPlaying(binding.soundThirteen)
                }
            }
        }
        binding.soundFourteen.setOnClickListener {
            if(binding.soundFourteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[13], button = binding.soundFourteen)
            } else {
                //play an audio file
                if(binding.soundFourteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioFourteen(binding.soundFourteen)
                } else {
                    playAudioFourteen(pathName = soundFiles[13])
                    changeStyleToAudioPlaying(binding.soundFourteen)
                }
            }
        }
        binding.soundFifteen.setOnClickListener {
            if(binding.soundFifteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[14], button = binding.soundFifteen)
            } else {
                //play an audio file
                if(binding.soundFifteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioFifteen(binding.soundFifteen)
                } else {
                    playAudioFifteen(pathName = soundFiles[14])
                    changeStyleToAudioPlaying(binding.soundFifteen)
                }
            }
        }
        binding.soundSixteen.setOnClickListener {
            if(binding.soundSixteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[15], button = binding.soundSixteen)
            } else {
                //play an audio file
                if(binding.soundSixteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioSixteen(binding.soundSixteen)
                } else {
                    playAudioSixteen(pathName = soundFiles[15])
                    changeStyleToAudioPlaying(binding.soundSixteen)
                }
            }
        }
        binding.soundSeventeen.setOnClickListener {
            if(binding.soundSeventeen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[16], button = binding.soundSeventeen)
            } else {
                //play an audio file
                if(binding.soundSeventeen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioSeventeen(binding.soundSeventeen)
                } else {
                    playAudioSeventeen(pathName = soundFiles[16])
                    changeStyleToAudioPlaying(binding.soundSeventeen)
                }
            }
        }
        binding.soundEighteen.setOnClickListener {
            if(binding.soundEighteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[17], button = binding.soundEighteen)
            } else {
                //play an audio file
                if(binding.soundEighteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioEighteen(binding.soundEighteen)
                } else {
                    playAudioEighteen(pathName = soundFiles[17])
                    changeStyleToAudioPlaying(binding.soundEighteen)
                }
            }
        }
        binding.soundNineteen.setOnClickListener {
            if(binding.soundNineteen.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[18], button = binding.soundNineteen)
            } else {
                //play an audio file
                if(binding.soundNineteen.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioNineteen(binding.soundNineteen)
                } else {
                    playAudioNineteen(pathName = soundFiles[18])
                    changeStyleToAudioPlaying(binding.soundNineteen)
                }
            }
        }
        binding.soundTwenty.setOnClickListener {
            if(binding.soundTwenty.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[19], button = binding.soundTwenty)
            } else {
                //play an audio file
                if(binding.soundTwenty.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioTwenty(binding.soundTwenty)
                } else {
                    playAudioTwenty(pathName = soundFiles[19])
                    changeStyleToAudioPlaying(binding.soundTwenty)
                }
            }
        }
        binding.stopRecordingButton.setOnClickListener {
            stopAudio(currentAudioButton)
        }

        binding.helpButton.setOnClickListener {
            view?.findNavController
        }
    }

    private fun changeStyleToAudioPlaying(button: AppCompatButton){
        context?.getColor(R.color.orange)?.let { button.setBackgroundColor(it) }
        button.setText(R.string.stop)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun startRecording(pathName: String) {
        binding.stopRecordingButton.isEnabled = true
        recorder = context?.let {
            MediaRecorder(it).apply {
                recorder?.reset()
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(pathName)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

                try {
                    prepare()
                } catch (e: IOException) {
                    Toast.makeText(context, "Prepare failed => ${e.message}", Toast.LENGTH_SHORT).show()
                    println("Prepare failed => ${e.message}")
                }

                start()
            }
        }
    }






    private fun stopPlayBackAudioOne(button: AppCompatButton){
        playerOne.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioTwo(button: AppCompatButton){
        playerTwo.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioThree(button: AppCompatButton){
        playerThree.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioFour(button: AppCompatButton){
        playerFour.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioFive(button: AppCompatButton){
        playerFive.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioSix(button: AppCompatButton){
        playerSix.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioSeven(button: AppCompatButton){
        playerSeven.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioEight(button: AppCompatButton){
        playerEight.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioNine(button: AppCompatButton){
        playerNine.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioTen(button: AppCompatButton){
        playerTen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioEleven(button: AppCompatButton){
        playerEleven.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioTwelve(button: AppCompatButton){
        playerTwelve.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioThirteen(button: AppCompatButton){
        playerThirteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioFourteen(button: AppCompatButton){
        playerFourteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioFifteen(button: AppCompatButton){
        playerFifteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioSixteen(button: AppCompatButton){
        playerSixteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioSeventeen(button: AppCompatButton){
        playerSeventeen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioEighteen(button: AppCompatButton){
        playerEighteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioNineteen(button: AppCompatButton){
        playerNineteen.stop()
        changeButtonStyleToAudioFilled(button)
    }
    private fun stopPlayBackAudioTwenty(button: AppCompatButton){
        playerTwenty.stop()
        changeButtonStyleToAudioFilled(button)
    }

    private fun stopAudio(button: AppCompatButton) {
        println("STOPPING AUDIO ! 1")
        viewModel.recorder?.apply {
            println("STOPPING AUDIO ! 2")
            stop()
            release()

        }
        viewModel.recorder = null
        binding.recordingInProgressScreen.visibility = View.GONE
        binding.mainLayoutGroup.isEnabled = true
        changeButtonStyleToAudioFilled(button)
        enableAllSoundButtons()
    }


    private fun showRecordScreenCountdown(pathName: String, button: AppCompatButton){
        stopAllPlayingAudio()
        disableAllSoundButtons()
        binding.recordingInProgressScreen.visibility = View.VISIBLE
        binding.stopRecordingButton.isEnabled = false
        binding.mainLayoutGroup.isEnabled = false
        startCountdownTimer(pathName = pathName, button = button)
    }

    private fun startCountdownTimer(pathName: String, button: AppCompatButton){
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.recordingInProgressText.text = "${millisUntilFinished/60}"
            }

            @RequiresApi(Build.VERSION_CODES.S)
            override fun onFinish() {
                binding.recordingInProgressText.text = context?.getString(R.string.recording)
                currentAudioButton = button
                startRecording(pathName)
            }
        }
        timer.start()
    }

    private fun stopAllPlayingAudio(){
        playerOne.stop()
        playerTwo.stop()
        playerThree.stop()
        playerFour.stop()
        playerFive.stop()
        playerSix.stop()
        playerSeven.stop()
        playerEight.stop()
        playerNine.stop()
        playerTen.stop()
        playerEleven.stop()
        playerTwelve.stop()
        playerThirteen.stop()
        playerFourteen.stop()
        playerFifteen.stop()
        playerSixteen.stop()
        playerSeventeen.stop()
        playerEighteen.stop()
        playerNineteen.stop()
        playerTwenty.stop()

        val fileOne = File(soundFiles[0])
        if(fileOne.exists()){
            changeButtonStyleToAudioFilled(binding.soundOne)
        }else {
            changeButtonStyleToRecordAudio(binding.soundOne)
        }

        val fileTwo = File(soundFiles[1])
        if(fileTwo.exists()){
            changeButtonStyleToAudioFilled(binding.soundTwo)
        } else {
            changeButtonStyleToRecordAudio(binding.soundTwo)
        }
        val fileThree = File(soundFiles[2])
        if(fileThree.exists()){
            changeButtonStyleToAudioFilled(binding.soundThree)
        } else {
            changeButtonStyleToRecordAudio(binding.soundThree)
        }
        val fileFour = File(soundFiles[3])
        if(fileFour.exists()){
            changeButtonStyleToAudioFilled(binding.soundFour)
        } else {
            changeButtonStyleToRecordAudio(binding.soundFour)
        }
        val fileFive = File(soundFiles[4])
        if(fileFive.exists()){
            changeButtonStyleToAudioFilled(binding.soundFive)
        } else {
            changeButtonStyleToRecordAudio(binding.soundFive)
        }
        val fileSix = File(soundFiles[5])
        if(fileSix.exists()){
            changeButtonStyleToAudioFilled(binding.soundSix)
        } else {
            changeButtonStyleToRecordAudio(binding.soundSix)
        }
        val fileSeven = File(soundFiles[6])
        if(fileSeven.exists()){
            changeButtonStyleToAudioFilled(binding.soundSeven)
        } else {
            changeButtonStyleToRecordAudio(binding.soundSeven)
        }
        val fileEight = File(soundFiles[7])
        if(fileEight.exists()){
            changeButtonStyleToAudioFilled(binding.soundEight)
        } else {
            changeButtonStyleToRecordAudio(binding.soundEight)
        }
        val fileNine = File(soundFiles[8])
        if(fileNine.exists()){
            changeButtonStyleToAudioFilled(binding.soundNine)
        } else {
            changeButtonStyleToRecordAudio(binding.soundNine)
        }
        val fileTen = File(soundFiles[9])
        if(fileTen.exists()){
            changeButtonStyleToAudioFilled(binding.soundTen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundTen)
        }
        val fileEleven = File(soundFiles[10])
        if(fileEleven.exists()){
            changeButtonStyleToAudioFilled(binding.soundEleven)
        } else {
            changeButtonStyleToRecordAudio(binding.soundEleven)
        }
        val fileTwelve = File(soundFiles[11])
        if(fileTwelve.exists()){
            changeButtonStyleToAudioFilled(binding.soundTwelve)
        } else {
            changeButtonStyleToRecordAudio(binding.soundTwelve)
        }
        val fileThirteen = File(soundFiles[12])
        if(fileThirteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundThirteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundThirteen)
        }
        val fileFourteen = File(soundFiles[13])
        if(fileFourteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundFourteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundFourteen)
        }
        val fileFifteen = File(soundFiles[14])
        if(fileFifteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundFifteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundFifteen)
        }
        val fileSixteen = File(soundFiles[15])
        if(fileSixteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundSixteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundSixteen)
        }
        val fileSeventeen = File(soundFiles[16])
        if(fileSeventeen.exists()){
            changeButtonStyleToAudioFilled(binding.soundSeventeen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundSeventeen)
        }
        val fileEighteen = File(soundFiles[17])
        if(fileEighteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundEighteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundEighteen)
        }
        val fileNineteen = File(soundFiles[18])
        if(fileNineteen.exists()){
            changeButtonStyleToAudioFilled(binding.soundNineteen)
        } else {
            changeButtonStyleToRecordAudio(binding.soundNineteen)
        }
        val fileTwenty = File(soundFiles[19])
        if(fileTwenty.exists()){
            changeButtonStyleToAudioFilled(binding.soundTwenty)
        } else {
            changeButtonStyleToRecordAudio(binding.soundTwenty)
        }
    }

    private fun disableAllSoundButtons(){
        binding.soundOne.isEnabled = false
        binding.soundTwo.isEnabled = false
        binding.soundThree.isEnabled = false
        binding.soundFour.isEnabled = false
        binding.soundFive.isEnabled = false
        binding.soundSix.isEnabled = false
        binding.soundSeven.isEnabled = false
        binding.soundEight.isEnabled = false
        binding.soundNine.isEnabled = false
        binding.soundTen.isEnabled = false
        binding.soundEleven.isEnabled = false
        binding.soundTwelve.isEnabled = false
        binding.soundThirteen.isEnabled = false
        binding.soundFourteen.isEnabled = false
        binding.soundFifteen.isEnabled = false
        binding.soundSixteen.isEnabled = false
        binding.soundSeventeen.isEnabled = false
        binding.soundEighteen.isEnabled = false
        binding.soundNineteen.isEnabled = false
        binding.soundTwenty.isEnabled = false

    }

    private fun enableAllSoundButtons(){
        binding.soundOne.isEnabled = true
        binding.soundTwo.isEnabled = true
        binding.soundThree.isEnabled = true
        binding.soundFour.isEnabled = true
        binding.soundFive.isEnabled = true
        binding.soundSix.isEnabled = true
        binding.soundSeven.isEnabled = true
        binding.soundEight.isEnabled = true
        binding.soundNine.isEnabled = true
        binding.soundTen.isEnabled = true
        binding.soundEleven.isEnabled = true
        binding.soundTwelve.isEnabled = true
        binding.soundThirteen.isEnabled = true
        binding.soundFourteen.isEnabled = true
        binding.soundFifteen.isEnabled = true
        binding.soundSixteen.isEnabled = true
        binding.soundSeventeen.isEnabled = true
        binding.soundEighteen.isEnabled = true
        binding.soundNineteen.isEnabled = true
        binding.soundTwenty.isEnabled = true
    }
    private fun deleteAudio(pathName: String){
        val file = File(pathName)
        if(file.exists()){
            file.delete()
        } else {
            Toast.makeText(context, "Could not delete $pathName", Toast.LENGTH_SHORT).show()
        }
    }
}