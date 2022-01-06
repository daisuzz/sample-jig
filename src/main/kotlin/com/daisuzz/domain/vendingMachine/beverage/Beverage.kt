package com.daisuzz.domain.vendingMachine.beverage

sealed class Beverage(val id: BeverageId, private val price: Int) {
    class Water : Beverage(BeverageId(1), 100)
    class Tea : Beverage(BeverageId(2), 150)
    class Coffee : Beverage(BeverageId(3), 200)

    fun canBuy(money: Int): Boolean {
        return money >= price
    }
}
