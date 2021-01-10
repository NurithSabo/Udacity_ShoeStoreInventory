package com.udacity.shoestore.Destinations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController()
    }

    private fun setupActionBarWithNavController() {
        val appBarConfiguration = AppBarConfiguration
                .Builder(R.id.login_fragment ,R.id.welcome , R.id.instructionsFragment ,  R.id.shoe_list_layout)
                .build()

        //navController = this.findNavController(R.id.nav_host_fragment)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}