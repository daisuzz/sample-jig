package com.daisuzz.domain.trafficSignal

/**
 * 信号機のサンプルコード
 * - 信号の色は、赤→緑, 緑→黄色, 黄色→赤, と遷移する
 */
data class TrafficSignal(var trafficColor: TrafficColor) {
    fun switch() {
        trafficColor = trafficColor.nextColor()
    }
}
