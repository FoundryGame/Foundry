package com.github.foundrygame.util.geometry

class GameCoordinate(x: Int, y: Int) : Vector2(x, y) {
    companion object {
        const val PIXEL_SIZE = 32
    }

    constructor(vec: Vector2) : this(vec.x, vec.y)

    /**
     * Gives the PixelCoordinate in the top left of this game coordinate.
     */
    fun toPixel() : PixelCoordinate {
        return PixelCoordinate(this.scale(PIXEL_SIZE))
    }
}