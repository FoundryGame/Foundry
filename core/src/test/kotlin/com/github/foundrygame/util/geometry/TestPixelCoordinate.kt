package com.github.foundrygame.util.geometry

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TestPixelCoordinate {

    @Test
    fun `test conversion to GameCoordinate`() {
        var pixelCoordinate = PixelCoordinate(20, 20)
        assertEquals(GameCoordinate(0, 0), pixelCoordinate.toGame())
        pixelCoordinate = PixelCoordinate(37, 21)
        assertEquals(GameCoordinate(1, 0), pixelCoordinate.toGame())
        pixelCoordinate = PixelCoordinate(69, 32)
        assertEquals(GameCoordinate(2, 1), pixelCoordinate.toGame())
    }
}