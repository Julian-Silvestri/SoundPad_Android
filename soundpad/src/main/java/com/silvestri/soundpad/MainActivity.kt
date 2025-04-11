package com.silvestri.soundpad

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.fragments.MainFragment

class MainActivity: AppCompatActivity() {
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        launchMainFragment()
        askPermissionFirst()
    }

    private fun askPermissionFirst(){
//        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION)

    }

    private fun launchMainFragment(){
        val fragment: Fragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_layout, fragment)
            .addToBackStack(null).commit()

    }

//    private fun requestAudioPermissions() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.RECORD_AUDIO
//            )
//            != PackageManager.PERMISSION_GRANTED
//        ) {
//            //When permission is not granted by user, show them message why this permission is needed.
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(
//                    this,
//                    Manifest.permission.RECORD_AUDIO
//                )
//            ) {
//                Toast.makeText(this, "Please grant permissions to record audio", Toast.LENGTH_LONG)
//                    .show()
//
//                //Give user option to still opt-in the permissions
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf<String>(Manifest.permission.RECORD_AUDIO),
//                    MY_PERMISSIONS_RECORD_AUDIO
//                )
//            } else {
//                // Show user dialog to grant permission to record audio
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf<String>(Manifest.permission.RECORD_AUDIO),
//                    MY_PERMISSIONS_RECORD_AUDIO
//                )
//            }
//        } else if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.RECORD_AUDIO
//            )
//            == PackageManager.PERMISSION_GRANTED
//        ) {
//            //Go ahead with recording audio now
//
//            recordAudio()
//        }
//    }
//
//    //Handling callback
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String?>?, grantResults: IntArray
//    ) {
//        when (requestCode) {
//            MY_PERMISSIONS_RECORD_AUDIO -> {
//                if (grantResults.size > 0
//                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                ) {
//                    // permission was granted, yay!
//                    recordAudio()
//                } else {
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                    Toast.makeText(this, "Permissions Denied to record audio", Toast.LENGTH_LONG)
//                        .show()
//                }
//                return
//            }
//        }
//    }

}