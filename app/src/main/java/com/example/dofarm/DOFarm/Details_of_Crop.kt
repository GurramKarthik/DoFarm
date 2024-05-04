package com.example.dofarm.DOFarm

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.dofarm.databinding.ActivityDetailsOfCropBinding

import java.util.Calendar


class Details_of_Crop : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityDetailsOfCropBinding

    var presentDay = 0
    var presentMonth = 0
    var presentyear = 0
    var presentMin =0
    var presentHour =0


    var selectedDay = 0
    var selectedMonth = 0
    var selectedyear = 0
    var selectedHour =0
    var selectedMin =0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsOfCropBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var array = arrayOf("Cents", "Hectors", "Acres")

        var implementation = Intent(this, Implementation::class.java)

        binding.acreSpinner.adapter  =
            ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, array)

        binding.plantbtn.setOnClickListener {
            startActivity(implementation)
//            Toast.makeText(this, "${binding.landEdtTxt.text}" , Toast.LENGTH_SHORT).show()
        }

        binding.calender.setOnClickListener {
            getCurrentDate()
            DatePickerDialog(this, this, presentyear, presentMonth, presentDay).show()
        }


    }


    fun getCurrentDate(){
        var calender = Calendar.getInstance()
        presentDay = calender.get(Calendar.DAY_OF_MONTH)
        presentMonth = calender.get(Calendar.MONTH)
        presentyear = calender.get(Calendar.YEAR)
    }

    fun getCurrentTime(){
        var calender = Calendar.getInstance()
        presentHour = calender.get(Calendar.HOUR_OF_DAY)
        presentMin = calender.get(Calendar.MINUTE)
    }


    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        selectedyear = year
        selectedMonth = month
        selectedDay = day
        getCurrentTime()
        TimePickerDialog(this, this, presentHour, presentMin , false).show()
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, min: Int) {
        selectedHour = hour
        selectedMin = min
        binding.StartDate.setText("${selectedDay}-${selectedMonth}-${selectedyear}:: ${selectedHour} - ${selectedMin}")

    }



}