package com.lugares_j.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugares_j.model.Lugar

@Dao
interface LugarDao {
    //Las funcionaes de bajo nivel para hacer un CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)//que si no lo puede insertar que no de error
    suspend fun addLugar(lugar: Lugar)//esto va a insertar un registro en mi tabla

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upadateLugar(lugar: Lugar)//esto va a actualizar un registro en mi tabla

    @Delete
    suspend fun deleteLugar(lugar: Lugar)//esto va a eliminar un registro en mi tabla

    @Query("SELECT * FROM LUGAR")//Consulta general de SQL
    fun getLugares() : LiveData<List<Lugar>> //datos que se pueden cargar en tiempo real
}