package com.daisuzz.domain.bookmark

import com.daisuzz.domain.exception.ApplicationException

/**
 * ブックマーク機能のサンプルコード
 * ・上限10件
 * ・同じURLを複数登録できない
 * ・ブックマークの登録/削除/名前の変更が可能
 */
data class Bookmarks(
    val value: MutableMap<Url, Bookmark>
) {

    fun get(url: String): Bookmark? {
        return value[Url.of(url)]
    }

    fun add(bookmark: Bookmark) {
        require(value.size < 10) {
            throw ApplicationException("上限エラー")
        }
        value[bookmark.url] = bookmark
    }

    fun delete(bookmark: Bookmark) {
        value.remove(bookmark.url)
    }

    fun update(url: Url, name: String) {
        value.remove(url)
        val new = Bookmark(url, name)
        value[url] = new
    }
}
