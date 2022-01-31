package com.example.qaydlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.qaydlar.Adapters.UserAdapter
import com.example.qaydlar.Db.MyDbHelper
import com.example.qaydlar.Models.User
import com.example.qaydlar.databinding.ActivityMainBinding
import com.example.qaydlar.databinding.ItemRvBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_2.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragg1).navigateUp()

    }

}