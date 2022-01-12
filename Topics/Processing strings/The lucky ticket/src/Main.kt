fun main() {
    // write your code here
    val ticket = readLine()!!
    var firstSum = 0
    var lastSum = 0

    /*
    for (index in 0 until ticket.length / 2) {
        firstSum += ticket[index].digitToInt()
    }

    for (index in ticket.length / 2..ticket.lastIndex) {
        lastSum += ticket[index].digitToInt()
    }
     */

    for (index in ticket.indices) {
        if (index < ticket.length / 2) {
            firstSum += ticket[index].digitToInt()
        } else lastSum += ticket[index].digitToInt()
    }

    // println("firstSum: $firstSum; lastSum: $lastSum")

    println(
        if (firstSum == lastSum) "Lucky" else "Regular"
    )

    /**
     *
     Hint
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
