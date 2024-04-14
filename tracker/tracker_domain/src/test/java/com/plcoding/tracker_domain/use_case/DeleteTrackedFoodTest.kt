package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository
import com.plcoding.tracker_domain.use_case.DeleteTrackedFood
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class DeleteTrackedFoodTest {

    private lateinit var repository: TrackerRepository
    private lateinit var deleteTrackedFood: DeleteTrackedFood

    @Before
    fun setup() {
        repository = mockk(relaxed = true)
        deleteTrackedFood = DeleteTrackedFood(repository)
    }

    @Test
    fun `test deleteTrackedFood invokes repository deleteTrackedFood`() = runBlocking {
        // Arrange
        val trackedFood = TrackedFood(
            id = 1,
            name = "Apple",
            amount = 100,
            calories = 50,
            carbs = 1,
            protein = 2,
            fat = 2,
            date = LocalDate.of(2023, 4, 14),
            imageUrl = "https://example.com/apple.jpg",
            mealType = MealType.Snack
        )

        // Act
        deleteTrackedFood(trackedFood)

        // Assert
        coVerify { repository.deleteTrackedFood(trackedFood) }
    }


}