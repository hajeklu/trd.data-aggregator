package com.cz.trd.dataaggregator.aggregator.controller

import com.cz.trd.dataaggregator.aggregator.model.Result
import com.cz.trd.dataaggregator.aggregator.repository.ResultRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/results")
class ResultController(private val resultRepository: ResultRepository) {

    @GetMapping("/latest/{symbol}")
    fun getLatestAspirantResultBySymbol(@PathVariable symbol: String): ResponseEntity<Result> {
        val result: Result? = resultRepository.findFirstBySymbolAndIsAspirantFalseOrderByCreatedAtDesc(symbol).orElse(null)
        return result?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }
}
git add