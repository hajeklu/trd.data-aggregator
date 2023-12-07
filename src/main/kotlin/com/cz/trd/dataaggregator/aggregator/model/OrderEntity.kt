package com.cz.trd.dataaggregator.aggregator.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class OrderEntity {
    @Id()
    var id: Long = 0

    @Column()
    var position: Long = 0

    @Column()
    var symbol: String = "No symbol"

    @Enumerated(EnumType.STRING)
    @Column()
    var orderType: OrderType = OrderType.BUY

    @Enumerated(EnumType.STRING)
    @Column()
    var state: OrderState = OrderState.UNKNOWN

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

    @Column()
    var openTime: LocalDateTime = LocalDateTime.now()

    @Column()
    var closeTime: LocalDateTime = LocalDateTime.now()

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