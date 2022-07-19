package com.valquiria.dndspells.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.valquiria.dndspells.data.database.dao.SpellDao
import com.valquiria.dndspells.data.database.entity.SpellEntity

@Database(
    entities = [SpellEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SpellDatabase: RoomDatabase() {

    abstract val spellDao: SpellDao

    companion object {

        @Volatile
        private var INSTANCE: SpellDatabase? = null

        fun getInstance(context: Context): SpellDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SpellDatabase::class.java,
                        "user_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}