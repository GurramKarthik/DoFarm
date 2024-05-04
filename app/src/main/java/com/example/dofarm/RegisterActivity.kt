package com.example.dofarm

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.dofarm.DataClass.LoginRegester


class RegisterActivity : Fragment(){
    lateinit var flag : LoginRegester
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var layout =layoutInflater.inflate(R.layout.fragment_register_activity, container,false)

        flag = activity as LoginRegester

        var NameInput = layout.findViewById<EditText>(R.id.newUser)
        var phoneInput = layout.findViewById<EditText>(R.id.phoneNum)
        var emailInput = layout.findViewById<EditText>(R.id.Email)
        var passwordInput = layout.findViewById<EditText>(R.id.password)
        var registerbtn = layout.findViewById<Button>(R.id.register)

        layout.findViewById<TextView>(R.id.existLogin).setOnClickListener {
            flag.logRegFlag(true)
        }

        sharedPreferences = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)

        registerbtn.setOnClickListener {

            val name = NameInput.text.toString()
            val phone = phoneInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                checkAndRegisterUser(name, phone,email,  password)
                flag.logRegFlag(true)
            } else {
                showToast("Please enter all the details")
            }

        }
        return layout
    }

    private fun checkAndRegisterUser(name:String, phone: String,email:String, password: String) {
        val existingPhone = sharedPreferences.getString("userPhone", "")

        if (existingPhone.equals(phone)  ) {
            showToast("User already exists")
        } else {
            // Register new user
            saveUserData(name,phone,email, password)
            showToast("Registration successful. Please Login")

        }
    }

    private fun showToast(s: String) {
        Toast.makeText(requireActivity(),s, Toast.LENGTH_SHORT).show()
    }
    private fun saveUserData(name:String,phone: String,email:String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", name)
        editor.putString("userPhone", phone)
        editor.putString("userEmail", email)
        editor.putString("userPassword", password)  // Consider hashing for security
        editor.apply()
    }




}