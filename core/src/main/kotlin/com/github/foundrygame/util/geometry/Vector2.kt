package com.github.foundrygame.util.geometry

import kotlin.math.pow
import kotlin.math.sqrt

open class Vector2(val x: Int, val y: Int) {

    constructor(other: Vector2) : this(other.x, other.y)

    val magnitude : Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
    val unitX : Double = x / magnitude
    val unitY : Double = y / magnitude

    fun transformX(transform: Int) : Vector2 {
        return Vector2(this.x + transform, y)
    }

    fun transformY(transform: Int) : Vector2 {
        return Vector2(this.x, this.y + transform)
    }

    fun transform(x: Int, y: Int) : Vector2 {
        return Vector2(this.x + x, this.y + y)
    }

    fun scale(factor: Int) : Vector2 {
        return Vector2(this.x * factor, this.y * factor)
    }

    operator fun plus(other: Vector2) : Vector2 {
        return Vector2(this.x + other.x, this.y + other.y)
    }

    operator fun minus(other: Vector2) : Vector2 {
        return Vector2(this.x - other.x, this.y - other.y);
    }

    infix fun dot(other: Vector2) : Int {
        return this.x * other.x + this.y * other.y;
    }


    infix fun cross(other: Vector2) : Int {
        return this.x * other.y - this.y * other.x;
    }

    override fun toString(): String {
        return "<$x, $y>"
    }

    override operator fun equals(other: Any?): Boolean {
        if(other !is Vector2) {
            return false
        }
        return other.x == this.x && other.y == this.y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}
