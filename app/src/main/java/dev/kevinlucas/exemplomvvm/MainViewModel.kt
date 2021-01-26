package dev.kevinlucas.exemplomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mTextWelcome = MutableLiveData<String>()
    private var mPersonRepository = PersonRepository()
    private var mToastNotification = MutableLiveData<String>()

    init {
        mTextWelcome.value = "Bom dia!"
    }

    fun welcome(): LiveData<String> {
        return mTextWelcome
    }

    fun login(): LiveData<String> {
        return mToastNotification
    }

    fun doLogin(email: String){
        if(this.mPersonRepository.login(email))
            mToastNotification.setValue("Success")
        else
            mToastNotification.setValue("Faleid")
    }

}