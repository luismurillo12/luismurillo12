package com.lugares_j.repository

import androidx.lifecycle.LiveData
import com.lugares_j.data.LugarDao
import com.lugares_j.model.Lugar

class LugarRepository (private val lugarDao: LugarDao) {
    suspend fun saveLugar(lugar: Lugar){
        if (lugar.id==0){
            lugarDao.addLugar(lugar)//Si es un lugar nuevo se añade aca
        }else{
            lugarDao.upadateLugar(lugar)// si ya el lugar se sabe el id se actualiza aca
        }
    }
    suspend fun deleteLugar(lugar:Lugar){
        if (lugar.id!=0){//Si el id tiene un valor lo va a intentar eliminar
            lugarDao.deleteLugar(lugar)
        }
    }

    val getLugares: LiveData<List<Lugar>> = lugarDao.getLugares()
}