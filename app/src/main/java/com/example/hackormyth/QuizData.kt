package com.example.hackormyth

object QuizData {
    val questions = listOf(
        Question(
            statement = "Placing a wooden spoon over a boiling pot prevents it from boiling over.",
            isTrue = true,
            explanation = "Real Hack! The spoon breaks the surface tension of the bubbles."
        ),
        Question(
            statement = "Charging your phone on airplane mode makes it charge faster.",
            isTrue = true,
            explanation = "Real Hack! Airplane mode cuts background processes that drain battery."
        ),
        Question(
            statement = "Eating carrots gives you night vision.",
            isTrue = false,
            explanation = "Myth! Carrots support eye health but won't give you night vision."
        ),
        Question(
            statement = "You can use toothpaste to clean foggy headlights.",
            isTrue = true,
            explanation = "Real Hack! The mild abrasive in toothpaste polishes plastic lenses."
        ),
        Question(
            statement = "Shaving makes hair grow back thicker",
            isTrue = false,
            explanation = "Myth! Shaving has no effect on hair thickness or growth rate"
        )
    )
}
