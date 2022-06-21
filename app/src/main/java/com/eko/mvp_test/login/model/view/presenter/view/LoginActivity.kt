package com.eko.mvp_test.login.model.view.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.eko.mvp_test.R
import com.eko.mvp_test.login.model.view.presenter.presenter.ILoginPresenter
import com.eko.mvp_test.login.model.view.presenter.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ILoginView {
    
    private lateinit var textViewLoginResultInfo: TextView
    private lateinit var buttonLogin: Button
    private lateinit var editTextID: EditText
    private lateinit var editTextPW: EditText
    private lateinit var frameLayoutProgress: FrameLayout

    lateinit var iLoginPresenter: ILoginPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        findView()
        setListener()
    }

    private fun initPresenter(){
        iLoginPresenter= LoginPresenter(iloginview = this)
    }

    private fun findView() {
        textViewLoginResultInfo = findViewById(R.id.textViewLoginResultInfo)
        buttonLogin = findViewById(R.id.buttonLogin)
        editTextID = findViewById(R.id.editTextID)
        editTextPW = findViewById(R.id.editTextPW)
        frameLayoutProgress = findViewById(R.id.frameLayoutProgress)
        
        
    }
    private fun setListener(){
        buttonLogin.setOnClickListener { 
            iLoginPresenter.login(id = editTextID.text.toString().trim(), password = editTextPW.text.toString().trim())
        }
    }

    override fun onClear() {
        editTextID.setText("")
        editTextPW.setText("")
    }

    override fun onShowProgress() {
        frameLayoutProgress.visibility= View.VISIBLE
    }

    override fun onHideProgress() {
        frameLayoutProgress.visibility= View.GONE
    }

    override fun onUpdateLoginResultUserInfo(nickname: String, age: Int) {
       textViewLoginResultInfo.text="nicname is $nickname, age is $age"
    }
}