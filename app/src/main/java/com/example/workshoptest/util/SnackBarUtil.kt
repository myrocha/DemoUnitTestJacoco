package com.example.workshoptest.util

import android.support.design.widget.Snackbar
import android.view.View

object SnackBarUtil {

    fun showSnackBar(message : String, parentView : View){
        Snackbar.make(parentView, message, Snackbar.LENGTH_LONG).show()

    }


}