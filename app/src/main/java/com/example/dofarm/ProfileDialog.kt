package com.example.dofarm

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.dofarm.DataClass.ProfileFlag

class ProfileDialog : DialogFragment() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var layout = inflater.inflate(R.layout.profile,container,false)
        var name = layout.findViewById<TextView>(R.id.userName)
        var phone = layout.findViewById<TextView>(R.id.userPhone)
        var email = layout.findViewById<TextView>(R.id.userEmail)

        sharedPreferences = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)

        if(ProfileFlag.profile_flag) {
            name.text = sharedPreferences.getString("username", "")
            phone.text = sharedPreferences.getString("userPhone", "")
            email.text = sharedPreferences.getString("userEmail", "")
        }else{
            name.text = "Name of the User"
            phone.text = "Phone Number"
            email.text = "Email"
        }




        return layout


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

}