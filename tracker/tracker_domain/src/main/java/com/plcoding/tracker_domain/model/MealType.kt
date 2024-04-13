package com.plcoding.tracker_domain.model

sealed class MealType(val name: String) {
    object Breakfact: MealType("breakfast")
    object Lunch: MealType("lunch")
    object Dinner: MealType("dinner")
    object Snack: MealType("snack")

    companion object{
        fun fromString(name:String):MealType{
            return when(name){
                "breakfast" -> Breakfact
                "lunch" -> Lunch
                "dinner" -> Dinner
                else -> Breakfact
            }
        }
    }
}