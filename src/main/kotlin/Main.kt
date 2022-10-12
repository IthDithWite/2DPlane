fun main() {
    val point1 = Position(5.2,7.3)
    println(point1.toString())
    val point2 = Position(8.1,9.4)
    print(point1.calcDistance(point2))
}

interface TwoDPlane {
    fun moveXSymmetrically() // x სათავის მიმართ სიმეტრიულად გადატანა
    fun moveYSymmetrically() // y სათავის მიმართ სიმეტრიულად გადატანა
    fun calcDistance(other: Any): Double // ორი წერტილის შორის მანძილის გამოთვლა

}

open class Position(private var x: Double, private var y: Double): TwoDPlane {

    override fun toString(): String { // კოორდინატების დაბრუნება
        return "X: $x Y: $y"
    }

    override fun equals(other: Any?): Boolean { // შედარება
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
            return Math.sqrt(Math.pow(x - other.x) + Math.pow(y - other.y))
        }
        return 0.1
    }

}