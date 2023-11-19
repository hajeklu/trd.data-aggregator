package com.cz.trd.dataaggregator.aggregator.handlers
import com.cz.trd.dataaggregator.aggregator.model.Result
import com.cz.trd.dataaggregator.aggregator.repository.ResultRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RabbitMQListener(val resultRepository: ResultRepository) {

    private val objectMapper = jacksonObjectMapper()

    @RabbitListener(queues = ["Results_5"])
    fun receiveMessage(message: String) {
        try {
            // Explicitly provide the type information for deserialization
            val result: Result = objectMapper.readValue(message, Result::class.java)

            // Check if ema1 and ema2 are not zero
            if (result.ema1 != 0 && result.ema2 != 0) {
                resultRepository.save(result)
                println("Saved message: $message")
            } else {
                println("Message not saved due to ema1 or ema2 being zero.")
            }
        } catch (e: Exception) {
            // Handle parsing exceptions
            println("Error parsing message: ${e.message}")
        }
    }
}