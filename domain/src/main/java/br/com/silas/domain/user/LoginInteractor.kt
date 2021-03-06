package br.com.silas.domain.user

import br.com.silas.domain.ErrorResponse
import br.com.silas.domain.InteractorSingle
import br.com.silas.domain.Schedulers
import io.reactivex.rxjava3.core.Single

class LoginInteractor(private val loginRepository: LoginRepository, schedulers: Schedulers) :
    InteractorSingle<Pair<User, ErrorResponse>, LoginInteractor.Request>(schedulers) {


    override fun create(request: Request): Single<Pair<User, ErrorResponse>> {
        return loginRepository.fetchUser(request.getLogin(), request.getPassword())
    }

    inner class Request(private val login: String, private val password: String) :
        InteractorSingle.Request() {
        fun getLogin() = login
        fun getPassword() = password
    }
}