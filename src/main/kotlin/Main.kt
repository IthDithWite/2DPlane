fun main() {
    val point = position(5,7)
    println(point.toString())
}

interface twoDPlane {
    fun get
}

class position(private var x: Int, private var y: Int) {

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


}