package com.github.foundrygame.util.geometry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestGameCoordinate {
    @Test
    fun `test conversion to PixelCoordinate`() {
        var gameCoordinate = GameCoordinate(0, 0)
        assertEquals(PixelCoordinate(0, 0), gameCoordinate.toPixel())
        gameCoordinate = GameCoordinate(1, 0)
        assertEquals(PixelCoordinate(GameCoordinate.PIXEL_SIZE, 0), gameCoordinate.toPixel())
        gameCoordinate = GameCoordinate(1, 1)
        assertEquals(PixelCoordinate(GameCoordinate.PIXEL_SIZE, GameCoordinate.PIXEL_SIZE), gameCoordinate.toPixel())
        gameCoordinate = GameCoordinate(2, 1)
        assertEquals(PixelCoordinate(GameCoordinate.PIXEL_SIZE * 2, GameCoordinate.PIXEL_SIZE), gameCoordinate.toPixel())
    }
}