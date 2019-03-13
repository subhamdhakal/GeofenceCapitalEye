package com.example.capitaleyegeofence

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var startDateForPicker = Calendar.getInstance()
    lateinit var geofencingClient: GeofencingClient
    lateinit var preferences: AppPreferences
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        geofencingClient = LocationServices.getGeofencingClient(this)
        preferences = AppPreferences(this)
        linear_layout_birth_date.setOnClickListener {
            showStartDatePicker()
        }
        Log.d(TAG, "username: " + preferences.userName)
        if (preferences.userName != "User") {
            startActivity(Intent(this, MapsActivity::class.java))
            finish()
        }
        button_submit.setOnClickListener {
            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()
            preferences.userName = edit_text_name.text.toString()
            startActivity(Intent(this, MapsActivity::class.java))
            finish()
        }

    }

    fun showStartDatePicker() {
        var calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { p0, p1, p2, p3 ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(p1, p2, p3)
                text_view_birth_date.text = selectedDate.timeInMillis.getFormattedStringFromTimeStamp()
                startDateForPicker.set(p1, p2, p3)
            },
            startDateForPicker!!.get(Calendar.YEAR), startDateForPicker.get(Calendar.MONTH),
            startDateForPicker.get(Calendar.DAY_OF_MONTH)
        )
        dialog.datePicker.maxDate = calendar.timeInMillis
        dialog.show()
    }
}
