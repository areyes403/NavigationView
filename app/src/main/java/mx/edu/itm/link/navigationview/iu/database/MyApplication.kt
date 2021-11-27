package mx.edu.itm.link.navigationview.iu.database

import android.app.Application
import mx.edu.itm.link.navigationview.iu.database.DatabaseManager

open class MyApplication:Application (){
    override fun onCreate() {
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}