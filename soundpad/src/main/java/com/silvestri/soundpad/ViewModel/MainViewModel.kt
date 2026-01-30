package com.silvestri.soundpad.ViewModel

import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.CountDownTimer
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import java.io.File
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.silvestri.soundpad.R
import java.io.IOException
import kotlin.collections.get


class MainViewModel {

    init{
        setupSoundFiles()
    }

    var recorder: MediaRecorder? = null
    var soundFiles = emptyArray<String>()

    val playerOne = MediaPlayer()
    val playerTwo = MediaPlayer()
    val playerThree = MediaPlayer()
    val playerFour = MediaPlayer()
    val playerFive = MediaPlayer()
    val playerSix = MediaPlayer()
    val playerSeven = MediaPlayer()
    val playerEight = MediaPlayer()
    val playerNine = MediaPlayer()
    val playerTen = MediaPlayer()
    val playerEleven = MediaPlayer()
    val playerTwelve = MediaPlayer()
    val playerThirteen = MediaPlayer()
    val playerFourteen = MediaPlayer()
    val playerFifteen = MediaPlayer()
    val playerSixteen = MediaPlayer()
    val playerSeventeen = MediaPlayer()
    val playerEighteen = MediaPlayer()
    val playerNineteen = MediaPlayer()
    val playerTwenty = MediaPlayer()

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

    var soundFileActiveCount = ObservableField(0)
    var soundOneText = ObservableField("")
    var soundTwoText = ObservableField("")
    var soundThreeText = ObservableField("")
    var soundFourText = ObservableField("")
    var soundFiveText = ObservableField("")
    var soundSixText = ObservableField("")
    var soundSevenText = ObservableField("")
    var soundEightText = ObservableField("")
    var soundNineText = ObservableField("")
    var soundTenText = ObservableField("")
    var soundElevenText = ObservableField("")
    var soundTwelveText = ObservableField("")
    var soundThirteenText = ObservableField("")
    var soundFourteenText = ObservableField("")
    var soundFifteenText = ObservableField("")
    var soundSixteenText = ObservableField("")
    var soundSeventeenText = ObservableField("")
    var soundEighteenText = ObservableField("")
    var soundNineteenText = ObservableField("")
    var soundTwentyText = ObservableField("")

    var soundOneColor = ObservableField(0)
    var soundTwoColor = ObservableField(0)
    var soundThreeColor= ObservableField(0)
    var soundFourColor = ObservableField(0)
    var soundFiveColor = ObservableField(0)
    var soundSixColor = ObservableField(0)
    var soundSevenColor= ObservableField(0)
    var soundEightColor = ObservableField(0)
    var soundNineColor= ObservableField(0)
    var soundTenColor = ObservableField(0)
    var soundElevenColor = ObservableField(0)
    var soundTwelveColor = ObservableField(0)
    var soundThirteenColor = ObservableField(0)
    var soundFourteenColor = ObservableField(0)
    var soundFifteenColor = ObservableField(0)
    var soundSixteenColor = ObservableField(0)
    var soundSeventeenColor = ObservableField(0)
    var soundEighteenColor = ObservableField(0)
    var soundNineteenColor = ObservableField(0)
    var soundTwentyColor = ObservableField(0)

    var recordText = ObservableField("")
    var playText = ObservableField("")
    var stopText = ObservableField("")

    var soundOneEnabled = ObservableField(true)
    var soundTwoEnabled = ObservableField(true)
    var soundThreeEnabled = ObservableField(true)
    var soundFourEnabled = ObservableField(true)
    var soundFiveEnabled = ObservableField(true)
    var soundSixEnabled = ObservableField(true)
    var soundSevenEnabled = ObservableField(true)
    var soundEightEnabled = ObservableField(true)
    var soundNineEnabled = ObservableField(true)
    var soundTenEnabled = ObservableField(true)
    var soundElevenEnabled = ObservableField(true)
    var soundTwelveEnabled = ObservableField(true)
    var soundThirteenEnabled = ObservableField(true)
    var soundFourteenEnabled = ObservableField(true)
    var soundFifteenEnabled = ObservableField(true)
    var soundSixteenEnabled = ObservableField(true)
    var soundSeventeenEnabled = ObservableField(true)
    var soundEighteenEnabled = ObservableField(true)
    var soundNineteenEnabled = ObservableField(true)
    var soundTwentyEnabled = ObservableField(true)

    var stopRecordingButtonEnabled = ObservableField(true)

    var recordingInProgressVisibility = ObservableField(false)
    var mainLayoutVisibility = ObservableField(false)


    fun setupSoundFiles(){
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
    }

    fun soundOneClick(){
        if(soundOneText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[0], button = binding.soundOne)
        } else {
            //play an audio file
//                fileName = "${activity?.externalCacheDir?.absolutePath}/soundOne.3gp"
            if(playerOne.isPlaying){
                stopSoundOne()
            } else {
                playSoundOne(pathName = soundFiles[0])
                changeStyleToAudioPlaying(binding.soundOne)
            }

        }
    }

    fun showRecordScreenCountdown(){
        stopAllAudioPlayers()
        disableAllButtons()
        recordingInProgressVisibility.set(true)
        stopRecordingButtonEnabled.set(false)
        mainLayoutVisibility.set(false)
        //TODO: Left off here, 1/29/2026

    }

    fun startCountdownTimer(pathName: String, button: AppCompatButton){
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

    fun disableAllButtons(){
        soundOneEnabled.set(false)
        soundTwoEnabled.set(false)
        soundThreeEnabled.set(false)
        soundFourEnabled.set(false)
        soundFiveEnabled.set(false)
        soundSixEnabled.set(false)
        soundSevenEnabled.set(false)
        soundEightEnabled.set(false)
        soundNineEnabled.set(false)
        soundTenEnabled.set(false)
        soundElevenEnabled.set(false)
        soundTwelveEnabled.set(false)
        soundThirteenEnabled.set(false)
        soundFourteenEnabled.set(false)
        soundFifteenEnabled.set(false)
        soundSixteenEnabled.set(false)
        soundSeventeenEnabled.set(false)
        soundEighteenEnabled.set(false)
        soundNineteenEnabled.set(false)
        soundTwentyEnabled.set(false)
    }

    fun enableAllButtons(){
        soundOneEnabled.set(true)
        soundTwoEnabled.set(true)
        soundThreeEnabled.set(true)
        soundFourEnabled.set(true)
        soundFiveEnabled.set(true)
        soundSixEnabled.set(true)
        soundSevenEnabled.set(true)
        soundEightEnabled.set(true)
        soundNineEnabled.set(true)
        soundTenEnabled.set(true)
        soundElevenEnabled.set(true)
        soundTwelveEnabled.set(true)
        soundThirteenEnabled.set(true)
        soundFourteenEnabled.set(true)
        soundFifteenEnabled.set(true)
        soundSixteenEnabled.set(true)
        soundSeventeenEnabled.set(true)
        soundEighteenEnabled.set(true)
        soundNineteenEnabled.set(true)
        soundTwentyEnabled.set(true)
    }

    fun stopAllAudioPlayers(){
        stopSoundOne()
        stopSoundTwo()
        stopSoundThree()
        stopSoundFour()
        stopSoundFive()
        stopSoundSix()
        stopSoundSeven()
        stopSoundEight()
        stopSoundNine()
        stopSoundTen()
        stopSoundEleven()
        stopSoundTwelve()
        stopSoundThirteen()
        stopSoundFourteen()
        stopSoundFifteen()
        stopSoundSixteen()
        stopSoundSeventeen()
        stopSoundEighteen()
        stopSoundNineteen()
        stopSoundTwenty()
    }

    fun stopSoundOne(){
        playerOne.stop()
    }
    fun stopSoundTwo(){
        playerTwo.stop()
    }
    fun stopSoundThree(){
        playerThree.stop()
    }
    fun stopSoundFour(){
        playerFour.stop()
    }
    fun stopSoundFive(){
        playerFive.stop()
    }
    fun stopSoundSix(){
        playerSix.stop()
    }
    fun stopSoundSeven(){
        playerSeven.stop()
    }
    fun stopSoundEight(){
        playerEight.stop()
    }
    fun stopSoundNine(){
        playerNine.stop()
    }
    fun stopSoundTen(){
        playerTen.stop()
    }
    fun stopSoundEleven(){
        playerEleven.stop()
    }
    fun stopSoundTwelve(){
        playerTwelve.stop()
    }
    fun stopSoundThirteen(){
        playerThirteen.stop()
    }
    fun stopSoundFourteen(){
        playerFourteen.stop()
    }
    fun stopSoundFifteen(){
        playerFifteen.stop()
    }
    fun stopSoundSixteen(){
        playerSixteen.stop()
    }
    fun stopSoundSeventeen(){
        playerSeventeen.stop()
    }
    fun stopSoundEighteen(){
        playerEighteen.stop()
    }
    fun stopSoundNineteen(){
        playerNineteen.stop()
    }
    fun stopSoundTwenty(){
        playerTwenty.stop()
    }


    fun playAudioOne(pathName: String) {
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
    fun playAudioTwo(pathName: String) {
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
    fun playAudioThree(pathName: String) {
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
    fun playAudioFour(pathName: String) {
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

    fun playAudioFive(pathName: String) {
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

    fun playAudioSix(pathName: String) {
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

    fun playAudioSeven(pathName: String) {
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

    fun playAudioEight(pathName: String) {
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

    fun playAudioNine(pathName: String) {
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

    fun playAudioTen(pathName: String) {
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

    fun playAudioEleven(pathName: String) {
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

    fun playAudioTwelve(pathName: String) {
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

    fun playAudioThirteen(pathName: String) {
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

    fun playAudioFourteen(pathName: String) {
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

    fun playAudioFifteen(pathName: String) {
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

    fun playAudioSixteen(pathName: String) {
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

    fun playAudioSeventeen(pathName: String) {
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

    fun playAudioEighteen(pathName: String) {
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

    fun playAudioNineteen(pathName: String) {
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

    fun playAudioTwenty(pathName: String) {
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


}