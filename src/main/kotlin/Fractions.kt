fun main() {
    var f1 = Fraction(12,15)

    var f2 = Fraction(9,12)

    println(f1)
    println(f1==f2)
    f1.simplifyFraction()
    println(f1)

    f1.subtractFractions(f2)
    f1.simplifyFraction()
    println(f1)

    f1.addFractions(f2)
    f1.simplifyFraction()
    println(f1)

    f1.divideFractions(f2)
    f1.simplifyFraction()
    println(f1)

    f1.multiplyFractions(f2)
    f1.simplifyFraction()
    println(f1)
}

interface FractionMaths {
        fun simplifyFraction() // გამარტივება
        fun addFractions(other: Any?) // დამატება
        fun subtractFractions(other: Any?) // გამოკლება
        fun multiplyFractions(other: Any?) // გამრავლება
        fun divideFractions(other: Any?) // გაყოფა
}

open class Fraction(public var numerator: Int, public var denominator: Int): FractionMaths {

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
        var gcd1 = gcd(numerator, denominator)
        numerator /= gcd1
        denominator /= gcd1
    }

    override fun addFractions(other: Any?) { //წილადების დამატება
         if (other is Fraction) {
             var gcds=gcd(denominator,other.denominator)
             val finDenominator = (denominator * other.denominator)/gcds
             val finNumerator = ((numerator) * (finDenominator/denominator) + (other.numerator) * (finDenominator/other.denominator))
             numerator = finNumerator
             denominator = finDenominator
         }
    }

    override fun subtractFractions(other: Any?) { // წილადების გამოკლება
        if (other is Fraction) {
            var gcds=gcd(denominator,other.denominator)
            val finDenominator = (denominator * other.denominator)/gcds
            val finNumerator = ((numerator) * (finDenominator/denominator) - (other.numerator) * (finDenominator/other.denominator))
            numerator = finNumerator
            denominator = finDenominator
        }
    }

    override fun divideFractions(other: Any?) { //წილადების გაყოფა
        if (other is Fraction) {
            val finDenominator = denominator * other.numerator
            val finNumerator = numerator * other.denominator
            denominator = finDenominator
            numerator = finNumerator
        }
    }

    override fun multiplyFractions(other: Any?) { // წილადების გამრავლება
        if (other is Fraction) {
            val finDenominator = denominator * other.denominator
            val finNumerator = numerator * other.numerator
            denominator = finDenominator
            numerator = finNumerator
        }
    }
}

public fun gcd(a: Int, b: Int): Int {
    if (a == 0) {
        return b
    }
    return gcd(b%a, a)
}