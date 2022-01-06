package com.daisuzz.domain.vendingMachine

import com.daisuzz.domain.exception.ApplicationException
import com.daisuzz.domain.vendingMachine.beverage.Beverage
import com.daisuzz.domain.vendingMachine.beverage.BeverageId
import com.daisuzz.domain.vendingMachine.beverage.Stock

/**
 * 自動販売機のサンプルコード
 * - 自動販売機では飲み物(水, お茶, コーヒー)を販売している
 * - お金を投入できる
 * - 投入した金額内の飲み物のうち在庫がある飲み物を購入できる
 * - 入れたお金はお釣りボタンを押すことで返却される
 */
data class VendingMachine(var money: Int, val items: Map<BeverageId, Pair<Beverage, Stock>>) {

    fun deposit(money: Int) {
        this.money += money
    }

    fun returnItem(beverageId: BeverageId): Beverage {
        val selectedBeverage = items[beverageId] ?: throw ApplicationException("存在しない飲み物です")
        if (selectedBeverage.second.isEmpty()) {
            throw ApplicationException("在庫がありません")
        }
        if (!selectedBeverage.first.canBuy(money)) {
            throw ApplicationException("投入した金額が不足しています")
        }
        return selectedBeverage.first
    }

    fun returnChange(): Int {
        val change = money
        money = 0
        return change
    }
}
