package hr.tvz.android.listastefan

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {
    @Query("SELECT * FROM dataclass")
    fun getAll(): List<DataClass>

    @Insert
    fun insertAll(data: ArrayList<DataClass>)

    @Delete
    fun delete(data: DataClass)
}