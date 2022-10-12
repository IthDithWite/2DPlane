fun main() {
    var f1 = Fraction(5,10)

    var f2 = Fraction(9,12)

    println(f1.toString())
    println(f1)

    println(f1.equals(f2))
    println(f1==f2)

}

interface FractionMaths {
        fun simplifyFraction() // გამარტივება
        fun findGCD(): Int // უდიდესი გამყოფი
        fun subtractFractions() // გამოკლება
        fun multiplyFractions() // გამრავლება
        fun divideFractions() // გაყოფა
}

open class Fraction(private var numerator: Int, private var denominator: Int): FractionMaths {

    override fun toString(): String { // გამოტანა
        return "$numerator / $denominator"
    }

    override fun equals(other: Any?): Boolean { // გატოლება
        if (other is Fraction) {
            if (numerator * other.denominator == other.denominator * numerator) {
                return true
            }
        }
        return false
    }

    override fun simplifyFraction() { // წილადის გამარტივება
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
         if (other is Fraction) {
             return findGCD(other)
         }
    }

    override fun subtractFractions() { // წილადების გამოკლება
        TODO("Not yet implemented")
    }

    override fun divideFractions() { //წილადების გაყოფა
        TODO("Not yet implemented")
    }

    override fun multiplyFractions() { // წილადების გამრავლება
        TODO("Not yet implemented")
    }

}

fun findGCD(n1: Int,n2: Int): Int { // უდიდესი საერთო გამყოფი
    var gcd = 1
    var i = 1
    while (i <= n1 && i <= n2) {
        if (n1 % i == 0 && n2 % i == 0)
            gcd = i
        ++i
    }
    return gcd
}

fun findLCM(n1: Int,n2: Int): Int { // უმცირესი საერთო ჯერადი
    val gcd = findGCD(n1,n2)
    val lcm = n1 * n2 / gcd
    return lcm
}