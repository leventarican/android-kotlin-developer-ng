package com.github.leventarican.underconstruction;

import android.util.Log;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.github.leventarican.underconstruction.database.AppDatabase;
import com.github.leventarican.underconstruction.database.Developer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class DBTest {

    // FOR DATA
    private AppDatabase database;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void step0() throws InterruptedException {
        Developer d0 = new Developer();
        d0.setExp(10);
        d0.setTimestamp(100);

        this.database.getDeveloperDao().insert(d0);

        List<Developer> developers = LiveDataTestUtil.getValue(this.database.getDeveloperDao().getDevelopers());

        Log.d("#", String.format("developers size: %d", developers.size()));
    }
}