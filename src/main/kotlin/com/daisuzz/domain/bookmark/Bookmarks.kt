package com.daisuzz.domain.bookmark

import com.daisuzz.domain.exception.ApplicationException

/**
 * ブラウザのブックマークのサンプル
 * ・上限10件
 * ・同じURLは登録できない
 * ・ブックマークの登録/削除/名前の変更が可能
 */
data class Bookmarks(
    val value: MutableSet<Bookmark>
) {

    fun get(url: String): Bookmark? {
        return value.find { it.url.value == url }
    }

    fun add(bookmark: Bookmark) {
        require(value.size < 10) {
            throw ApplicationException("上限エラー")
        }
        value.add(bookmark)
    }

    fun delete(bookmark: Bookmark) {
        value.remove(bookmark)
    }

    fun update(_url: String, name: String) {
        val url = Url(_url)
        value.removeIf { it.url == url }
        val new = Bookmark(url, name)
        value.add(new)
    }
}

data class Bookmark(
    val url: Url,
    val name: String,
)

data class Url(val _url: String) {
    val value: String = if (_url.isNotEmpty()) {
        _url
    } else {
        throw IllegalArgumentException()
    }
}
