package com.nevro.mydiet.base

import com.orm.SugarRecord
import com.sheypoor.tvmaze.base.BaseModel
import com.sheypoor.tvmaze.network.TvMazeApiService
import javax.inject.Inject


/**
 * Created by S.Masoud on 2017/06/30.
 */
abstract class BaseRepository<T : BaseModel>(clazz: Class<T>) {

    private val clazz: Class<T>? = clazz

    @Inject
    lateinit var apiService: TvMazeApiService


    fun save(model: T) {
        model.save()

    }

    fun saveAll(list: List<T>) {
        SugarRecord.saveInTx(list)
    }

    fun saveCached(model: T) {
        model.isCached = true
        model.save()
    }

    fun loadCached() = SugarRecord.find(clazz, "is_cached", "true")

    fun loadAll() = SugarRecord.listAll(clazz)

    fun loadById(id: Int) = SugarRecord.findById(clazz, id)

    fun clearAll() {
        SugarRecord.deleteAll(clazz)
    }


}