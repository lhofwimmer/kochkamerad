package at.lhofwimmer.composetemplate.data.local

import android.content.Context
import android.location.Location
import androidx.compose.ui.autofill.AutofillType
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import at.lhofwimmer.composetemplate.data.local.dao.ExampleDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [], version = 2, exportSchema = false)
abstract class ExampleDatabase : RoomDatabase() {

    abstract fun apiDao(): ExampleDao

    companion object {
        @Volatile
        private var INSTANCE: ExampleDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ExampleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExampleDatabase::class.java,
                    "besthelp"
                ).addCallback(BestHelpDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class BestHelpDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.apiDao())
                }
            }
        }

        suspend fun populateDatabase(apiDao: ExampleDao) {
        }
    }
}