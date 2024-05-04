package com.example.dofarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.dofarm.Cart.MyCart_Host
import com.example.dofarm.DOFarm.DoFarm
import com.example.dofarm.RecyclerViews.swipeCards
import com.example.dofarm.SellCrops.Sell_crops
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar

class HomeScreen : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar : MaterialToolbar
    lateinit var bottombar: BottomNavigationView
    private lateinit var navigation: DrawerLayout
    private lateinit var calen :Calendar
    private lateinit var picker:MaterialTimePicker
    lateinit var alarmManager: AlarmManager
    lateinit var pendingIntent : PendingIntent





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        toolBar(this)

        navigation = findViewById(R.id.drawer_layout)
        calen = Calendar.getInstance()


        navigationDrawer(this)

        createNotificationChannel()


        val dofarmbtn = findViewById<CardView>(R.id.doformbtn)
        val sellformbtn = findViewById<CardView>(R.id.sellcropbtn)
        val marketpricebtn = findViewById<CardView>(R.id.marketpricebtn)



        dofarmbtn.setOnClickListener {
            val doformIntent = Intent(this@HomeScreen, DoFarm::class.java)
            startActivity(doformIntent)
        }


        sellformbtn.setOnClickListener {
            val sellCropIntent = Intent(this, Sell_crops::class.java)
            startActivity(sellCropIntent)
        }

        marketpricebtn.setOnClickListener {
            val market = Intent(this, MarketPrice::class.java)
            startActivity(market)
        }

        var swipeImages = listOf<Int>(
            R.drawable.app_icon,
            R.drawable.dofarm,
            R.drawable.crop_img,
            R.drawable.marketprice,
        )

        var swipeViewPage = findViewById<ViewPager2>(R.id.swipeViewPage)

        var adapoter = swipeCards(this, swipeImages)
        swipeViewPage.adapter = adapoter



        bottomBar(this)

    }


    fun toolBar(context: Context){
        toolbar = findViewById(R.id.toolBar)
        toolbar.setOnMenuItemClickListener {
                menuItem ->
            when(menuItem.itemId){
                R.id.profile -> {

                    val profile = ProfileDialog()
                    profile.show(supportFragmentManager, "ProfileDialog")
                    true
                }

                R.id.login ->{
                    val login  = Intent(this, LoginScreen::class.java)
                    startActivity(login)

                    false

                }

                else -> {
                    false
                }


            }

        }

    }
    fun navigationDrawer(context: Context){

        val navDrawer = findViewById<NavigationView>(R.id.navigation_drawer)
        navDrawer.setNavigationItemSelectedListener(this)

        val toogle = ActionBarDrawerToggle(this, navigation, toolbar,0,0)
        navigation.addDrawerListener(toogle)
        toogle.syncState()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile ->  {
                val profile = ProfileDialog()
                profile.show(supportFragmentManager, "ProfileDialog")
            }
            R.id.feedback -> {
                    var feedback = Intent(this, feedBack::class.java)
                    startActivity(feedback)
            }
            R.id.aboutUs ->{
                    Toast.makeText(this, "This is about us", Toast.LENGTH_SHORT).show()
            }
            R.id.setting ->{
                Toast.makeText(this, "This is setting", Toast.LENGTH_SHORT).show()
            }
            R.id.alarm -> {
//                showTimePicker()
                var ReminderNotification = Intent(this, ReminderNotification::class.java)
                startActivity(ReminderNotification)

            }

        }
        navigation.closeDrawer(GravityCompat.START)
        return true
    }


    @SuppressLint("SuspiciousIndentation")
    fun bottomBar(context : Context){
        bottombar = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottombar.selectedItemId = R.id.home
            bottombar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    true
                }

                R.id.cart -> {
                    var cart = Intent(this, MyCart_Host::class.java)
                    startActivity(cart)
                    true
                }

                R.id.myplants -> {

                    var myplants = Intent(this, My_Plants::class.java)
                    startActivity(myplants)
                    true
                }
                else -> {
                    true
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
        bottombar.selectedItemId = R.id.home
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (navigation.isDrawerOpen(GravityCompat.START)){
            navigation.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "checkalarm"
            val description = "Check For Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("checkalarm", name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }

    }


    fun showTimePicker(){
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(supportFragmentManager, "checkalarm")

        picker.addOnPositiveButtonClickListener {

            calen[Calendar.HOUR_OF_DAY] = picker.hour
            calen[Calendar.MINUTE] = picker.minute
            calen[Calendar.SECOND] = 0
            calen[Calendar.MILLISECOND] = 0


            setAlarm(picker.hour,picker.minute)


        }


    }


    fun setAlarm(hour:Int, min:Int ){
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmRecevier::class.java)
        pendingIntent = PendingIntent.getBroadcast(this,0,  intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calen.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

        Toast.makeText(this,"Alarm set sucessfully at ${hour}:${min}", Toast.LENGTH_SHORT).show()
    }




}
