fun main() {
    val f1 = Fraction()

    val f2 = Fraction()

    println(f1.toString())
    println(f1)

    println(f1.equals(f2))
    println(f1==f2)

}

interface FractionMaths {
        fun simplifyFraction()
        fun addFractions()
        fun subtractFractions()
        fun multiplyFractions()
        fun divideFractions()
}

open class Fraction (private var numerator: Int, private var denominator: Int): FractionMaths {

    override fun toString(): String {
        return "$numerator / $denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator == other.denominator * numerator) {
                return true
            }
        }
        return false
    }

    override fun simplifyFraction() {
        var i=0: Int
        while (numerator%2==0 && denominator %2==0) {

        }
    }
}