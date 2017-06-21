package com.droid.iotmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import com.droid.iotmanager.adapters.IOTDevicesAdapter
import com.droid.iotmanager.data.IOTDevice


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
                showToast("Add functionality is coming very soon.Till then take a look at the other new cool features!!!")
                return true
            }
            android.R.id.home -> {
                showToast("Navigation functionality is coming soon :-)")
                return true
            }
            else -> {
                showToast("Hacking the toolbar")
                return false
            }
        }
    }

    fun showToast(text : String){
        Toast.makeText(this@MainActivity,text,Toast.LENGTH_LONG).show()
    }

}
