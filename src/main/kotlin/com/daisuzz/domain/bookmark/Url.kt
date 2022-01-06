package com.daisuzz.domain.bookmark

import com.daisuzz.domain.exception.ApplicationException

data class Url private constructor(val value: String) {

    companion object {
        fun of(url: String): Url {
            if (url.isNotEmpty()) {
                return Url(url)
            } else {
                throw ApplicationException("不正な文字列です")
            }
        }
    }
}
