package com.github.foundrygame.util.geometry

class Rectangle(val x: Int, val y: Int, val dx: Int, val dy: Int) {

    val maxX = if (dx >= 1) x + dx else x
    val maxY = if (dy >= 1) y + dy else y
    val minX = if (dx >= 1) x else x + dx
    val minY = if (dy >= 1) y else y + dx

    val northEast = Vector2(maxX, minY)
    val northWest = Vector2(minX, minY)
    val southEast = Vector2(maxX, maxY)
    val southWest = Vector2(minX, maxY)

    val points: List<Vector2> = listOf(northEast, northWest, southEast, southWest)

    fun isPointInside(point: Vector2) : Boolean {
        return point.x <= this.maxX && point.x >= this.minX && point.y <= this.maxY && point.y >= this.minY
    }
}