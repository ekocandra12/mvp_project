package com.eko.mvp_test.login.model.view.presenter.presenter

import android.util.Log
import com.eko.mvp_test.framework.util.thread.ThreadUtil
import com.eko.mvp_test.login.model.view.presenter.model.UserInfoModel
import com.eko.mvp_test.login.model.view.presenter.presenter.controller.LoginController
import com.eko.mvp_test.login.model.view.presenter.view.ILoginView

class LoginPresenter(var iloginview: ILoginView): ILoginPresenter {
    override fun onClear() {
        iloginview.onClear()
    }

    override fun onShowProgress() {
        iloginview.onShowProgress()
    }

    override fun onHideProgress() {
        iloginview.onHideProgress()
    }

    override fun login(id: String, password: String) {

        onShowProgress()
        LoginController.requestLogin(id=id, password=password,object :LoginController.LoginControllerDelegate{
            override fun onSuccess(response: String) {
                Log.d("???", "onSuccess $response")

                val userInfoModel=UserInfoModel()
                userInfoModel.nickname="eko candra"
                userInfoModel.age=21

                ThreadUtil.startUIThread(0){
                    onHideProgress()

                    iloginview.onUpdateLoginResultUserInfo(nickname = userInfoModel.nickname, age=userInfoModel.age)
                }
            }

            override fun onFailed() {
                Log.d("???", "onFailed")
            }
        })
    }
}