package ru.anvics.baseproject.presentation.views

interface BaseView{
    fun error(message: String)
    fun showProgress()
    fun hideProgress()
}