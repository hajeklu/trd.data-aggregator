package com.cz.trd.dataaggregator.aggregator.repository

import com.cz.trd.dataaggregator.aggregator.model.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long> {
}