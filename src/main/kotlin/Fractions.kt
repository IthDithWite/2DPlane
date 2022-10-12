fun main() {
    var f1 = Fraction(5,10)

    var f2 = Fraction(9,12)

    println(f1.toString())
    println(f1)

    println(f1.equals(f2))
    println(f1==f2)

    println(f1.addFractions(f2))
}

interface FractionMaths {
        fun simplifyFraction() // გამარტივება
        fun addFractions(other: Any?) // დამატება
        fun subtractFractions(other: Any?) // გამოკლება
        fun multiplyFractions(other: Any?) // გამრავლება
        fun divideFractions(other: Any?) // გაყოფა
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
            numerator/=3
            denominator/=3
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
            val finNumerator = ((numerator) * (finDenominator/denominator) - (other.numerator) - (finDenominator/other.denominator))
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