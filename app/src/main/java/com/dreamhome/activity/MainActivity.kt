package com.dreamhome.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.dreamhome.fragment.About
import com.dreamhome.fragment.DashBoard
import com.dreamhome.fragment.Favourite
import com.dreamhome.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navigationView: NavigationView
    lateinit var frameLayout: FrameLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    var previousMenuItem:MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolBar)
        navigationView = findViewById(R.id.navigationView)
        frameLayout = findViewById(R.id.fragment)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)

        setupToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

            when (it.itemId) {
                R.id.home -> {
                   openDashboard()
                    drawerLayout.closeDrawers()
                }
                R.id.fav -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment,
                        Favourite()
                    )
                        .commit()
                    supportActionBar?.title = "Favourite"
                    drawerLayout.closeDrawers()
                }
                R.id.about -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment,
                        About()
                    )
                        .commit()
                    supportActionBar?.title = "About"
                    drawerLayout.closeDrawers()
                }
                R.id.builder_login -> {
                    Toast.makeText(this@MainActivity, "Builder", Toast.LENGTH_SHORT).show()
                }

            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun openDashboard(){
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment,
            DashBoard()
        )
            .commit()
        supportActionBar?.title = "Home"
        drawerLayout.closeDrawers()
        navigationView.setCheckedItem(R.id.home)

    }

    override fun onBackPressed() {

        val frag=supportFragmentManager.findFragmentById(R.id.fragment)
        when(frag){
            !is DashBoard ->openDashboard()
            else->super.onBackPressed()
        }
    }
}
