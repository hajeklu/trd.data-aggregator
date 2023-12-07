package com.cz.trd.dataaggregator.aggregator.controller

import com.cz.trd.dataaggregator.aggregator.model.OrderEntity
import com.cz.trd.dataaggregator.aggregator.repository.OrderRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderRepository: OrderRepository) {


    // Create a new order
    @PostMapping
    fun createOrder(@RequestBody order: OrderEntity): ResponseEntity<OrderEntity> {
        val savedOrder = orderRepository!!.save(order)
        return ResponseEntity.ok(savedOrder)
    }

    // Update an existing order
    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody orderDetails: OrderEntity): ResponseEntity<OrderEntity> {
        val existingOrder = orderRepository.findById(id)
        if (existingOrder.isPresent) {
            val updatedOrder = existingOrder.get()

            orderDetails.symbol?.let { updatedOrder.symbol = it }
            orderDetails.orderType?.let { updatedOrder.orderType = it }
            orderDetails.volume?.let { updatedOrder.volume = it }
            orderDetails.profit?.let { updatedOrder.profit = it }
            orderDetails.state?.let { updatedOrder.state = it }
            orderDetails.highestProfit?.let { updatedOrder.highestProfit = it }
            orderDetails.lowestProfit?.let { updatedOrder.lowestProfit = it }
            orderDetails.stopLoss?.let { updatedOrder.stopLoss = it }
            orderDetails.openProfit?.let { updatedOrder.openProfit = it }
            orderDetails.openTime?.let { updatedOrder.openTime = it }
            orderDetails.closeTime?.let { updatedOrder.closeTime = it }

            return ResponseEntity.ok(orderRepository.save(updatedOrder))
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}