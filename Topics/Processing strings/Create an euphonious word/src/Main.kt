private const val THREE = 3

fun main() {
    // write your code here
    val startingWord = readLine()!!
    val vowels = "aeiouy"
    var minCharsForEuphony = 0
    var consecutiveVowels = 0
    var consecutiveConsonants = 0

    for (letter in startingWord) {
        if (letter in vowels) {
            consecutiveConsonants = 0
            consecutiveVowels++

            if (consecutiveVowels == THREE) {
                minCharsForEuphony++
                consecutiveVowels = 1
            }
        } else {
            consecutiveVowels = 0
            consecutiveConsonants++

            if (consecutiveConsonants == THREE) {
                minCharsForEuphony++
                consecutiveConsonants = 1
            }
        }
    }

    // qtyInsertsForVowels = (qtyOfConsecutiveVowels - 1) / 2
    /*
    if (consecutiveVowels > 0) {
        minCharsForEuphony = (consecutiveVowels - 1) / 2
    }

    if (consecutiveConsonants > 0) {
        minCharsForEuphony = (consecutiveConsonants - 1) / 2
    }
     */

    println(minCharsForEuphony)
    // println("-1 / 2 = ${-1 / 2}")
    /*
    1 a 0
    2 aa 0
    3 aaa 1
    4 aaaa 1
    5 aaaaa 2
    6 aaaaaa 2
    7 aaaaaaa 3
    8 aaaaaaaa 3
    9 aaaaaaaaa 4
    10 aaaaaaaaaa 4
     */
}
