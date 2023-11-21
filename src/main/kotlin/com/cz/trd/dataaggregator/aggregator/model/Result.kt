package com.cz.trd.dataaggregator.aggregator.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@Entity
class Result {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @Column(nullable = false)
    val symbol: String = "Null"

    @Column(nullable = false)
    val ema1: Int = 0

    @Column(nullable = false)
    val ema2: Int = 0

    @Column(nullable = false)
    val profit: Double = 0.0

    @Column(nullable = false)
    val profitableOrders: Int = 0

    @JsonProperty("lossOrders")
    @Column(nullable = false, name = "loss_orders")
    val lossOrders: Int = 0

    @Column(nullable = false)
    val timeFrame: Int = 5

    @Column()
    val isAspirant: Boolean = false

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