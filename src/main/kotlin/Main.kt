fun main() {
    val point1 = Position(5,7)
    println(point1.toString())
    val point2 = Position(8,9)
    print(point1.calcDistance(point2))
}

interface TwoDPlane {
    fun moveXSymmetrically()
    fun moveYSymmetrically()
    fun calcDistance(other: Any): Double {
        return 0.2
    }

}

open class Position(private var x: Double, private var y: Double): TwoDPlane {

    override fun toString(): String {
        return "X: $x Y: $y"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Position) {
            if (x == other.x && y == other.y) {
                return true
            }
        }
        return false
    }

    override fun moveXSymmetrically(){
        x = -x
    }

    override fun moveYSymmetrically(){
        y = -y
    }

    override fun calcDistance(other: Any): Double {
        if (other is Position) {
            return Math.sqrt(Math.pow(x - other.x) + Math.pow(y - other.y)
        }
        return 0.1
    }

}