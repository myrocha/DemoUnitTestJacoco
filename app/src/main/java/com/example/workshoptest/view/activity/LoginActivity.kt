package com.example.workshoptest.view.activity

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.Button
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.R
import com.example.workshoptest.coroutine.CoroutineProvider

import com.example.workshoptest.repository.RetrofitFactory
import com.example.workshoptest.util.SnackBarUtil
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.example.workshoptest.viewmodel.factory.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import org.koin.android.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    private val tiePassword by bind<TextInputEditText>(R.id.tv_password)
    private val tieEmail by bind<TextInputEditText>(R.id.tv_email)
    private val tilPassword by bind<TextInputLayout>(R.id.txt_password)
    private val tilEmail by bind<TextInputLayout>(R.id.txt_email)
    private val btnLogin by bind<Button>(R.id.btn_login)

    fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
        return lazy { findViewById(res) as T }
    }

    /**
     * variavel é inicialida qdo for referenciada
     */
   /* val model by lazy {

        ViewModelProviders.of(
            this, LoginViewModelFactory(
                LoginRepository(
                    RetrofitFactory.login()
                ), CoroutineProvider()
            )
        ).get(LoginViewlModel::class.java)

    }*/

    val model: LoginViewlModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)
        btnLogin.setOnClickListener { v ->
            model.validate(tiePassword.text.toString(), tieEmail.text.toString()).observe(this, Observer { result ->
                if (result!!) {
                    model.getLogin("12345678A.b", "ana@gmail.com").observe(this, Observer { responseUser ->
                        if (responseUser != null) {
                            startActivity(MainActivity.newIntent(this))
                        }
                    })
                } else {
                    tilEmail.error = getString(R.string.login_error)
                    tilPassword.error = getString(R.string.login_error)
                }
            })
        }
    }

    fun onRegister(view: View) {
        // val intent = RegisterActivity.newIntent(this, "bruce@wayne.com")
        val intent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            SnackBarUtil.showSnackBar(getString(R.string.successful_registration), tieEmail)
        }
    }

}
