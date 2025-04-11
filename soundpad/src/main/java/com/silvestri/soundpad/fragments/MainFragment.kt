package com.silvestri.soundpad.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.R
import com.silvestri.soundpad.databinding.MainFragmentLayoutBinding

class MainFragment: Fragment(R.layout.main_fragment_layout) {

    private lateinit var binding: MainFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentLayoutBinding.bind(view)
    }

}