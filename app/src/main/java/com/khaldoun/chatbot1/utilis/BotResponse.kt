package com.khaldoun.chatbot1.utilis

import com.khaldoun.chatbot1.utilis.Constants.OPEN_GOOGLE
import com.khaldoun.chatbot1.utilis.Constants.OPEN_SEARCH

object BotResponse {
    fun basicResponses(_message: String):String {
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when {

            //Hello
            message.contains("hello") -> {
                when (random){
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Bonjour"
                    else -> "error"
                }
            }
            //How are you?
            message.contains("how are you?") -> {
                when (random){
                    0 -> "I'm doing fine. thanks for asking!"
                    1 -> "I'm hungry"
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }
            message.contains("flip") && message.contains("coin") -> {
                var r = (0..1).random()
                val result = if (r==0)"heads" else "tails"

                "I flipped a coin and it landed on $result"
            }
            // Solves maths
            message.contains("solve") -> {
                val equation: String? = message.substringAfter("solve")

                return try {
                    val answer =  SolveMath.solveMath(equation ?: "0")
                    answer.toString()
                } catch ( e: Exception){
                    "Sorry, I can't solve that!"
                }
            }
            // Gets the current time
            message.contains("time") && message.contains("?") -> {
                Time.timeStamp()
            }

            //Opens google
            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }
            //Opens search
            message.contains("search") -> {
                OPEN_SEARCH
            }

            else -> {
                when (random){
                    0 -> "I don't understand..."
                    1 -> "Idk"
                    2 -> "Try asking me something different!"
                    else -> "error"
                }
            }
        }
    }
}