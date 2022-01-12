fun main() {
    // write your code here
    val word = readLine()!!
    val wordLength = word.length
    val wordHasEvenLength = wordLength % 2 == 0
    val secondHalf = word.substring(wordLength / 2 + 1)

    /*
    if (wordHasEvenLength) {
        println(word.substring(0, wordLength / 2 - 1) + secondHalf)
    } else {
        println(word.substring(0, wordLength / 2) + secondHalf)
    }
     */

    println(
        word.substring(
            0, wordLength / 2 - if (wordHasEvenLength) 1 else 0
        ) + secondHalf
    )
}
