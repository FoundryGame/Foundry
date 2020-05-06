package com.github.foundrygame.util.geometry

class RectangularPolygon(rectangles: Set<Rectangle>) {
    private val rectangles: Set<Rectangle>

    init {
        val internalRects = mutableSetOf<Rectangle>()
        for(rect in rectangles) {
            if(internalRects.size == 0) {
                internalRects.add(rect)
            }
            val valid = internalRects.any {
                rect.northEast == it.northEast
                        || rect.southEast == it.southEast
                        || rect.northWest == it.northWest
                        || rect.southWest == it.southWest
            }
            if(!valid) {
                throw Error("Invalid composite rectangle construction. At least one corner must be shared.")
            }
            internalRects.add(rect)
        }
        this.rectangles = internalRects.toSet()
    }


    fun isPointInside(point: Vector2) : Boolean {
        return rectangles.any {
            it.isPointInside(point)
        }
    }

    fun isRectInside(rect: Rectangle ) : Boolean {
        return rectangles.any {
            rect.points.all { point ->
                it.isPointInside(point)
            }
        }
    }

    fun merge(other: RectangularPolygon) : RectangularPolygon {
        val set = mutableSetOf<Rectangle>()
        set.addAll(rectangles)
        set.addAll(other.rectangles)
        return RectangularPolygon(set)
    }
}