fun main() {
    // write your code here
    val (upper, lower, digits, chars) = readLine()!!.split(" ").map { it.toInt() }
    val upperPossibilities = ('A'..'Z').joinToString("")
    val lowerPossibilities = ('a'..'z').joinToString("")
    val digitPossibilities = ('0'..'9').joinToString("")
    val remainder = "z$upperPossibilities$lowerPossibilities$digitPossibilities"
    var password = ""

    repeat(upper) {
        password += "${upperPossibilities[it % upperPossibilities.length]}"
    }

    repeat(lower) {
        password += "${lowerPossibilities[it % lowerPossibilities.length]}"
    }

    repeat(digits) {
        password += "${digitPossibilities[it % digitPossibilities.length]}"
    }

    repeat(chars - upper - lower - digits) {
        password += "${remainder[it % remainder.length]}"
    }

    println(password)
}
