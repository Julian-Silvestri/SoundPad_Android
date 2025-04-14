package com.silvestri.soundpad.fragments

import android.media.MediaPlayer
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
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding
import java.io.File
import java.io.IOException


class MainFragment: Fragment(R.layout.main_fragment_layout) {

    companion object{
        var soundOne = ""
        var soundTwo = ""
        var soundThree = ""
        var soundFour = ""
        var soundFive = ""
        var soundSix = ""
        var soundSeven = ""
        var soundEight = ""
        var soundNine = ""
        var soundTen = ""
        var soundEleven = ""
        var soundTwelve = ""
        var soundThirteen = ""
        var soundFourteen = ""
        var soundFifteen = ""
        var soundSixteen = ""
        var soundSeventeen = ""
        var soundEighteen = ""
        var soundNineteen = ""
        var soundTwenty = ""
    }

    private lateinit var binding: MainFragmentLayoutBinding
    private lateinit var currentAudioButton: AppCompatButton
    private var recorder: MediaRecorder? = null
    private val playerOne = MediaPlayer()
    private val playerTwo = MediaPlayer()
    private val playerThree = MediaPlayer()
    private val playerFour = MediaPlayer()
    private val playerFive = MediaPlayer()
    private val playerSix = MediaPlayer()
    private val playerSeven = MediaPlayer()
    private val playerEight = MediaPlayer()
    private val playerNine = MediaPlayer()
    private val playerTen = MediaPlayer()
    private val playerEleven = MediaPlayer()
    private val playerTwelve = MediaPlayer()
    private val playerThirteen = MediaPlayer()
    private val playerFourteen = MediaPlayer()
    private val playerFifteen = MediaPlayer()
    private val playerSixteen = MediaPlayer()
    private val playerSeventeen = MediaPlayer()
    private val playerEighteen = MediaPlayer()
    private val playerNineteen = MediaPlayer()
    private val playerTwenty = MediaPlayer()

    private var soundFiles = emptyArray<String>()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
        setupButtons()
        setupViews()
        setupSoundPaths()

    }

    private fun setupSoundPaths(){
        val soundOne = "${activity?.externalCacheDir?.absolutePath}/soundOne.3gp"
        val soundTwo = "${activity?.externalCacheDir?.absolutePath}/soundTwo.3gp"
        val soundThree = "${activity?.externalCacheDir?.absolutePath}/soundThree.3gp"
        val soundFour = "${activity?.externalCacheDir?.absolutePath}/soundFour.3gp"
        val soundFive = "${activity?.externalCacheDir?.absolutePath}/soundFive.3gp"
        val soundSix = "${activity?.externalCacheDir?.absolutePath}/soundSix.3gp"
        val soundSeven = "${activity?.externalCacheDir?.absolutePath}/soundSeven.3gp"
        val soundEight = "${activity?.externalCacheDir?.absolutePath}/soundEight.3gp"
        val soundNine = "${activity?.externalCacheDir?.absolutePath}/soundNine.3gp"
        val soundTen = "${activity?.externalCacheDir?.absolutePath}/soundTen.3gp"
        val soundEleven = "${activity?.externalCacheDir?.absolutePath}/soundEleven.3gp"
        val soundTwelve = "${activity?.externalCacheDir?.absolutePath}/soundTwelve.3gp"
        val soundThirteen = "${activity?.externalCacheDir?.absolutePath}/soundThirteen.3gp"
        val soundFourteen = "${activity?.externalCacheDir?.absolutePath}/soundFourteen.3gp"
        val soundFifteen = "${activity?.externalCacheDir?.absolutePath}/soundFifteen.3gp"
        val soundSixteen = "${activity?.externalCacheDir?.absolutePath}/soundSixteen.3gp"
        val soundSeventeen = "${activity?.externalCacheDir?.absolutePath}/soundSeventeen.3gp"
        val soundEighteen = "${activity?.externalCacheDir?.absolutePath}/soundEighteen.3gp"
        val soundNineteen = "${activity?.externalCacheDir?.absolutePath}/soundNineteen.3gp"
        val soundTwenty = "${activity?.externalCacheDir?.absolutePath}/soundTwenty.3gp"

        soundFiles = arrayOf(
            soundOne,
            soundTwo,
            soundThree,
            soundFour,
            soundFive,
            soundSix,
            soundSeven,
            soundEight,
            soundNine,
            soundTen,
            soundEleven,
            soundTwelve,
            soundThirteen,
            soundFourteen,
            soundFifteen,
            soundSixteen,
            soundSeventeen,
            soundEighteen,
            soundNineteen,
            soundTwenty
        )
        setupSoundFiles(soundFiles)
    }

    private fun setupSoundFiles(soundFiles: Array<String>){
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
                changeButtonStyleToAudioFilled(binding.soundOne)
            }
            1 -> {
                changeButtonStyleToAudioFilled(binding.soundTwo)
            }
            2 -> {
                changeButtonStyleToAudioFilled(binding.soundThree)
            }
            3 -> {
                changeButtonStyleToAudioFilled(binding.soundFour)
            }
            4 -> {
                changeButtonStyleToAudioFilled(binding.soundFive)
            }
            5 -> {
                changeButtonStyleToAudioFilled(binding.soundSix)
            }
            6 -> {
                changeButtonStyleToAudioFilled(binding.soundSeven)
            }
            7 -> {
                changeButtonStyleToAudioFilled(binding.soundEight)
            }
            8 -> {
                changeButtonStyleToAudioFilled(binding.soundNine)
            }
            9 -> {
                changeButtonStyleToAudioFilled(binding.soundTen)
            }
            10 -> {
                changeButtonStyleToAudioFilled(binding.soundEleven)
            }
            11 -> {
                changeButtonStyleToAudioFilled(binding.soundTwelve)
            }
            12 -> {
                changeButtonStyleToAudioFilled(binding.soundThirteen)
            }
            13 -> {
                changeButtonStyleToAudioFilled(binding.soundFourteen)
            }
            14 -> {
                changeButtonStyleToAudioFilled(binding.soundFifteen)
            }
            15 -> {
                changeButtonStyleToAudioFilled(binding.soundSixteen)
            }
            16 -> {
                changeButtonStyleToAudioFilled(binding.soundSeventeen)
            }
            17 -> {
                changeButtonStyleToAudioFilled(binding.soundEighteen)
            }
            18 -> {
                changeButtonStyleToAudioFilled(binding.soundNineteen)
            }
            19 -> {
                changeButtonStyleToAudioFilled(binding.soundTwenty)
            }
        }

    }

    private fun setupRecordButtonSoundStyle(index: Int){
        if(index == 0){
            changeButtonStyleToRecordAudio(binding.soundOne)
        }else if(index == 1){
            changeButtonStyleToRecordAudio(binding.soundTwo)
        }else if(index == 2){
            changeButtonStyleToRecordAudio(binding.soundThree)
        }
        else if(index == 3){
            changeButtonStyleToRecordAudio(binding.soundFour)
        }
        else if(index == 4){
            changeButtonStyleToRecordAudio(binding.soundFive)
        }
        else if(index == 5){
            changeButtonStyleToRecordAudio(binding.soundSix)
        }
        else if(index == 6){
            changeButtonStyleToRecordAudio(binding.soundSeven)
        }
        else if(index == 7){
            changeButtonStyleToRecordAudio(binding.soundEight)
        }
        else if(index == 8){
            changeButtonStyleToRecordAudio(binding.soundNine)
        }
        else if(index == 9){
            changeButtonStyleToRecordAudio(binding.soundTen)
        }
        else if(index == 10){
            changeButtonStyleToRecordAudio(binding.soundEleven)
        }
        else if(index == 11){
            changeButtonStyleToRecordAudio(binding.soundTwelve)
        }
        else if(index == 12){
            changeButtonStyleToRecordAudio(binding.soundThirteen)
        }
        else if(index == 13){
            changeButtonStyleToRecordAudio(binding.soundFourteen)
        }
        else if(index == 14){
            changeButtonStyleToRecordAudio(binding.soundFifteen)
        }
        else if(index == 15){
            changeButtonStyleToRecordAudio(binding.soundSixteen)
        }
        else if(index == 16){
            changeButtonStyleToRecordAudio(binding.soundSeventeen)
        }
        else if(index == 17){
            changeButtonStyleToRecordAudio(binding.soundEighteen)
        }
        else if(index == 18){
            changeButtonStyleToRecordAudio(binding.soundNineteen)
        }
        else if(index == 19){
            changeButtonStyleToRecordAudio(binding.soundTwenty)
        }
    }

    private fun setupViews(){
        binding.recordingInProgressScreen.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setupButtons(){



        binding.soundOne.setOnClickListener {
            if(binding.soundOne.text == context?.getString(R.string.record)){
                //record an audio file
                showRecordScreenCountdown(pathName = soundFiles[0], button = binding.soundOne)
            } else {
                //play an audio file
//                fileName = "${activity?.externalCacheDir?.absolutePath}/soundOne.3gp"
                if(binding.soundOne.text == context?.getString(R.string.stop)){
                    stopPlayBackAudioOne(binding.soundOne)
                } else {
                    playAudioOne(pathName = soundFiles[0])
                    changeStyleToAudioPlaying(binding.soundOne)
                }

            }
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

    private fun playAudioOne(pathName: String) {
        playerOne.reset()
        playerOne.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerOne.start()
        playerOne.isLooping = true

    }
    private fun playAudioTwo(pathName: String) {
        playerTwo.reset()
        playerTwo.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerTwo.start()
        playerTwo.isLooping = true

    }
    private fun playAudioThree(pathName: String) {
        playerThree.reset()
        playerThree.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerThree.start()
        playerThree.isLooping = true

    }
    private fun playAudioFour(pathName: String) {
        playerFour.reset()
        playerFour.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerFour.start()
        playerFour.isLooping = true

    }
    private fun playAudioFive(pathName: String) {
        playerFive.reset()
        playerFive.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerFive.start()
        playerFive.isLooping = true

    }
    private fun playAudioSix(pathName: String) {
        playerSix.reset()
        playerSix.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerSix.start()
        playerSix.isLooping = true

    }
    private fun playAudioSeven(pathName: String) {
        playerSeven.reset()
        playerSeven.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerSeven.start()
        playerSeven.isLooping = true

    }
    private fun playAudioEight(pathName: String) {
        playerEight.reset()
        playerEight.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerEight.start()
        playerEight.isLooping = true

    }
    private fun playAudioNine(pathName: String) {
        playerNine.reset()
        playerNine.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerNine.start()
        playerNine.isLooping = true

    }
    private fun playAudioTen(pathName: String) {
        playerTen.reset()
        playerTen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerTen.start()
        playerTen.isLooping = true

    }
    private fun playAudioEleven(pathName: String) {
        playerEleven.reset()
        playerEleven.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerEleven.start()
        playerEleven.isLooping = true

    }
    private fun playAudioTwelve(pathName: String) {
        playerTwelve.reset()
        playerTwelve.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerTwelve.start()
        playerTwelve.isLooping = true

    }
    private fun playAudioThirteen(pathName: String) {
        playerThirteen.reset()
        playerThirteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerThirteen.start()
        playerThirteen.isLooping = true

    }
    private fun playAudioFourteen(pathName: String) {
        playerFourteen.reset()
        playerFourteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerFourteen.start()
        playerFourteen.isLooping = true

    }
    private fun playAudioFifteen(pathName: String) {
        playerFifteen.reset()
        playerFifteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerFifteen.start()
        playerFifteen.isLooping = true

    }
    private fun playAudioSixteen(pathName: String) {
        playerSixteen.reset()
        playerSixteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerSixteen.start()
        playerSixteen.isLooping = true

    }
    private fun playAudioSeventeen(pathName: String) {
        playerSeventeen.reset()
        playerSeventeen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerSeventeen.start()
        playerSeventeen.isLooping = true

    }
    private fun playAudioEighteen(pathName: String) {
        playerEighteen.reset()
        playerEighteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerEighteen.start()
        playerEighteen.isLooping = true

    }
    private fun playAudioNineteen(pathName: String) {
        playerNineteen.reset()
        playerNineteen.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerNineteen.start()
        playerNineteen.isLooping = true

    }
    private fun playAudioTwenty(pathName: String) {
        playerTwenty.reset()
        playerTwenty.apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerTwenty.start()
        playerTwenty.isLooping = true

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
        recorder?.apply {
            println("STOPPING AUDIO ! 2")
            stop()
            release()

        }
        recorder = null
        binding.recordingInProgressScreen.visibility = View.GONE
        binding.mainLayoutGroup.isEnabled = true
        changeButtonStyleToAudioFilled(button)
        enableAllSoundButtons()
    }

    private fun changeButtonStyleToAudioFilled(button: AppCompatButton) {
        println("STOPPING AUDIO ! 3")
        button.text = context?.getString(R.string.play)
        context?.getColor(R.color.emeraldGreen)?.let { button.setBackgroundColor(it) }
    }

    private fun changeButtonStyleToRecordAudio(button: AppCompatButton) {
        button.text = context?.getString(R.string.record)
        context?.getColor(R.color.white)?.let { button.setBackgroundColor(it) }
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