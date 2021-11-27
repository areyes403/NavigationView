package mx.edu.itm.link.navigationview.iu.database

class  User(id:Int,username:String){
    val id=id
    val username=username

}

fun User.toEntity()=UserEntity(
    id,username
)