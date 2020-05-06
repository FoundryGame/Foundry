package com.github.foundrygame.util.geometry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestVector {
    var vec = Vector2(2, 3)
    var vec2 = Vector2(4, 2)
    var vec3 = Vector2(2, 4)

    @BeforeEach
    fun setUp() {
        vec = Vector2(2, 3)
        vec2 = Vector2(4, 2)
        vec3 = Vector2(2, 4)
    }

    @Test
    fun `test creation`() {
        assertEquals(vec.x, 2)
        assertEquals(vec.y, 3)
        assertEquals(Vector2(vec), vec)
    }

    @Test
    fun `test transformations`() {
        assertEquals(Vector2(3, 3), vec.transformX(1))
        assertEquals(Vector2(2, 4), vec.transformY(1))
        assertEquals(Vector2(4, 6), vec.scale(2))
    }

    @Test
    fun `test simple math`() {
        assertEquals(Vector2(6, 5), vec + vec2)
        assertEquals(Vector2(-2, 1), vec - vec2)
    }

    @Test
    fun `test dot product`() {
        assertEquals(14, vec dot vec2)
        assertEquals(vec dot vec2, vec2 dot vec)
    }

    @Test
    fun `test cross product`() {
        assertEquals(-8, vec cross vec2)
    }

    @Test
    fun `test magnitude`() {
        assertEquals(3.60555, vec.magnitude, 0.005)
    }
}