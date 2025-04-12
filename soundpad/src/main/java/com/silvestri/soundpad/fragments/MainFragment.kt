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

    private lateinit var binding: MainFragmentLayoutBinding
    private lateinit var currentAudioButton: AppCompatButton
    private var recorder: MediaRecorder? = null
    private var fileName = ""

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
        setupButtons()
        setupViews()

    }


    private fun setupViews(){
        binding.recordingInProgressScreen.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setupButtons(){

        binding.stopRecordingButton.setOnClickListener {
            stopAudio(currentAudioButton)
        }

        binding.soundOne.setOnClickListener {
            if(binding.soundOne.text == context?.getString(R.string.record)){
                //record an audio file
                fileName = "${activity?.externalCacheDir?.absolutePath}/soundOne.3gp"
                showRecordScreenCountdown(pathName = fileName, button = binding.soundOne)

            } else {
                //play an audio file
                fileName = "${activity?.externalCacheDir?.absolutePath}/soundOne.3gp"
                playAudio(pathName = fileName)
            }
        }
        binding.soundTwo.setOnClickListener {

            deleteAudio(fileName)
//            if(binding.soundTwo.text == context?.getString(R.string.record)){
//                //record an audio file
//            } else {
//                //play an audio file
//            }

        }
        binding.soundThree.setOnClickListener {
            if(binding.soundThree.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundFour.setOnClickListener {
            if(binding.soundFour.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundFive.setOnClickListener {
            if(binding.soundFive.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundSix.setOnClickListener {
            if(binding.soundSix.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundSeven.setOnClickListener {
            if(binding.soundSeven.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundEight.setOnClickListener {
            if(binding.soundEight.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundNine.setOnClickListener {
            if(binding.soundNine.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundTen.setOnClickListener {
            if(binding.soundTen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundEleven.setOnClickListener {
            if(binding.soundEleven.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundTwelve.setOnClickListener {
            if(binding.soundTwelve.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundThirteen.setOnClickListener {
            if(binding.soundThirteen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundFourteen.setOnClickListener {
            if(binding.soundFourteen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundFifteen.setOnClickListener {
            if(binding.soundFifteen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundSixteen.setOnClickListener {
            if(binding.soundSixteen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundSeventeen.setOnClickListener {
            if(binding.soundSeventeen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundEighteen.setOnClickListener {
            if(binding.soundOne.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundNineteen.setOnClickListener {
            if(binding.soundNineteen.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
        binding.soundTwenty.setOnClickListener {
            if(binding.soundTwenty.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.S)
    private fun startRecording(pathName: String) {
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

    private fun playAudio(pathName: String) {
        val player = MediaPlayer().apply {
            try {
                setDataSource(pathName)
                prepare()

            } catch (e: IOException) {
                Toast.makeText(context, "Could not load audio name $pathName", Toast.LENGTH_SHORT).show()
            }
        }

        player.start()
        player.isLooping = true

    }

    private fun stopAudio(button: AppCompatButton) {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
        binding.recordingInProgressScreen.visibility = View.GONE
        binding.mainLayoutGroup.isEnabled = true
        changeButtonStyleToAudioFilled(button)
    }

    private fun changeButtonStyleToAudioFilled(button: AppCompatButton) {
        button.text = context?.getString(R.string.play)
        context?.getColor(R.color.emeraldGreen)?.let { button.setBackgroundColor(it) }
    }

    private fun showRecordScreenCountdown(pathName: String, button: AppCompatButton){
        binding.recordingInProgressScreen.visibility = View.VISIBLE
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

//
    private fun deleteAudio(pathName: String){
        val file = File(pathName)
        if(file.exists()){
            file.delete()
        } else {
            Toast.makeText(context, "Could not delete $pathName", Toast.LENGTH_SHORT).show()
        }
    }
}