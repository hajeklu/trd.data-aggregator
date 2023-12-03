package com.cz.trd.dataaggregator.aggregator.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class OrderEntity {
    @Id()
    var id: Long = 0

    @Column()
    var symbol: String = "No symbol"

    @Column()
    var price: Double = 0.0

    @Column()
    var type: OrderType = OrderType.BUY

    @Column()
    var volume: Double = 0.1

    @Column()
    var profit: Double = 0.1

    @Column()
    var highestProfit: Double = 0.0

    @Column()
    var lowestProfit: Double = 0.0

    @Column()
    var stopLoss: Double = 0.0

    @Column()
    var openProfit: Double = 0.0

    @Column(nullable = true)
    var emaShort = 0

    @Column(nullable = true)
    var emaLong = 0

    @Column()
    var openTime: Long = 0

    @Column()
    var closeTime: Long = 0

    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null

    @PrePersist
    protected fun onCreate() {
        createdAt = LocalDateTime.now()
        updatedAt = createdAt
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}