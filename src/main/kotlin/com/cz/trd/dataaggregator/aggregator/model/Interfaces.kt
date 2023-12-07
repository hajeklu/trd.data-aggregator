package com.cz.trd.dataaggregator.aggregator.model

enum class OrderType {
    BUY, SELL
}

enum class OrderState {
    OPEN, CLOSE, WAITING_TO_CLOSE, LOSS, UNKNOWN
}