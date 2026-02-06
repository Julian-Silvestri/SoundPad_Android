package com.silvestri.soundpad.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.silvestri.soundpad.R
import com.silvestri.soundpad.databinding.DeleteRecordingsLayoutBinding

class DeleteRecordingsFragment: Fragment(R.layout.delete_recordings_layout) {

    private lateinit var binding: DeleteRecordingsLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DeleteRecordingsLayoutBinding.bind(view)
    }


}