package com.silvestri.soundpad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.fragments.MainFragment

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        launchMainFragment()
    }

    private fun launchMainFragment(){
        val fragment: Fragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_layout, fragment)
            .addToBackStack(null).commit()

    }

}