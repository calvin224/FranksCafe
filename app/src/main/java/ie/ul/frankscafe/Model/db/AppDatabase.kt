package ie.ul.frankscafe.Model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db_entity.User

@Database(entities = [User :: class], version = 1)
abstract class AppDatabase: RoomDatabase()  {
    abstract fun UserDao() : UserDao

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
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}