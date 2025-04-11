package com.silvestri.soundpad.fragments

import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.R
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MainFragment: Fragment(R.layout.main_fragment_layout) {

    private lateinit var binding: MainFragmentLayoutBinding

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
        binding.soundOne.setOnClickListener {
            if(binding.soundOne.text == context?.getString(R.string.record)){
                //record an audio file
                record(pathName = "soundOne")
            } else {
                //play an audio file
            }
        }
        binding.soundTwo.setOnClickListener {
            if(binding.soundTwo.text == context?.getString(R.string.record)){
                //record an audio file
            } else {
                //play an audio file
            }
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

    fun saveRecordedAudio(inputStream: InputStream, fileName: String) {
        val outputStream: OutputStream = FileOutputStream(fileName)

        val buffer = ByteArray(1024)
        var read: Int
        var total: Long = 0
        while (inputStream.read(buffer).also { read = it } != -1) {
            outputStream.write(buffer, 0, read)
            total += read.toLong()
        }

        inputStream.close()
        outputStream.close()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun record(pathName: String){
        val recorder = context?.let { MediaRecorder(it) }
        recorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        recorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        recorder?.setOutputFile(pathName)
        recorder?.prepare()
        recorder?.start()   // Recording is now started
        recorder?.stop()
        recorder?.reset()   // You can reuse the object by going back to setAudioSource() step
        recorder?.release()
    }

    fun recordAudio(filePath: String){
        val mediaRecorder = (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            context?.let { MediaRecorder(it) }
        } else {
            MediaRecorder()
        })?.apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(filePath)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {

            }

            start()
        }
    }
}