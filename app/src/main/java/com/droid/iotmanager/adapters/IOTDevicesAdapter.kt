package com.droid.iotmanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.droid.iotmanager.R
import com.droid.iotmanager.data.IOTDevice
import com.droid.iotmanager.utils.ViewHolder

class IOTDevicesAdapter(val context : Context, val iotDevices : Array<IOTDevice>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val viewHolder : ViewHolder
        val gridViewElement : View
        if(convertView == null){
            gridViewElement = LayoutInflater.from(context).inflate(R.layout.grid_view_layout, parent, false)
            viewHolder = ViewHolder(gridViewElement.findViewById(R.id.iotDeviceName) as TextView, gridViewElement.findViewById(R.id.iotDeviceImage) as ImageView)
            gridViewElement.tag = viewHolder
        }
        else{
            gridViewElement = convertView
            viewHolder = gridViewElement.tag as ViewHolder
        }
        val iotDevice:  IOTDevice = getItem(position)
        viewHolder.textView.text = iotDevice.name
        viewHolder.imageView.setImageResource(iotDevice.image)
        return gridViewElement
    }

    override fun getItem(position: Int): IOTDevice = iotDevices[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = iotDevices.size

}
