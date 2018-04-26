package ru.anvics.baseproject.presentation.presenters

import ru.anvics.baseproject.presentation.views.iviews.BaseView

abstract class BasePresenter<V : BaseView> {
    protected var view: V? = null

    open fun attachView(view: V) {
        this.view = view
    }

    open fun destroy() {}
}