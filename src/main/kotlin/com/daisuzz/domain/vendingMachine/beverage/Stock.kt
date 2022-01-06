package com.daisuzz.domain.vendingMachine.beverage

data class Stock(val value: Int) {
    fun isEmpty(): Boolean {
        return value <= 0
    }
}
