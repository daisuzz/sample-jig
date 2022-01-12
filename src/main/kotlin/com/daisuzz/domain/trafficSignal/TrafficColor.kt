package com.daisuzz.domain.trafficSignal

/**
 * 信号色
 */
enum class TrafficColor {
    RED {
        override fun nextColor(): TrafficColor {
            return GREEN
        }
    },
    YELLOW {
        override fun nextColor(): TrafficColor {
            return RED
        }
    },
    GREEN {
        override fun nextColor(): TrafficColor {
            return YELLOW
        }
    };

    abstract fun nextColor(): TrafficColor
}
