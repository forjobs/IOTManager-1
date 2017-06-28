package com.droid.iotmanager.fragments

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.droid.iotmanager.R

class AddDeviceFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view:View = inflater.inflate(R.layout.add_device, container, false)
        val cancelButton:Button = view.findViewById(R.id.cancelButton) as Button
        cancelButton.setOnClickListener({
            activity.findViewById(R.id.fragmentContainer).visibility = View.GONE
            activity.fragmentManager.popBackStack("addFragment",FragmentManager.POP_BACK_STACK_INCLUSIVE)
        })
        return view
    }
}