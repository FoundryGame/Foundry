package com.github.foundrygame.util.geometry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestRectangle {

    private var rectangle: Rectangle = Rectangle(0, 0, 5, 7)

    @BeforeEach
    fun setUp() {
        rectangle = Rectangle(0, 0, 5, 7)
    }

    @Test
    fun `test creation`() {
        assertEquals(Vector2(0, 0), rectangle.northWest, "Expected northwest coordinates to be (0, 0) but found (${rectangle.northWest.x}, ${rectangle.northWest.y}).")
        assertEquals(Vector2(5, 0), rectangle.northEast, "Expected northwest coordinates to be (5, 0) but found (${rectangle.northEast.x}, ${rectangle.northEast.y}).")
        assertEquals(Vector2(0, 7), rectangle.southWest, "Expected northwest coordinates to be (0, 7) but found (${rectangle.southWest.x}, ${rectangle.southWest.y}).")
        assertEquals(Vector2(5, 7), rectangle.southEast, "Expected northwest coordinates to be (5, 7) but found (${rectangle.southEast.x}, ${rectangle.southEast.y}).")
        assertEquals(5, rectangle.maxX, "Expected maxX to be 5 but found ${rectangle.maxX}")
        assertEquals(7, rectangle.maxY, "Expected maxY to be 7 but found ${rectangle.maxY}")
        assertEquals(0, rectangle.minX, "Expected minX to be 0 but found ${rectangle.minX}")
        assertEquals(0, rectangle.minY, "Expected minY to be 0 but found ${rectangle.minY}")
    }

    @Test
    fun `test isPointInside`() {
        assertTrue(rectangle.isPointInside(Vector2(0, 0)), "Expected (0, 0) to be inside the rectangle")
        assertTrue(rectangle.isPointInside(Vector2(5, 7)), "Expected (5, 7) to be inside the rectangle")
        assertTrue(rectangle.isPointInside(Vector2(3, 5)), "Expected (3, 5) to be inside the rectangle")
        assertTrue(rectangle.isPointInside(Vector2(3, 7)), "Expected (3, 7) to be inside the rectangle")
        assertFalse(rectangle.isPointInside(Vector2(3, 8)), "Expected (3, 8) to not be inside the rectangle")
    }
}