package mx.edu.itm.link.navigationview.iu.left

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.edu.itm.link.navigationview.iu.database.DatabaseManager
import mx.edu.itm.link.navigationview.iu.database.MyAppDataSource
import mx.edu.itm.link.navigationview.iu.database.User

class LeftViewModel: ViewModel(){

    fun save(user:User){
        viewModelScope.launch {
            val userDao=DatabaseManager.instance.database.userDao()
            MyAppDataSource(userDao).save(user)
        }
    }
}