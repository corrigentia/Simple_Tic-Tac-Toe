fun main() {
    // write your code here
    val randomLetters = readLine()!!
    var sequential = true
    // randomLetters in ('a'..'z').joinToString("")
    if (randomLetters.length > 1) {
        for (index in 0 until randomLetters.lastIndex) {
            if (randomLetters[index] + 1 != randomLetters[index + 1]) sequential = false
        }
    }

    println(sequential)
}
