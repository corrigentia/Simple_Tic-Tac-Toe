fun main() {
    // write your code here
    val startingWord = readLine()!!
    var doubledLetters = ""

    for (char in startingWord) {
        doubledLetters += "$char$char"
    }
    println(doubledLetters)
}
