package com.daisuzz.domain.bookmark

import com.daisuzz.domain.exception.ApplicationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BookmarksTest {

    @Test
    fun ブックマークが9件登録されている場合新しいブックマークが登録できる() {

        val bookmarks = Bookmarks(
            (1..9).associate {
                val url = Url.of("example.com/$it")
                url to Bookmark(url, " $it")
            }.toMutableMap()
        )
        val newBookmark = Bookmark(Url.of("example.com/new"), "new")
        bookmarks.add(newBookmark)

        assertEquals(10, bookmarks.value.size)
    }

    @Test
    fun ブックマークが10件登録されている場合新しいブックマークが登録できない() {

        val bookmarks = Bookmarks(
            (1..10).associate {
                val url = Url.of("example.com/$it")
                url to Bookmark(url, " $it")
            }.toMutableMap()
        )

        val newBookmark = Bookmark(Url.of("example.com/new"), "new")

        val exception = assertThrows<ApplicationException> { bookmarks.add(newBookmark) }
        assertEquals("上限エラー", exception.message)
    }

    @Test
    fun ブックマークの名前を変更できる() {

        val bookmarks = Bookmarks(
            (1..10).associate {
                val url = Url.of("example.com/$it")
                url to Bookmark(url, " $it")
            }.toMutableMap()
        )

        bookmarks.update(Url.of("example.com/1"), "one")

        assertEquals("one", bookmarks.get("example.com/1")?.name)
    }
}
