fun main() {
    var f1 = Fraction()

    var f2 = Fraction()

    println(f1.toString())
    println(f1)

    println(f1.equals(f2))
    println(f1==f2)

}

interface FractionMaths {
        fun simplifyFraction()
        fun findGCD(): Int
        fun findLCM(): Int
        fun addFractions()
        fun subtractFractions()
        fun multiplyFractions()
        fun divideFractions()
}

open class Fraction(private var numerator: Int, private var denominator: Int): FractionMaths {

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
        var i = 0
        if (numerator % 3 == 0 && denominator % 2 == 0) {
            while (numerator % 2 == 0 && denominator % 2 == 0) {
                numerator /= 2
                denominator /= 2

            }
        }
        while (numerator % 2 == 0 && denominator % 2 == 0) {
            numerator /= 2
            denominator /= 2
        }
    }

    override fun addFractions(other: Any?) { //წილადების დამატება
        var equalizeDenominators = 0

    }

    override fun divideFractions() { //წილადების გაყოფა
        TODO("Not yet implemented")
    }

    override fun multiplyFractions() { // წილადების გამრავლება
        TODO("Not yet implemented")
    }

    override fun subtractFractions() { // წილადების გამოკლება
        TODO("Not yet implemented")
    }

    override fun findLCM(other: Any?): Int { // უმცირესი საერთო ჯერადი
        if (other is Fraction) {
            val gcd = findGCD(other)
            val lcm = denominator * other.denominator
        }
        return 0
    }
    override fun findGCD(other: Any?): Int { // უდიდესი საერთო გამყოფი
        var gcd = 1
        var i = 1
        if (other is Fraction) {
            while (i <= denominator && i <= other.denominator) {
                if (denominator % i == 0 && other.denominator % i == 0)
                    gcd = i
                ++i
            }

        }
        return gcd
    }
}