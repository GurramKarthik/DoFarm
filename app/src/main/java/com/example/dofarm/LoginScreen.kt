package com.example.dofarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dofarm.DataClass.LoginRegester

class LoginScreen : AppCompatActivity(), LoginRegester {
    lateinit var fragmentManger : FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)


        var login = Login()
        getFragment(login)



    }


    fun getFragment(fragmnet : Fragment){
        fragmentManger = supportFragmentManager
        fragmentManger.beginTransaction().add(R.id.regLog , fragmnet ).commit()

    }

    override fun logRegFlag(flag: Boolean) {
        if(flag){
            var login = Login()
            getFragment(login)
        }else{
            var reg = RegisterActivity()
            getFragment(reg)
        }
    }


}
