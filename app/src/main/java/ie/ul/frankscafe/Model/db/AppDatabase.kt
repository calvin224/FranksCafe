package ie.ul.frankscafe.Model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.Dao.FoodDao
import ie.ul.frankscafe.Model.Dao.PastOrdersDao
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.Services.Converters

@Database(entities = [User :: class, Food :: class, PastOrder :: class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase()  {
    abstract fun UserDao() : UserDao
    abstract fun FoodDao() : FoodDao
    abstract fun PastOrdersDao() : PastOrdersDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).createFromAsset("database/Foods.db").allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}