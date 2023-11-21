package com.cz.trd.dataaggregator.aggregator.repository

import com.cz.trd.dataaggregator.aggregator.model.Result
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ResultRepository : JpaRepository<Result, Long> {
    fun findFirstBySymbolAndIsAspirantFalseOrderByCreatedAtDesc(symbol: String): Optional<Result>
}