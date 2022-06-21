package com.eko.mvp_test.login.model.view.presenter.view

interface ILoginView {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onUpdateLoginResultUserInfo(nickname: String, age:Int)
}