package com.droid.iotmanager

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridView
import android.widget.Toast
import com.droid.iotmanager.adapters.IOTDevicesAdapter
import com.droid.iotmanager.data.IOTDevice
import com.droid.iotmanager.fragments.AddDeviceFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tb = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(tb)
        val ab = supportActionBar
        ab!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        ab.setDisplayHomeAsUpEnabled(true)
        val gridView : GridView = findViewById(R.id.gridView) as GridView
        gridView.adapter = IOTDevicesAdapter(this@MainActivity, arrayOf(IOTDevice("FAN",R.drawable.fan  ,listOf(Feature.BUTTON,Feature.SLIDER)),
                IOTDevice("FRIDGE",R.drawable.fridge,listOf(Feature.BUTTON, Feature.SLIDER,Feature.TIMER)),IOTDevice("BULB",R.drawable.bulb,listOf(Feature.BUTTON,Feature.SLIDER))))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add -> {
                val fragmentManager : FragmentManager = fragmentManager
                val fragment : Fragment = AddDeviceFragment()
                val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragmentContainer, fragment).addToBackStack("addFragment").commit()
                findViewById(R.id.fragmentContainer).visibility = View.VISIBLE
                return true
            }
            android.R.id.home -> {
                showToast("Navigation functionality is coming soon :-)")
                return true
            }
            else -> {
                showToast("Interested in adding new features to the app? Then fork the code at : https://github.com/chdeshmanth/IOTManager")
                return false
            }
        }
    }

    fun showToast(text : String){
        Toast.makeText(this@MainActivity,text,Toast.LENGTH_LONG).show()
    }

}
