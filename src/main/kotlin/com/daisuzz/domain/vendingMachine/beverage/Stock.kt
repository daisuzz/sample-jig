package com.daisuzz.domain.vendingMachine.beverage

/**
 * 在庫
 */
data class Stock(val value: Int) {
    fun isEmpty(): Boolean {
        return value <= 0
    }
}
