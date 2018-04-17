package ru.anvics.baseproject.presentation.presenters

import ru.anvics.baseproject.data.ExampleRepository
import ru.anvics.baseproject.domain.ExampleEntity
import ru.anvics.baseproject.domain.interactors.BaseObserver
import ru.anvics.baseproject.domain.interactors.GetEntityById
import ru.anvics.baseproject.presentation.views.ExampleView

class ExamplePresenter : BasePresenter<ExampleView>() {
    private val getEntityById = GetEntityById(ExampleRepository)

    fun getEntityById(id: Long) {
        getEntityById.setId(id)
        getEntityById.execute(GetEntityObserver())

//        Так же можно сделать выполнение с использованием лямбд
//        getEntityById.execute({/* onNext */ t -> view?.setEntity(t) }, { /* onError */ }, { /* onComplete */ })
    }

    override fun destroy() {
        getEntityById.dispose()
    }

    inner class GetEntityObserver : BaseObserver<ExampleEntity>() {
        override fun onNext(t: ExampleEntity) {
            view?.setEntity(t)
        }
    }

}