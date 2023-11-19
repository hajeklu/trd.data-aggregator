package com.cz.trd.dataaggregator.aggregator.repository

import com.cz.trd.dataaggregator.aggregator.model.Result
import org.springframework.data.jpa.repository.JpaRepository

interface ResultRepository : JpaRepository<Result, Long> {
}