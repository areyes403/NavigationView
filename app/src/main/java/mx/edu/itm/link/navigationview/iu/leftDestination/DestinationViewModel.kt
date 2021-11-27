package mx.edu.itm.link.navigationview.iu.leftDestination

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.edu.itm.link.navigationview.iu.database.DatabaseManager
import mx.edu.itm.link.navigationview.iu.database.MyAppDataSource
import mx.edu.itm.link.navigationview.iu.database.User

class DestinationViewModel:ViewModel() {
    val savedUsers= MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch {
            val userDao= DatabaseManager.instance.database.userDao()
            savedUsers.value=MyAppDataSource(userDao).getUsers().value

        }
    }
}