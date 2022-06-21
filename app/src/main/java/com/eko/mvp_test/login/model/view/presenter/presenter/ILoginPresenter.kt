package com.eko.mvp_test.login.model.view.presenter.presenter

interface ILoginPresenter {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun login(id: String, password: String)
}