package com.eko.mvp_test.login.model.view.presenter.presenter.controller

import com.eko.mvp_test.framework.util.thread.ThreadUtil

object LoginController {
    interface LoginControllerDelegate{
        fun onSuccess(response: String)
        fun onFailed()
    }

    fun requestLogin(id:String, password: String, delegate: LoginControllerDelegate){
        ThreadUtil.startThread{
            Thread.sleep(3000)

            delegate.onSuccess("response from server, user info is a json")
        }
    }
}