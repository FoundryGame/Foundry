package com.github.foundrygame.util.geometry

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class TestRectangularPolygon {

    var rect1: Rectangle = Rectangle(0, 0, 10, 5)
    var rect2: Rectangle = Rectangle(5, 0, 5, 10)
    var poly: RectangularPolygon = RectangularPolygon(setOf(rect1, rect2))

    @Test
    fun `test creation`() {
        poly = RectangularPolygon(setOf(rect1, rect2))
    }

    @Test
    fun `test bad rectangle overlap`() {
        assertThrows<Error> { RectangularPolygon(setOf(rect1, Rectangle(1, 1, 5, 5))) }
    }

    @Test
    fun `test isPointInside`() {
        assertTrue(poly.isPointInside(Vector2(7, 8)))
        assertTrue(poly.isPointInside(Vector2(7, 4)))
        assertTrue(poly.isPointInside(Vector2(2, 4)))
        assertFalse(poly.isPointInside(Vector2(4, 7)))
    }

    @Test
    fun `test isRectInside`() {
        val borderRect: Rectangle = Rectangle(4, 2, 2, 2)
        assertTrue(poly.isRectInside(rect1))
        assertTrue(poly.isRectInside(borderRect))
    }
}