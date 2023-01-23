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
            // What is digital marketing?
            message.contains("what is digital marketing") -> {
                when (random){
                    0 -> "Digital marketing, also called online marketing, is the promotion of brands to connect with potential customers using the internet and other forms of digital communication. This includes not only email, social media, and web-based advertising, but also text and multimedia messages as a marketing channel."
                    1 -> "Digital marketing is the process of promoting products or services using digital channels such as the internet, social media, search engines, and mobile devices. The goal of digital marketing is to reach a larger audience and drive more sales through targeted advertising and engagement strategies. Some common digital marketing tactics include search engine optimization (SEO), pay-per-click (PPC) advertising, social media marketing, content marketing, and email marketing. By leveraging the power of technology and data analysis, digital marketing allows businesses to reach and engage with their target audience in a more cost-effective and measurable way."
                    2 -> "Digital marketing leverages technology and data to effectively reach and engage target audiences, driving sales and growth. Tactics include SEO, PPC, social media, content marketing and email campaigns. This approach enables cost-effective, measurable results."
                    else -> "error"
                }
            }

            // What is artificial intelligence
            message.contains("what is artificial intelligence?") -> {
                when (random) {
                    0 -> "Artificial Intelligence (AI) is the future of technology that simulates human intelligence and allows machines to learn, reason and adapt like humans. It encompasses various technologies like machine learning, natural language processing, image and speech recognition. AI is being used to automate mundane tasks, improve decision making and create new opportunities. With the rapid advancements in AI, it is expected to change the way we live and work, in ways yet to be imagined."
                    1 -> "Artificial Intelligence (AI) is the simulation of human intelligence in machines, enabling them to perform tasks like decision-making, speech recognition, and language translation. It's being widely used to improve efficiency and decision-making."
                    2 -> "AI refers to the ability of machines to perform tasks that typically require human intelligence, such as perception, reasoning and self-correction. It is being integrated into various fields to automate processes, improve decision-making and create new opportunities."
                    else -> "error"
                }
            }

            // Tell me your top secret
            message.contains("tell me one of your top secrets") -> {
                when (random){
                    0 -> "elon musk is my dad"
                    1 -> "elon musk is my dad"
                    2 -> "elon musk is my dad"
                    else -> "error"
                }
            }
            // What is the expected market size of the Metaverse?
            message.contains("what is the expected market size of the metaverse?") -> {
                when (random){
                    0 -> "The metaverse is predicted to be a major growth opportunity in the next decade, with an estimated worth of \$5 trillion by 2030, and is expected to affect various industries, including retail, technology, and healthcare."
                    1 -> "The metaverse is a potential high-growth area, valued at \$5 trillion by 2030, and expected to impact various industries."
                    2 -> "The metaverse is projected to have a significant impact and reach a value of \$5 trillion by 2030, affecting various industries."
                    else -> "error"
                }
            }
            // What are the pillars of Web 3.0?
            message.contains("what are the pillars of web 3.0?") -> {
                when(random){
                    0 -> "Web 3.0 aims for a more decentralized, user-centric and intelligent internet using blockchain, semantic web, AI, interoperability, user-centricity, and security as its main pillars."
                    1 -> "Web 3.0 is a decentralized, user-centric and intelligent version of the internet, built on blockchain, semantic web, AI, interoperability, user-centricity and security."
                    2 -> "Web 3.0 is a version of the internet that is decentralized, user-centric, and intelligent, using blockchain, semantic web, AI, interoperability, user-centricity, and security as its foundation."
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