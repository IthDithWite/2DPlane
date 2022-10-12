fun main() {
    val point1 = position(5,7)
    println(point.toString())
    val point2 = position(8,9)
}

interface twoDPlane {
    fun moveXSymmetrically()
    fun moveYSymmetrically()
    fun calcDistance(other: Any?): Double {
        return 0.2
    }

}

open class position(protected var x: Int, protected var y: Int): twoDPlane {

    override fun toString(): String {
        return "X: $x Y: $y"
    }

    override fun equals(other: Any?): Boolean {
        if (other is position) {
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

    override fun calcDistance(other: Any?): Double {
        return Math.sqrt(Math.pow(x - other.x) + Math.pow(y - other.y))
    }


}