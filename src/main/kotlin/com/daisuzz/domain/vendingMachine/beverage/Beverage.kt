package com.daisuzz.domain.vendingMachine.beverage

/**
 * 飲み物
 */
sealed class Beverage(val id: BeverageId, private val price: Int) {

    /**
     * 水
     */
    class Water : Beverage(BeverageId(1), 100)

    /**
     * お茶
     */
    class Tea : Beverage(BeverageId(2), 150)

    /**
     * コーヒー
     */
    class Coffee : Beverage(BeverageId(3), 200)

    fun canBuy(money: Int): Boolean {
        return money >= price
    }
}
