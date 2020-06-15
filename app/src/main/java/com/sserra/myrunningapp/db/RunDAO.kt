package com.sserra.myrunningapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calories DESC")
    fun getAllRunsSortedByCalories(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedKMH DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(calories) FROM running_table")
    fun getTotalCalories(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedKMH) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Long>

//    @Query("""
//
//        SELECT * FROM running_table
//
//        ORDER BY
//
//        CASE WHEN :column = 'timestamp'  THEN timestamp END DESC,
//
//        CASE WHEN :column = 'timemili' THEN timeInMillis END DESC,
//
//        CASE WHEN :column = 'calories' THEN calories END DESC,
//
//        CASE WHEN :column = 'speed'  THEN avgSpeedKMH END DESC,
//
//        CASE WHEN :column = 'distance' THEN distanceInMeters END DESC
//    """)
//    suspend fun filterBy(column : String) : LiveData<List<Run>>
}