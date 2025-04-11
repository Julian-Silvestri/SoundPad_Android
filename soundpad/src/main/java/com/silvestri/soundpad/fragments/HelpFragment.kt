package com.silvestri.soundpad.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.R
import com.silvestri.soundpad.databinding.HelpFragmentLayoutBinding

class HelpFragment: Fragment(R.layout.help_fragment_layout) {

    private lateinit var binding: HelpFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HelpFragmentLayoutBinding.bind(view)
    }
}