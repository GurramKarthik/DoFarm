package com.example.dofarm

import android.content.Context
import android.content.Intent
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
import com.example.dofarm.DataClass.ProfileFlag


class Login : Fragment(){

    lateinit var flag : LoginRegester
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var layout = inflater.inflate(R.layout.fragment_login, container, false)
        flag = activity as LoginRegester

        sharedPreferences = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)


        layout.findViewById<TextView>(R.id.newSignIn).setOnClickListener {
            flag.logRegFlag(false)
        }

        var phoneInput = layout.findViewById<EditText>(R.id.loginPhone)
        var passwordInput = layout.findViewById<EditText>(R.id.LoginPassword)

        layout.findViewById<Button>(R.id.loginbtn).setOnClickListener {
            var phone = phoneInput.text.toString()
            var password = passwordInput.text.toString()

            if(phone.isNotBlank() && password.isNotBlank()){
                validateCredentials(phone,password)
            }else{
                Toast.makeText(requireActivity(),"Enter the credentials",Toast.LENGTH_SHORT).show()
            }
        }
        return layout
    }

    private fun validateCredentials(phone: String, password: String) {
        val storedPhone = sharedPreferences.getString("userPhone", "")
        val storedPassword = sharedPreferences.getString("userPassword", "")



        if (phone.equals(storedPhone) && password.equals(storedPassword)) {
            // Login successful!
            val intent = Intent(requireActivity(), HomeScreen::class.java)
            startActivity(intent)
            requireActivity().finish()
            // details to show on profile
            ProfileFlag.profile_flag = true

        } else {
            // Login failed
            Toast.makeText(requireActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }

}