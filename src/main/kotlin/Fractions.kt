fun main() {
    val f1 = Fraction(12,15)

    val f2 = Fraction(9,12)

    println(f1)
    println(f1==f2)
    f1.simplifyFraction()
    println(f1)
    f2.simplifyFraction()

    println(f1.subtractFractions(f2))

    println(f1.addFractions(f2))

    println(f1.divideFractions(f2))

    println(f1.multiplyFractions(f2))
}

interface FractionMaths {
        fun simplifyFraction() // გამარტივება
        fun addFractions(other: Any?): Any? // დამატება
        fun subtractFractions(other: Any?): Any? // გამოკლება
        fun multiplyFractions(other: Any?): Any? // გამრავლება
        fun divideFractions(other: Any?): Any? // გაყოფა
}

open class Fraction(protected var numerator: Int, protected var denominator: Int): FractionMaths {

    override fun toString(): String { // გამოტანა
        return "$numerator / $denominator"
    }

    override fun equals(other: Any?): Boolean { // გატოლება
        if (other is Fraction) {
            if (numerator * other.denominator == other.numerator * denominator) {
                return true
            }
            return false
        }
        return false
    }

    override fun simplifyFraction() { // წილადის გამარტივება
        val gcd1 = gcd(numerator, denominator)
        numerator /= gcd1
        denominator /= gcd1
    }

    override fun addFractions(other: Any?): Any? { //წილადების დამატება
         if (other is Fraction) {
             val gcds=gcd(denominator,other.denominator)
             val finDenominator = (denominator * other.denominator)/gcds
             val finNumerator = ((numerator) * (finDenominator/denominator) + (other.numerator) * (finDenominator/other.denominator))
             return Fraction(finNumerator,finDenominator)
         }
        return Fraction(numerator,denominator)
    }

    override fun subtractFractions(other: Any?): Any? { // წილადების გამოკლება
        if (other is Fraction) {
            val gcds=gcd(denominator,other.denominator)
            val finDenominator: Int  = (denominator * other.denominator)/gcds
            val finNumerator: Int = ((numerator) * (finDenominator/denominator) - (other.numerator) * (finDenominator/other.denominator))
            return Fraction(finNumerator, finDenominator)
        }
        return Fraction(numerator, denominator)
    }

    override fun divideFractions(other: Any?): Any? { //წილადების გაყოფა
        if (other is Fraction) {
            val finDenominator = denominator * other.numerator
            val finNumerator = numerator * other.denominator
            return Fraction(finNumerator, finDenominator)
        }
        return Fraction(numerator, denominator)
    }

    override fun multiplyFractions(other: Any?): Any? { // წილადების გამრავლება
        if (other is Fraction) {
            val finDenominator = denominator * other.denominator
            val finNumerator = numerator * other.numerator
            return Fraction(finNumerator, finDenominator)
        }
        return Fraction(numerator, denominator)
    }
}

fun gcd(a: Int, b: Int): Int {
    if (a == 0) {
        return b
    }
    return gcd(b%a, a)
}