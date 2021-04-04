package com.github.leventarican.underconstruction

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.leventarican.underconstruction.database.AppDatabase
import com.github.leventarican.underconstruction.database.Developer
import com.github.leventarican.underconstruction.database.DeveloperDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var developerDao: DeveloperDao
    private lateinit var db: AppDatabase

    // add androidx.arch.core:core-testing:2.1.0 dependency
    // rule for running task synchronously
    @Rule @JvmField
    public var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            // Allowing main thread queries, just for testing.
//            .allowMainThreadQueries()
            .build()
        developerDao = db.developerDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndSelect() = runBlocking {
        val developer = Developer(exp = 10)
        developerDao.insert(developer)

//        val developers = LiveDataTestUtil.getValue(developerDao.getDevelopers())
//        Log.d("#", "developer size: ${developers.size}")
//        assertEquals(1, developers.size)
        val developers = developerDao.getDevelopers()
        Log.d("#", "developer size: ${developers.value?.size}")
        assertEquals(1, developers.value?.size)

    }

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.github.leventarican.underconstruction", appContext.packageName)
//    }

}