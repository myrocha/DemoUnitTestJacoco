package com.example.workshoptest.view.activity

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.workshoptest.R
import com.example.workshoptest.constants.Constants
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.example.workshoptest.viewmodel.RegisterViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class RegisterActivity : AppCompatActivity() {

    private val tieName by bind<TextInputEditText>(R.id.txt_edit_name)
    private val tieCpf by bind<TextInputEditText>(R.id.txt_edit_cpf)
    private val tieEmail by bind<TextInputEditText>(R.id.txt_edit_email)
    private val tiePassword by bind<TextInputEditText>(R.id.txt_edit_password)
    private val tilName by bind<TextInputLayout>(R.id.txt_name)
    private val tilCpf by bind<TextInputLayout>(R.id.txt_cpf)
    private val tilEmail by bind<TextInputLayout>(R.id.txt_email)
    private val tilPassword by bind<TextInputLayout>(R.id.txt_password)


    fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
        return lazy { findViewById(res) as T }
    }

    val model: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onRegister(view: View) {
        model.onRegister(
            tieName.text.toString(), tieCpf.text.toString(),
            tieEmail.text.toString(), tiePassword.text.toString()
        ).observe(this, Observer { result ->
            disableTextError()
            when {
                result == Constants.INVALID_NAME -> {
                    setError(getString(R.string.error_name), tilName)
                }
                result == Constants.INVALID_CPF -> {
                    setError(getString(R.string.error_cpf), tilCpf)
                }
                result == Constants.INVALID_EMAIL -> {
                    setError(getString(R.string.error_email), tilEmail)
                }
                result == Constants.INVALID_PASSWORD -> {
                    setError(getString(R.string.error_password), tilPassword)
                }
                else -> {
                    saveRgister()

                }


                /*   result != 0 -> {
                       Log.i("###", "" + result);
                       showDialogSuccessRegistration()
                   }*/
                /*else -> {
                    Log.i("###", "" + result);
                    // model.saveUser()

                    *//*    val resultIntent = Intent()
                        resultIntent.putExtra("result_register", 1)
                        setResult(Activity.RESULT_OK, resultIntent)
                        finish()*//*

                    showDialogSuccessRegistration()
                }*/
            }
        })
    }

    private fun setError(error: String, textInput: TextInputLayout) {
        textInput.isErrorEnabled = true
        textInput.error = error
    }

    private fun disableTextError() {
        tilName.isErrorEnabled = false
        tilCpf.isErrorEnabled = false
        tilEmail.isErrorEnabled = false
        tilPassword.isErrorEnabled = false
    }

    private fun saveRgister() {
        model.saveUser(
            tieName.text.toString(), tieCpf.text.toString(),
            tieEmail.text.toString(), tiePassword.text.toString()
        ).observe(this, Observer { result ->
            Log.i("###", "RESULT : " + result);
            if (result != 0) showDialogSuccessRegistration()
        })

    }

    private fun showDialogSuccessRegistration() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.successful_registration))
        builder.setPositiveButton(getString(R.string.btn_successful_reistration)) { dialog, which ->
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}