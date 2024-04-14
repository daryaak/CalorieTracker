package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class GetFoodsForDateTest {
    private lateinit var repository: TrackerRepository
    private lateinit var getFoodsForDate: GetFoodsForDate

    @Before
    fun setup() {
        repository = mockk()
        getFoodsForDate = GetFoodsForDate(repository)
    }

    @Test
    fun `test getting foods for a specific date`() = runBlocking {
        // Arrange
        val date = LocalDate.of(2023, 4, 14)
        val trackedFood1 = TrackedFood(
            id = 1,
            name = "Apple",
            amount = 100,
            calories = 50,
            carbs = 1,
            protein = 2,
            fat = 2,
            date = date,
            imageUrl = "https://example.com/apple.jpg",
            mealType = MealType.Snack
        )
        val trackedFood2 = TrackedFood(
            id = 2,
            name = "Banana",
            amount = 50,
            calories = 80,
            carbs = 2,
            protein = 1,
            fat = 1,
            date = date,
            imageUrl = "https://example.com/banana.jpg",
            mealType = MealType.Breakfast
        )
        val expectedFoods = listOf(trackedFood1, trackedFood2)

        coEvery { repository.getFoodsForDate(date) } returns flowOf(expectedFoods)

        // Act
        val actualFoods = getFoodsForDate(date).first()

        // Assert
        assertEquals(expectedFoods, actualFoods)
    }
}