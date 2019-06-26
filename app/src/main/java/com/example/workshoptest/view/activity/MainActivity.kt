package com.example.workshoptest.view.activity

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.workshoptest.R
import com.example.workshoptest.viewmodel.MainViewModel
import com.example.workshoptest.viewmodel.RegisterViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    val model: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.getAllUsers().observe(this, Observer { result ->
            Log.i("###", "LISTA: " + result?.size);
         })






    }

    companion object {

        fun newIntent(context: Context): Intent {
            var intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    fun getAllUsers(){

    }


}