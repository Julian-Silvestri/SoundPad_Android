package com.silvestri.soundpad.models

import android.app.Application
import android.media.AudioAttributes
import android.media.MediaRecorder
import android.media.SoundPool
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

    var stopRecordingButtonTextId = ObservableField(0)
    var recordTextId = ObservableField(0)
    var recordingTextId = ObservableField(0)
    var playTextId = ObservableField(0)
    var stopTextId = ObservableField(0)

    var recordText = ObservableField("")
    var recordingText = ObservableField("")
    var playText = ObservableField("")
    var stopText = ObservableField("")
    var stopRecordingButtonText = ObservableField("")

    var orangeColorId = ObservableField(0)
    var whiteColorId = ObservableField(0)
    var emeraldGreenId = ObservableField(0)
    var orangeColor = ObservableField(0)
    var whiteColor= ObservableField(0)
    var emeraldGreen = ObservableField(0)

    private val activeStreamMap = mutableMapOf<Int, Int>()
    private val loadedSoundMap = mutableMapOf<Int, Int>()
    private var soundPool: SoundPool? = null
    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(20)
            .setAudioAttributes(audioAttributes)
            .build()

        setupSoundFiles()
    }

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

    fun getStringResIdValue(id: Int): String {
        return getApp().getString(id)
    }

    fun getColorResIdValue(id: Int): Int {
        return getApp().getColor(id)
    }
    fun setupStringTexts(){
        playText.set(getStringResIdValue(playTextId.get() ?: 0))
        stopText.set(getStringResIdValue(stopTextId.get() ?: 0))
        recordText.set(getStringResIdValue(recordTextId.get() ?: 0))
        recordingText.set(getStringResIdValue(recordingTextId.get() ?: 0))
        stopRecordingButtonText.set(getStringResIdValue(stopRecordingButtonTextId.get() ?: 0))
    }

    fun setupColors(){
        emeraldGreen.set(getColorResIdValue(emeraldGreenId.get() ?: 0))
        whiteColor.set(getColorResIdValue(whiteColorId.get() ?: 0))
        orangeColor.set(getColorResIdValue(orangeColorId.get() ?: 0))
    }

    fun setupPlayButtonSoundStyle(index: Int){
        when (index) {
            0 -> {
                soundOneText.set(playText.get())
                soundOneColor.set(emeraldGreen.get())
            }
            1 -> {
                soundTwoText.set(playText.get())
                soundTwoColor.set(emeraldGreen.get())
            }
            2 -> {
                soundThreeText.set(playText.get())
                soundThreeColor.set(emeraldGreen.get())
            }
            3 -> {
                soundFourText.set(playText.get())
                soundFourColor.set(emeraldGreen.get())
            }
            4 -> {
                soundFiveText.set(playText.get())
                soundFiveColor.set(emeraldGreen.get())
            }
            5 -> {
                soundSixText.set(playText.get())
                soundSixColor.set(emeraldGreen.get())
            }
            6 -> {
                soundSevenText.set(playText.get())
                soundSevenColor.set(emeraldGreen.get())
            }
            7 -> {
                soundEightText.set(playText.get())
                soundEightColor.set(emeraldGreen.get())
            }
            8 -> {
                soundNineText.set(playText.get())
                soundNineColor.set(emeraldGreen.get())
            }
            9 -> {
                soundTenText.set(playText.get())
                soundTenColor.set(emeraldGreen.get())
            }
            10 -> {
                soundElevenText.set(playText.get())
                soundElevenColor.set(emeraldGreen.get())
            }
            11 -> {
                soundTwelveText.set(playText.get())
                soundTwelveColor.set(emeraldGreen.get())
            }
            12 -> {
                soundThirteenText.set(playText.get())
                soundThirteenColor.set(emeraldGreen.get())
            }
            13 -> {
                soundFourteenText.set(playText.get())
                soundFourteenColor.set(emeraldGreen.get())
            }
            14 -> {
                soundFifteenText.set(playText.get())
                soundFifteenColor.set(emeraldGreen.get())
            }
            15 -> {
                soundSixteenText.set(playText.get())
                soundSixteenColor.set(emeraldGreen.get())
            }
            16 -> {
                soundSeventeenText.set(playText.get())
                soundSeventeenColor.set(emeraldGreen.get())
            }
            17 -> {
                soundEighteenText.set(playText.get())
                soundEighteenColor.set(emeraldGreen.get())
            }
            18 -> {
                soundNineteenText.set(playText.get())
                soundNineteenColor.set(emeraldGreen.get())
            }
            19 -> {
                soundTwentyText.set(playText.get())
                soundTwentyColor.set(emeraldGreen.get())
            }
        }
    }
    fun setupRecordButtonSoundStyle(index: Int){
        if(index == 0){
            soundOneText.set(recordText.get())
            soundOneColor.set(whiteColor.get())
        }else if(index == 1){
            soundTwoText.set(recordText.get())
            soundTwoColor.set(whiteColor.get())
        }else if(index == 2){
            soundThreeText.set(recordText.get())
            soundThreeColor.set(whiteColor.get())
        }
        else if(index == 3){
            soundFourText.set(recordText.get())
            soundFourColor.set(whiteColor.get())
        }
        else if(index == 4){
            soundFiveText.set(recordText.get())
            soundFiveColor.set(whiteColor.get())
        }
        else if(index == 5){
            soundSixText.set(recordText.get())
            soundSixColor.set(whiteColor.get())
        }
        else if(index == 6){
            soundSevenText.set(recordText.get())
            soundSevenColor.set(whiteColor.get())
        }
        else if(index == 7){
            soundEightText.set(recordText.get())
            soundEightColor.set(whiteColor.get())
        }
        else if(index == 8){
            soundNineText.set(recordText.get())
            soundNineColor.set(whiteColor.get())
        }
        else if(index == 9){
            soundTenText.set(recordText.get())
            soundTenColor.set(whiteColor.get())
        }
        else if(index == 10){
            soundElevenText.set(recordText.get())
            soundElevenColor.set(whiteColor.get())
        }
        else if(index == 11){
            soundTwelveText.set(recordText.get())
            soundTwelveColor.set(whiteColor.get())
        }
        else if(index == 12){
            soundThirteenText.set(recordText.get())
            soundThirteenColor.set(whiteColor.get())
        }
        else if(index == 13){
            soundFourteenText.set(recordText.get())
            soundFourteenColor.set(whiteColor.get())
        }
        else if(index == 14){
            soundFifteenText.set(recordText.get())
            soundFifteenColor.set(whiteColor.get())
        }
        else if(index == 15){
            soundSixteenText.set(recordText.get())
            soundSixteenColor.set(whiteColor.get())
        }
        else if(index == 16){
            soundSeventeenText.set(recordText.get())
            soundSeventeenColor.set(whiteColor.get())
        }
        else if(index == 17){
            soundEighteenText.set(recordText.get())
            soundEighteenColor.set(whiteColor.get())
        }
        else if(index == 18){
            soundNineteenText.set(recordText.get())
            soundNineteenColor.set(whiteColor.get())
        }
        else if(index == 19){
            soundTwentyText.set(recordText.get())
            soundTwentyColor.set(whiteColor.get())
        }
    }

    fun setupSoundButtonStyles(soundFiles: Array<String>){
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
    fun setupSoundPaths() {
        soundOne = "${getApp().externalCacheDir?.absolutePath}/soundOne.3gp"
        soundTwo = "${getApp().externalCacheDir?.absolutePath}/soundTwo.3gp"
        soundThree = "${getApp().externalCacheDir?.absolutePath}/soundThree.3gp"
        soundFour = "${getApp().externalCacheDir?.absolutePath}/soundFour.3gp"
        soundFive = "${getApp().externalCacheDir?.absolutePath}/soundFive.3gp"
        soundSix = "${getApp().externalCacheDir?.absolutePath}/soundSix.3gp"
        soundSeven = "${getApp().externalCacheDir?.absolutePath}/soundSeven.3gp"
        soundEight = "${getApp().externalCacheDir?.absolutePath}/soundEight.3gp"
        soundNine = "${getApp().externalCacheDir?.absolutePath}/soundNine.3gp"
        soundTen = "${getApp().externalCacheDir?.absolutePath}/soundTen.3gp"
        soundEleven = "${getApp().externalCacheDir?.absolutePath}/soundEleven.3gp"
        soundTwelve = "${getApp().externalCacheDir?.absolutePath}/soundTwelve.3gp"
        soundThirteen = "${getApp().externalCacheDir?.absolutePath}/soundThirteen.3gp"
        soundFourteen = "${getApp().externalCacheDir?.absolutePath}/soundFourteen.3gp"
        soundFifteen = "${getApp().externalCacheDir?.absolutePath}/soundFifteen.3gp"
        soundSixteen = "${getApp().externalCacheDir?.absolutePath}/soundSixteen.3gp"
        soundSeventeen = "${getApp().externalCacheDir?.absolutePath}/soundSeventeen.3gp"
        soundEighteen = "${getApp().externalCacheDir?.absolutePath}/soundEighteen.3gp"
        soundNineteen = "${getApp().externalCacheDir?.absolutePath}/soundNineteen.3gp"
        soundTwenty = "${getApp().externalCacheDir?.absolutePath}/soundTwenty.3gp"
        setupSoundFiles()
        setupSoundButtonStyles(soundFiles = soundFiles)
    }
    @RequiresApi(Build.VERSION_CODES.S)
    fun soundOneClick(){
        if(soundOneText.get() == recordText.get()){
            //record an audio file
            showRecordScreenCountdown(pathName = soundFiles[0], button = 0)
        } else {
            //play an audio file
            if(isStreamActive(0)){
                stopSound(0)
                soundOneColor.set(emeraldGreen.get())
                soundOneText.set(playText.get())
            } else {
                playSound(0,pathName = soundFiles[0])
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
            if(isStreamActive(1)){
                stopSound(1)
                soundTwoColor.set(emeraldGreen.get())
                soundTwoText.set(playText.get())
            } else {
                playSound(1,pathName = soundFiles[1])
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
            if(isStreamActive(2)){
                stopSound(2)
                soundThreeColor.set(emeraldGreen.get())
                soundThreeText.set(playText.get())
            } else {
                playSound(2,pathName = soundFiles[2])
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
            if(isStreamActive(3)){
                stopSound(3)
                soundFourColor.set(emeraldGreen.get())
                soundFourText.set(playText.get())
            } else {
                playSound(3,pathName = soundFiles[3])
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
            if(isStreamActive(4)){
                stopSound(4)
                soundFiveColor.set(emeraldGreen.get())
                soundFiveText.set(playText.get())
            } else {
                playSound(4,pathName = soundFiles[4])
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
            if(isStreamActive(5)){
                stopSound(5)
                soundSixColor.set(emeraldGreen.get())
                soundSixText.set(playText.get())
            } else {
                playSound(5,pathName = soundFiles[5])
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
            if(isStreamActive(6)){
                stopSound(6)
                soundSevenColor.set(emeraldGreen.get())
                soundSevenText.set(playText.get())
            } else {
                playSound(6,pathName = soundFiles[6])
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
            if(isStreamActive(7)){
                stopSound(7)
                soundEightColor.set(emeraldGreen.get())
                soundEightText.set(playText.get())
            } else {
                playSound(7,pathName = soundFiles[7])
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
            if(isStreamActive(8)){
                stopSound(8)
                soundNineColor.set(emeraldGreen.get())
                soundNineText.set(playText.get())
            } else {
                playSound(8,pathName = soundFiles[8])
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
            if(isStreamActive(9)){
                stopSound(9)
                soundTenColor.set(emeraldGreen.get())
                soundTenText.set(playText.get())
            } else {
                playSound(9,pathName = soundFiles[9])
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
            if(isStreamActive(10)){
                stopSound(10)
                soundElevenColor.set(emeraldGreen.get())
                soundElevenText.set(playText.get())
            } else {
                playSound(10,pathName = soundFiles[10])
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
            if(isStreamActive(11)){
                stopSound(11)
                soundTwelveColor.set(emeraldGreen.get())
                soundTwelveText.set(playText.get())
            } else {
                playSound(11,pathName = soundFiles[11])
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
            if(isStreamActive(12)){
                stopSound(12)
                soundThirteenColor.set(emeraldGreen.get())
                soundThirteenText.set(playText.get())
            } else {
                playSound(12,pathName = soundFiles[12])
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
            if(isStreamActive(13)){
                stopSound(13)
                soundFourteenColor.set(emeraldGreen.get())
                soundFourteenText.set(playText.get())
            } else {
                playSound(13,pathName = soundFiles[13])
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
            if(isStreamActive(14)){
                stopSound(14)
                soundFifteenColor.set(emeraldGreen.get())
                soundFifteenText.set(playText.get())
            } else {
                playSound(14,pathName = soundFiles[14])
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
            if(isStreamActive(15)){
                stopSound(15)
                soundSixteenColor.set(emeraldGreen.get())
                soundSixteenText.set(playText.get())
            } else {
                playSound(15,pathName = soundFiles[15])
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
            if(isStreamActive(16)){
                stopSound(16)
                soundSeventeenColor.set(emeraldGreen.get())
                soundSeventeenText.set(playText.get())
            } else {
                playSound(16,pathName = soundFiles[16])
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
            if(isStreamActive(17)){
                stopSound(17)
                soundEighteenColor.set(emeraldGreen.get())
                soundEighteenText.set(playText.get())
            } else {
                playSound(17,pathName = soundFiles[17])
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
            if(isStreamActive(18)){
                stopSound(18)
                soundNineteenColor.set(emeraldGreen.get())
                soundNineteenText.set(playText.get())
            } else {
                playSound(18,pathName = soundFiles[18])
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
            if(isStreamActive(19)){
                stopSound(19)
                soundTwentyColor.set(emeraldGreen.get())
                soundTwentyText.set(playText.get())
            } else {
                playSound(index = 19, pathName = soundFiles[19])
                soundTwentyColor.set(orangeColor.get())
                soundTwentyText.set(stopText.get())
            }

        }
    }

    fun showRecordScreenCountdown(pathName: String, button:Int){
//        stopAllAudioPlayers()
        disableAllButtons()
        recordingInProgressVisibility.set(true)
        stopRecordingButtonEnabled.set(false)
        mainLayoutVisibility.set(false)
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
                stopRecordingButtonText.set(stopRecordingButtonText.get())
                startRecording(pathName)
            }
        }
        timer.start()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun startRecording(pathName: String) {
        stopRecordingButtonEnabled.set(true)
        stopAllSounds()
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
                }

                start()
            }

    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun stopRecording() {
        stopRecordingButtonEnabled.set(false)
        recordingInProgressVisibility.set(false)
        mainLayoutVisibility.set(true)
        recorder?.stop()
        enableAllButtons()
        setupSoundPaths()
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

    private fun playSound(index: Int, pathName: String) {
        val soundId = loadedSoundMap[index]

        if (soundId != null) {
            activeStreamMap[index]?.let { soundPool?.stop(it) }

            val streamId = soundPool?.play(soundId, 1f, 1f, 1, 0, 1f) ?: 0

            activeStreamMap[index] = streamId
        } else {
            val newSoundId = soundPool?.load(pathName, 1) ?: return
            loadedSoundMap[index] = newSoundId

            soundPool?.setOnLoadCompleteListener { pool, id, status ->
                if (status == 0 && id == newSoundId) {
                    val streamId = pool.play(id, 1f, 1f, 1, -1, 1f)
                    activeStreamMap[index] = streamId
                }
            }
        }
    }

    fun stopSound(index: Int) {
        activeStreamMap[index]?.let { streamId ->
            soundPool?.stop(streamId)
            activeStreamMap.remove(index)
        }
    }

    fun stopAllSounds(){
        for (streamId in activeStreamMap.values) {
            soundPool?.stop(streamId)
        }
    }

    fun isStreamActive(index: Int): Boolean {
        return activeStreamMap.containsKey(index)
    }

    fun deleteAudioFile(pathName: String){
        val file = File(pathName)
        if(file.exists()){
            file.delete()
        } else {
            Toast.makeText(getApp(), "Could not delete $pathName", Toast.LENGTH_SHORT).show()
        }
    }
    fun deleteAllAudioFiles(){
        for(value in soundFiles){
            val file = File(value)
            if(file.exists()){
                file.delete()
            } else {
                Toast.makeText(getApp(), "Could not delete $value", Toast.LENGTH_SHORT).show()
            }
        }

    }
}