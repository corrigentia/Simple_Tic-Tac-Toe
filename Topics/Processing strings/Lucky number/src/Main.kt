fun main() {
    // write your code here
    val numberDigits = readLine()!!
    var firstSum = 0
    var lastSum = 0

    /*
    for (index in 0 until numberDigits.length / 2) {
        firstSum += numberDigits[index].digitToInt()
    }

    for (index in numberDigits.length / 2..numberDigits.lastIndex) {
        lastSum += numberDigits[index].digitToInt()
    }
     */

    for (index in numberDigits.indices) {
        if (index < numberDigits.length / 2) {
            firstSum += numberDigits[index].digitToInt()
        } else lastSum += numberDigits[index].digitToInt()
    }

    // println("firstSum: $firstSum; lastSum: $lastSum")

    println(
        if (firstSum == lastSum) "YES" else "NO"
    )

    /**
     * Hint
     To get the int value that the character actually represents you can use one of these methods:
     val charValue = '2'

     val intValue0 = charValue.digitToInt() //2
     val intValue1 = charValue.toString().toInt() // 2
     val intValue2 = Character.getNumericValue(charValue) // 2

     This is an incorrect way to get the int value, because toInt() returns ASCII code of the character:
     val charValue = '2'
     val intValue = charValue.toInt() // 50, which is ASCII code for character ‘2’
     */
}
