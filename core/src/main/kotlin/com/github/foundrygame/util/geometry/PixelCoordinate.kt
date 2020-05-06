package com.github.foundrygame.util.geometry

import kotlin.math.floor


class PixelCoordinate(x: Int, y: Int) : Vector2(x, y) {

    constructor(vec: Vector2) : this(vec.x, vec.y)

    fun toGame() : GameCoordinate {
        return GameCoordinate(floor(this.x.toDouble() / GameCoordinate.PIXEL_SIZE.toDouble()).toInt(),
                floor(this.y.toDouble() / GameCoordinate.PIXEL_SIZE.toDouble()).toInt())
    }
}