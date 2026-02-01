package com.silvestri.soundpad.models

import android.app.Application
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.CountDownTimer
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import java.io.File
import java.io.IOException

class MainViewModel(application: Application) : AndroidViewModel(application) {

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

    var currentActiveAudioBtn = ObservableField(0)
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
    var mainLayoutVisibility = ObservableField(true)
    var recordingInProgressText = ObservableField("")

    var orangeColor = ObservableField(0)
    var whiteColor = ObservableField(0)
    var emeraldGreenColor = ObservableField(0)

    fun getApp(): Application {
        return getApplication()
    }



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
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundOneClick(){
        if(soundOneText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[0], button = 0)
        } else {
            //play an audio file
            if(playerOne.isPlaying){
                stopSoundOne()
                soundOneColor.set(emeraldGreenColor.get())
                soundOneText.set(playText.get())
            } else {
                playAudioOne(pathName = soundFiles[0])
                soundOneColor.set(orangeColor.get())
                soundOneText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundTwoClick(){
        if(soundTwoText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[1], button = 1)
        } else {
            //play an audio file
            if(playerTwo.isPlaying){
                stopSoundTwo()
                soundTwoColor.set(emeraldGreenColor.get())
                soundTwoText.set(playText.get())
            } else {
                playAudioTwo(pathName = soundFiles[1])
                soundTwoColor.set(orangeColor.get())
                soundTwoText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundThreeClick(){
        if(soundThreeText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[2], button = 2)
        } else {
            //play an audio file
            if(playerThree.isPlaying){
                stopSoundThree()
                soundThreeColor.set(emeraldGreenColor.get())
                soundThreeText.set(playText.get())
            } else {
                playAudioThree(pathName = soundFiles[2])
                soundThreeColor.set(orangeColor.get())
                soundThreeText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundFourClick(){
        if(soundFourText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[3], button = 3)
        } else {
            //play an audio file
            if(playerFour.isPlaying){
                stopSoundFour()
                soundFourColor.set(emeraldGreenColor.get())
                soundFourText.set(playText.get())
            } else {
                playAudioFour(pathName = soundFiles[3])
                soundFourColor.set(orangeColor.get())
                soundFourText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundFiveClick(){
        if(soundFiveText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[4], button = 4)
        } else {
            //play an audio file
            if(playerFive.isPlaying){
                stopSoundFive()
                soundFiveColor.set(emeraldGreenColor.get())
                soundFiveText.set(playText.get())
            } else {
                playAudioFive(pathName = soundFiles[4])
                soundFiveColor.set(orangeColor.get())
                soundFiveText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundSixClick(){
        if(soundSixText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[5], button = 5)
        } else {
            //play an audio file
            if(playerSix.isPlaying){
                stopSoundSix()
                soundSixColor.set(emeraldGreenColor.get())
                soundSixText.set(playText.get())
            } else {
                playAudioSix(pathName = soundFiles[5])
                soundSixColor.set(orangeColor.get())
                soundSixText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundSevenClick(){
        if(soundSevenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[6], button = 6)
        } else {
            //play an audio file
            if(playerSeven.isPlaying){
                stopSoundSeven()
                soundSevenColor.set(emeraldGreenColor.get())
                soundSevenText.set(playText.get())
            } else {
                playAudioSeven(pathName = soundFiles[6])
                soundSevenColor.set(orangeColor.get())
                soundSevenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundEightClick(){
        if(soundEightText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[7], button = 7)
        } else {
            //play an audio file
            if(playerEight.isPlaying){
                stopSoundEight()
                soundEightColor.set(emeraldGreenColor.get())
                soundEightText.set(playText.get())
            } else {
                playAudioEight(pathName = soundFiles[7])
                soundEightColor.set(orangeColor.get())
                soundEightText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundNineClick(){
        if(soundNineText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[8], button = 8)
        } else {
            //play an audio file
            if(playerNine.isPlaying){
                stopSoundNine()
                soundNineColor.set(emeraldGreenColor.get())
                soundNineText.set(playText.get())
            } else {
                playAudioNine(pathName = soundFiles[8])
                soundNineColor.set(orangeColor.get())
                soundNineText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundTenClick(){
        if(soundTenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[9], button = 9)
        } else {
            //play an audio file
            if(playerTen.isPlaying){
                stopSoundTen()
                soundTenColor.set(emeraldGreenColor.get())
                soundTenText.set(playText.get())
            } else {
                playAudioTen(pathName = soundFiles[9])
                soundTenColor.set(orangeColor.get())
                soundTenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundElevenClick(){
        if(soundElevenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[10], button = 10)
        } else {
            //play an audio file
            if(playerEleven.isPlaying){
                stopSoundEleven()
                soundElevenColor.set(emeraldGreenColor.get())
                soundElevenText.set(playText.get())
            } else {
                playAudioEleven(pathName = soundFiles[10])
                soundElevenColor.set(orangeColor.get())
                soundElevenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundTwelveClick(){
        if(soundTwelveText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[11], button = 11)
        } else {
            //play an audio file
            if(playerTwelve.isPlaying){
                stopSoundTwelve()
                soundTwelveColor.set(emeraldGreenColor.get())
                soundTwelveText.set(playText.get())
            } else {
                playAudioTwelve(pathName = soundFiles[11])
                soundTwelveColor.set(orangeColor.get())
                soundTwelveText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundThirteenClick(){
        if(soundThirteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[12], button = 12)
        } else {
            //play an audio file
            if(playerThirteen.isPlaying){
                stopSoundThirteen()
                soundThirteenColor.set(emeraldGreenColor.get())
                soundThirteenText.set(playText.get())
            } else {
                playAudioThirteen(pathName = soundFiles[12])
                soundThirteenColor.set(orangeColor.get())
                soundThirteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundFourteenClick(){
        if(soundFourteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[13], button = 13)
        } else {
            //play an audio file
            if(playerFourteen.isPlaying){
                stopSoundFourteen()
                soundFourteenColor.set(emeraldGreenColor.get())
                soundFourteenText.set(playText.get())
            } else {
                playAudioFourteen(pathName = soundFiles[13])
                soundFourteenColor.set(orangeColor.get())
                soundFourteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundFifteenClick(){
        if(soundFifteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[14], button = 14)
        } else {
            //play an audio file
            if(playerFifteen.isPlaying){
                stopSoundFifteen()
                soundFifteenColor.set(emeraldGreenColor.get())
                soundFifteenText.set(playText.get())
            } else {
                playAudioFifteen(pathName = soundFiles[14])
                soundFifteenColor.set(orangeColor.get())
                soundFifteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundSixteenClick(){
        if(soundSixteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[15], button = 15)
        } else {
            //play an audio file
            if(playerSixteen.isPlaying){
                stopSoundSixteen()
                soundSixteenColor.set(emeraldGreenColor.get())
                soundSixteenText.set(playText.get())
            } else {
                playAudioSixteen(pathName = soundFiles[15])
                soundSixteenColor.set(orangeColor.get())
                soundSixteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundSeventeenClick(){
        if(soundSeventeenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[16], button = 16)
        } else {
            //play an audio file
            if(playerSeventeen.isPlaying){
                stopSoundSeventeen()
                soundSeventeenColor.set(emeraldGreenColor.get())
                soundSeventeenText.set(playText.get())
            } else {
                playAudioSeventeen(pathName = soundFiles[16])
                soundSeventeenColor.set(orangeColor.get())
                soundSeventeenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundEighteenClick(){
        if(soundEighteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[17], button = 17)
        } else {
            //play an audio file
            if(playerEighteen.isPlaying){
                stopSoundEighteen()
                soundEighteenColor.set(emeraldGreenColor.get())
                soundEighteenText.set(playText.get())
            } else {
                playAudioEighteen(pathName = soundFiles[17])
                soundEighteenColor.set(orangeColor.get())
                soundEighteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundNineteenClick(){
        if(soundNineteenText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[18], button = 18)
        } else {
            //play an audio file
            if(playerNineteen.isPlaying){
                stopSoundNineteen()
                soundNineteenColor.set(emeraldGreenColor.get())
                soundNineteenText.set(playText.get())
            } else {
                playAudioNineteen(pathName = soundFiles[18])
                soundNineteenColor.set(orangeColor.get())
                soundNineteenText.set(stopText.get())
            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundTwentyClick(){
        if(soundTwentyText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[19], button = 19)
        } else {
            //play an audio file
            if(playerTwenty.isPlaying){
                stopSoundTwenty()
                soundTwentyColor.set(emeraldGreenColor.get())
                soundTwentyText.set(playText.get())
            } else {
                playAudioTwenty(pathName = soundFiles[19])
                soundTwentyColor.set(orangeColor.get())
                soundTwentyText.set(stopText.get())
            }

        }
    }

    fun showRecordScreenCountdown(pathName: String, button:Int){
        stopAllAudioPlayers()
        disableAllButtons()
        recordingInProgressVisibility.set(true)
        stopRecordingButtonEnabled.set(false)
        mainLayoutVisibility.set(false)
        //TODO: Left off here, 1/29/2026
        startCountdownTimer(pathName = pathName, button = button)

    }

    fun startCountdownTimer(pathName: String, button: Int){
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                recordingInProgressText.set("${millisUntilFinished/60}")
            }

            @RequiresApi(Build.VERSION_CODES.S)
            override fun onFinish() {
                recordingInProgressText.set(recordText.get())
                currentActiveAudioBtn.set(button)
                startRecording(pathName)
            }
        }
        timer.start()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun startRecording(pathName: String) {
        stopRecordingButtonEnabled.set(true)
        recorder =
            MediaRecorder(getApp()).apply {
                recorder?.reset()
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(pathName)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

                try {
                    prepare()
                } catch (e: IOException) {
                    Toast.makeText(getApp(), "Prepare failed => ${e.message}", Toast.LENGTH_SHORT).show()
                    println("Prepare failed => ${e.message}")
                }

                start()
            }

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

        val fileOne = File(soundFiles[0])
        if(fileOne.exists()){
            soundOneColor.set(emeraldGreenColor.get())
            soundOneText.set(playText.get())
        }else {
            soundOneColor.set(whiteColor.get())
            soundOneText.set(recordText.get())
        }

        val fileTwo = File(soundFiles[1])
        if(fileTwo.exists()){
            soundTwoColor.set(emeraldGreenColor.get())
            soundTwoText.set(playText.get())
        } else {
            soundTwoColor.set(whiteColor.get())
            soundTwoText.set(recordText.get())
        }
        val fileThree = File(soundFiles[2])
        if(fileThree.exists()){
            soundThreeColor.set(emeraldGreenColor.get())
            soundThreeText.set(playText.get())
        } else {
            soundThreeColor.set(whiteColor.get())
            soundThreeText.set(recordText.get())
        }

        val fileFour = File(soundFiles[3])
        if(fileFour.exists()){
            soundFourColor.set(emeraldGreenColor.get())
            soundFourText.set(playText.get())
        } else {
            soundFourColor.set(whiteColor.get())
            soundFourText.set(recordText.get())
        }
        val fileFive = File(soundFiles[4])
        if(fileFive.exists()){
            soundFiveColor.set(emeraldGreenColor.get())
            soundFiveText.set(playText.get())
        } else {
            soundFiveColor.set(whiteColor.get())
            soundFiveText.set(recordText.get())
        }
        val fileSix = File(soundFiles[5])
        if(fileSix.exists()){
            soundSixColor.set(emeraldGreenColor.get())
            soundSixText.set(playText.get())
        } else {
            soundSixColor.set(whiteColor.get())
            soundSixText.set(recordText.get())
        }
        val fileSeven = File(soundFiles[6])
        if(fileSeven.exists()){
            soundSevenColor.set(emeraldGreenColor.get())
            soundSevenText.set(playText.get())
        } else {
            soundSevenColor.set(whiteColor.get())
            soundSevenText.set(recordText.get())
        }
        val fileEight = File(soundFiles[7])
        if(fileEight.exists()){
            soundEightColor.set(emeraldGreenColor.get())
            soundEightText.set(playText.get())
        } else {
            soundEightColor.set(whiteColor.get())
            soundEightText.set(recordText.get())
        }
        val fileNine = File(soundFiles[8])
        if(fileNine.exists()){
            soundNineColor.set(emeraldGreenColor.get())
            soundNineText.set(playText.get())
        } else {
            soundNineColor.set(whiteColor.get())
            soundNineText.set(recordText.get())
        }
        val fileTen = File(soundFiles[9])
        if(fileTen.exists()){
            soundTenColor.set(emeraldGreenColor.get())
            soundTenText.set(playText.get())
        } else {
            soundTenColor.set(whiteColor.get())
            soundTenText.set(recordText.get())
        }
        val fileEleven = File(soundFiles[10])
        if(fileEleven.exists()){
            soundElevenColor.set(emeraldGreenColor.get())
            soundElevenText.set(playText.get())
        } else {
            soundElevenColor.set(whiteColor.get())
            soundElevenText.set(recordText.get())
        }
        val fileTwelve = File(soundFiles[11])
        if(fileTwelve.exists()){
            soundTwelveColor.set(emeraldGreenColor.get())
            soundTwelveText.set(playText.get())
        } else {
            soundTwelveColor.set(whiteColor.get())
            soundTwelveText.set(recordText.get())
        }
        val fileThirteen = File(soundFiles[12])
        if(fileThirteen.exists()){
            soundThirteenColor.set(emeraldGreenColor.get())
            soundThirteenText.set(playText.get())
        } else {
            soundThirteenColor.set(whiteColor.get())
            soundThirteenText.set(recordText.get())
        }
        val fileFourteen = File(soundFiles[13])
        if(fileFourteen.exists()){
            soundFourteenColor.set(emeraldGreenColor.get())
            soundFourteenText.set(playText.get())
        } else {
            soundFourteenColor.set(whiteColor.get())
            soundFourteenText.set(recordText.get())
        }
        val fileFifteen = File(soundFiles[14])
        if(fileFifteen.exists()){
            soundFifteenColor.set(emeraldGreenColor.get())
            soundFifteenText.set(playText.get())
        } else {
            soundFifteenColor.set(whiteColor.get())
            soundFifteenText.set(recordText.get())
        }
        val fileSixteen = File(soundFiles[15])
        if(fileSixteen.exists()){
            soundSixteenColor.set(emeraldGreenColor.get())
            soundSixteenText.set(playText.get())
        } else {
            soundSixteenColor.set(whiteColor.get())
            soundSixteenText.set(recordText.get())
        }
        val fileSeventeen = File(soundFiles[16])
        if(fileSeventeen.exists()){
            soundSeventeenColor.set(emeraldGreenColor.get())
            soundSeventeenText.set(playText.get())
        } else {
            soundSeventeenColor.set(whiteColor.get())
            soundSeventeenText.set(recordText.get())
        }
        val fileEighteen = File(soundFiles[17])
        if(fileEighteen.exists()){
            soundEighteenColor.set(emeraldGreenColor.get())
            soundEighteenText.set(playText.get())
        } else {
            soundEighteenColor.set(whiteColor.get())
            soundEighteenText.set(recordText.get())
        }
        val fileNineteen = File(soundFiles[18])
        if(fileNineteen.exists()){
            soundNineteenColor.set(emeraldGreenColor.get())
            soundNineteenText.set(playText.get())
        } else {
            soundNineteenColor.set(whiteColor.get())
            soundNineteenText.set(recordText.get())
        }
        val fileTwenty = File(soundFiles[19])
        if(fileTwenty.exists()){
            soundTwentyColor.set(emeraldGreenColor.get())
            soundTwentyText.set(playText.get())
        } else {
            soundTwentyColor.set(whiteColor.get())
            soundTwentyText.set(recordText.get())
        }
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
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

            } catch (_: IOException) {
                Toast.makeText(getApp(), "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        playerTwenty.start()
        playerTwenty.isLooping = true

    }

    private fun deleteAudio(pathName: String){
        val file = File(pathName)
        if(file.exists()){
            file.delete()
        } else {
            Toast.makeText(getApp(), "Could not delete $pathName", Toast.LENGTH_SHORT).show()
        }
    }


}