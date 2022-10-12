import kotlin.math.*
fun main() {
    var point1 = Position(5,7)
    var point2 = Position(8,9)
    println(point1)
    point1.moveYSymmetrically()
    println(point1)
    point1.moveXSymmetrically()
    println(point1)
    println(point1.calcDistance(point2))

}

interface TwoDPlane {
    fun moveXSymmetrically() // x სათავის მიმართ სიმეტრიულად გადატანა
    fun moveYSymmetrically() // y სათავის მიმართ სიმეტრიულად გადატანა
    fun calcDistance(other: Any): Int // ორი წერტილის შორის მანძილის გამოთვლა

}

open class Position(private var x: Int , private var y: Int): TwoDPlane {

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

    override fun calcDistance(other: Any): Int {
        if (other is Position) {
            return Math.sqrt(Math.pow(x - other.x.toDouble(), 2.0) + Math.pow(y - other.y.toDouble(),2.0)).toInt()
        }
        return 0
    }

}