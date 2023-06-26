package com.uv72dev.littlelemon

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.serialization.SerialName

@Entity
data class MenuItemRoom(
    @PrimaryKey var id : Int?,
    var title : String?,
    var description: String?,
    var price : Double?,
    var image : String?,
    var category : String?
)

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menuItems: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}